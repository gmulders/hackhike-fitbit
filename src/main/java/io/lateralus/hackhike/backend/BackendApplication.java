package io.lateralus.hackhike.backend;

import java.io.IOException;
import java.util.List;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.http.BasicAuthentication;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;
import com.google.common.collect.Lists;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class BackendApplication {


	public static final String REDIRECT_URL = "...";
	private static final String TOKEN_URL = "https://api.fitbit.com/oauth2/token";
	private static final String CLIENT_ID = "...";
	private static final String CLIENT_SECRET = "...";
	private static final String AUTHORIZE_URL = "https://www.fitbit.com/oauth2/authorize";
	private static final List<String> SCOPES = Lists.newArrayList("activity", "heartrate", "location", "nutrition",
			"profile", "settings", "sleep", "social", "weight");

	@Bean
	public HttpTransport httpTransport() {
		return new NetHttpTransport();
	}

	@Bean
	public JacksonFactory jacksonFactory() {
		return new JacksonFactory();
	}

	@Bean
	public AuthorizationCodeFlow authorizationCodeFlow(HttpTransport httpTransport, JacksonFactory jacksonFactory) throws IOException {
		return new AuthorizationCodeFlow.Builder(
				BearerToken.authorizationHeaderAccessMethod(),
				httpTransport,
				jacksonFactory,
				new GenericUrl(TOKEN_URL),
				new BasicAuthentication(CLIENT_ID, CLIENT_SECRET),
				CLIENT_ID,
				AUTHORIZE_URL)
		.setScopes(SCOPES)
		.setCredentialDataStore(StoredCredential.getDefaultDataStore(new MemoryDataStoreFactory()))
		.build();
	}

	@Bean
	public EenService eenService(AuthorizationCodeFlow authorizationCodeFlow, JacksonFactory jacksonFactory, HttpTransport httpTransport) {
		return new EenService(authorizationCodeFlow, jacksonFactory, httpTransport);
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
}
