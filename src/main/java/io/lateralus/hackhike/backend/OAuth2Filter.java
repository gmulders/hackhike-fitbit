package io.lateralus.hackhike.backend;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import static io.lateralus.hackhike.backend.Util.determineUserId;

public class OAuth2Filter implements Filter {

    private final AuthorizationCodeFlow authorizationCodeFlow;

    public OAuth2Filter(AuthorizationCodeFlow authorizationCodeFlow) {
        this.authorizationCodeFlow = authorizationCodeFlow;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;

        final SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication oldAuthentication = securityContext.getAuthentication();

        Authentication authentication = oldAuthentication;

        final Optional<Url57> optionalUserId = determineUserId(request);
        if (optionalUserId.isPresent()) {
            final Url57 userId = optionalUserId.get();

            final Credential credential = authorizationCodeFlow.loadCredential(userId.toString());

            if (credential != null) {
                authentication = new PreAuthenticatedAuthenticationToken(userId, credential, null);
            }
        }


        securityContext.setAuthentication(authentication);

        try {
            chain.doFilter(servletRequest, servletResponse);
        } finally {
            securityContext.setAuthentication(oldAuthentication);
        }
    }
}
