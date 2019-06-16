package io.lateralus.hackhike.backend;


import java.security.SecureRandom;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

/**
 *
 */
public final class Url57 {

	/**
	 * The base for the encoding.
	 */
	private static final long BASE = 57;

	/**
	 * The alphabet consisting of 57 characters.
	 */
	private static final char[] ALPHABET = "23456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();

	/**
	 * The inversed alphabet.
	 */
	private static final byte[] INVERSE_ALPHABET = new byte[128];
	static {
		Arrays.fill(INVERSE_ALPHABET, (byte)-1);
		for (int i = 0; i < ALPHABET.length; i++) {
			INVERSE_ALPHABET[ALPHABET[i]] = (byte) i;
		}
	}

	/**
	 * Magic for divisor 57 (see: https://github.com/ridiculousfish/libdivide)
	 */
	private static final long MAGIC = 0x8FB823EE08FB823FL;

	/**
	 * More for divisor 57 (see: https://github.com/ridiculousfish/libdivide)
	 */
	private static final int MORE = 5;

	/**
	 * Random number generator to use for the generation of byte arrays.
	 */
	private static Random random;

	/**
	 * The value of the Url57 in a String representation.
	 */
	private String value;

	/**
	 * The value of the Url57 in byte representation.
	 */
	private byte[] bytes;

	/**
	 * The hash value that represents this {@link Url57}.
	 */
	private int hash;

	/**
	 * Creates a Url57 object from a String.
	 * @param value The value to create the object from.
	 * @return A new Url57 object.
	 */
	public static Url57 fromString(String value) {
		if (value == null || value.length() != 22) {
			throw new IllegalArgumentException("The length of the array should be 22.");
		}

		Url57 url57 = new Url57();
		url57.value = value;
		return url57;
	}

	/**
	 * Creates a Url57 object from a byte array.
	 * @param bytes The bytes to create the object from.
	 * @return A new Url57 object.
	 */
	public static Url57 fromBytes(byte[] bytes) {
		if (bytes == null || bytes.length != 16) {
			throw new IllegalArgumentException("The length of the array should be 16.");
		}

		Url57 url57 = new Url57();
		url57.bytes = bytes;
		return url57;
	}

	/**
	 * Generates a new Url57 from 16 bytes from a {@link SecureRandom}.
	 * @return A new Url57 object.
	 */
	public static Url57 generateRandom(Random random) {
		byte[] bytes = new byte[16];

		long time = Instant.now().toEpochMilli();

		bytes[0] = (byte) ((time >> 40) & 0xff);
		bytes[1] = (byte) ((time >> 32) & 0xff);
		bytes[2] = (byte) ((time >> 24) & 0xff);
		bytes[3] = (byte) ((time >> 16) & 0xff);
		bytes[4] = (byte) ((time >> 8) & 0xff);
		bytes[5] = (byte) (time & 0xff);

		byte[] randomBytes = new byte[10];
		random.nextBytes(randomBytes);

		System.arraycopy(randomBytes, 0, bytes, 6, 10);

		return fromBytes(bytes);
	}

	public static Url57 generateRandom() {
		if (random == null) {
			random = new SecureRandom();
		}
		return generateRandom(random);
	}

	/**
	 * Returns the bytes value of the {@code Url57} object.
	 * @return a byte array of length 16.
	 */
	public byte[] bytes() {
		if (bytes != null) {
			return bytes;
		}
		bytes = decode(value);

		return bytes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		// We use the me
		return Arrays.equals(this.bytes(), ((Url57) o).bytes());
	}

	@Override
	public int hashCode() {
		int h = hash;
		if (h == 0) {
			// The hash code should be an integer number that is as unique as possible. Since the last part of the byte-
			// array is random, we can take the last 4 bytes of the bytes-array.
			final byte[] bytes = bytes();
			h = bytes[12] << 24 | (bytes[13] & 0xff) << 16 | (bytes[14] & 0xff) << 8 | (bytes[15] & 0xff);
			hash = h;
		}
		return h;
	}

	@Override
	public String toString() {
		if (value != null) {
			return value;
		}
		value = encode(bytes);

		return value;
	}

	/**
	 * Encodes the byte array into a String.
	 * @param bytes The bytes to encode.
	 * @return The String representation of the bytes.
	 */
	private static String encode(byte[] bytes) {
		// Create an array pre-filled with '0'.
		char[] chars = new char[22];

		encode(fromByteArray(bytes, 0), chars, 0);
		encode(fromByteArray(bytes, 8), chars, 11);

		return new String(chars);
	}

	/**
	 * Encodes a single long into a char array starting at the given offset.
	 *
	 * @param l The long to encode.
	 * @param dst The destination array of chars. This array should be at least offset + 11 chars long.
	 * @param offset The offset.
	 */
	private static void encode(long l, char[] dst, int offset) {
		for (int i = 10; i >= 0; i--) {

			// Divide l by 57
			long x = divideBy57(l);

			// Calculate the modulus of l and 57
			int mod = (int)(l - x * BASE);

			dst[i + offset] = ALPHABET[mod];

			l = x;
		}
	}

	/**
	 * Divides the given number by 57.
	 *
	 * @param y the number
	 * @return result of y / 57.
	 */
	private static long divideBy57(long y) {
		long x_high = MAGIC >>> 32;
		long y_high = y >>> 32;
		long x_low = MAGIC & 0xFFFFFFFFL;
		long y_low = y & 0xFFFFFFFFL;

		long z2 = x_low * y_low;
		long t = x_high * y_low + (z2 >>> 32);
		long z1 = t & 0xFFFFFFFFL;
		long z0 = t >>> 32;
		z1 += x_low * y_high;
		return (x_high * y_high + z0 + (z1 >>> 32)) >>> MORE;
	}

	/**
	 * Creates a long from the bytes from the array starting from the given offset.
	 *
	 * @param bytes The byte array to convert into a long. This array should be at least offset + 8 bytes long.
	 * @param offset The offset to start from.
	 * @return The long.
	 */
	private static long fromByteArray(byte[] bytes, int offset) {
		return fromBytes(bytes[offset], bytes[1 + offset], bytes[2 + offset], bytes[3 + offset], bytes[4 + offset],
				bytes[5 + offset], bytes[6 + offset], bytes[7 + offset]);
	}

	/**
	 * Creates a long from 8 separate bytes.
	 * @return the long.
	 */
	private static long fromBytes(byte b0, byte b1, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7) {
		return (b0 & 0xFFL) << 56
				| (b1 & 0xFFL) << 48
				| (b2 & 0xFFL) << 40
				| (b3 & 0xFFL) << 32
				| (b4 & 0xFFL) << 24
				| (b5 & 0xFFL) << 16
				| (b6 & 0xFFL) << 8
				| (b7 & 0xFFL);
	}

	/**
	 * Decodes a string into a byte array.
	 * @param value The value to decode.
	 * @return The byte array represented by the value.
	 */
	private static byte[] decode(String value) {
		byte[] bytes = new byte[16];
		fillByteArray(decode(value, 0), bytes, 0);
		fillByteArray(decode(value, 11), bytes, 8);
		return bytes;
	}

	/**
	 * Decodes a String from a given offset into a long.
	 *
	 * @param value The String to decode. This String should be at least 11 + offset characters long.
	 * @param offset The offset to start decoding from.
	 * @return The long represented by the String.
	 */
	private static long decode(String value, int offset) {
		long l = 0;
		for (int i = 0; i < 11; i++) {
			l *= 57;
			char c = value.charAt(i + offset);
			if (c >= INVERSE_ALPHABET.length) {
				throw new IllegalArgumentException("String contains invalid character.");
			}
			byte val = INVERSE_ALPHABET[c];
			if (val < 0) {
				throw new IllegalArgumentException("String contains invalid character.");
			}
			l += val;
		}
		return l;
	}

	/**
	 * Fills a byte array with the value of the long.
	 *
	 * @param value The value to fill into the array.
	 * @param dst The destination. This array should be at least 8 + offset bytes.
	 * @param offset The offset to start filling from.
	 */
	private static void fillByteArray(long value, byte[] dst, int offset) {
		for (int i = 7; i >= 0; i--) {
			dst[i + offset] = (byte) (value & 0xFFL);
			value >>>= 8;
		}
	}
}
