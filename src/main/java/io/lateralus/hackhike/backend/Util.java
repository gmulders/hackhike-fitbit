package io.lateralus.hackhike.backend;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import org.springframework.web.util.WebUtils;

public class Util {

    public static final String COOKIE_NAME = "FUCK-YOU-COOKIE";

    public static Optional<Url57> determineUserId(HttpServletRequest request) {
        // Als er een cookie is voor de gebuiker gebruiken we de waarde van het cookie om de gebuiker te authenticeren.
        Cookie cookie = WebUtils.getCookie(request, COOKIE_NAME);
        return Optional.ofNullable(cookie)
                .map(Cookie::getValue)
                .map(Url57::fromString);
    }

    public static HttpResponse executeGet(HttpTransport transport, Credential credential, GenericUrl url) throws IOException {
        HttpRequestFactory requestFactory = transport.createRequestFactory(credential);
        return requestFactory.buildGetRequest(url).execute();
    }

    public static HttpResponse executePost(HttpTransport transport, Credential credential, GenericUrl url) throws IOException {
        HttpRequestFactory requestFactory = transport.createRequestFactory(credential);
        return requestFactory.buildPostRequest(url, new EmptyContent()).execute();
    }

}
