package io.lateralus.hackhike.backend;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.lateralus.hackhike.backend.BackendApplication.REDIRECT_URL;
import static io.lateralus.hackhike.backend.Util.COOKIE_NAME;
import static io.lateralus.hackhike.backend.Util.determineUserId;

@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    private final AuthorizationCodeFlow authorizationCodeFlow;

    public LoginController(AuthorizationCodeFlow authorizationCodeFlow) {
        this.authorizationCodeFlow = authorizationCodeFlow;
    }

    @GetMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("In login()");
        final Optional<Url57> optionalUserId = determineUserId(request);
        final Url57 userId;

        if (optionalUserId.isPresent()) {
            userId = optionalUserId.get();
        } else {
            // Als de userId niet gezet is, genereren we er nu een en zetten we deze op de response.
            userId = Url57.generateRandom();
            Cookie cookie = new Cookie(COOKIE_NAME, userId.toString());
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }

        // Nu hebben we een userId en er is ook een cookie.
        final Credential credential = authorizationCodeFlow.loadCredential(userId.toString());
        if (credential != null) {
            return;
        }

        final String url = authorizationCodeFlow.newAuthorizationUrl()
                .setRedirectUri(REDIRECT_URL)
                .build();
        response.sendRedirect(url);
    }

    @GetMapping("/login/rd")
    public void redirect(@RequestParam String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("In redirect()");
        TokenResponse tokenResponse = authorizationCodeFlow.newTokenRequest(code)
               .setRedirectUri(REDIRECT_URL)
               .execute();
        Url57 userId = determineUserId(request)
                .orElseThrow(() -> new IllegalStateException("Expected cookie with userId"));
        authorizationCodeFlow.createAndStoreCredential(tokenResponse, userId.toString());
        response.sendRedirect("/");
    }

}
