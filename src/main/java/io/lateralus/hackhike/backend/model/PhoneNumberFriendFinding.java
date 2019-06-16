package io.lateralus.hackhike.backend.model;

import java.util.List;

import com.google.api.client.util.Key;

public class PhoneNumberFriendFinding {
    @Key
    private String salt;
    @Key
    private List<String> countries;
    @Key
    private String algorithm;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
