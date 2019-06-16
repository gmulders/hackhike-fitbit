package io.lateralus.hackhike.backend;

import java.io.IOException;
import java.io.InputStreamReader;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.common.io.CharStreams;
import io.lateralus.hackhike.backend.model.ActivitiesResponse;
import io.lateralus.hackhike.backend.model.Activity;
import io.lateralus.hackhike.backend.model.HeartIntraday;
import io.lateralus.hackhike.backend.model.HeartRateResponse;
import io.lateralus.hackhike.backend.model.User;
import io.lateralus.hackhike.backend.model.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EenService {

    private static final Logger log = LoggerFactory.getLogger(EenService.class);
    private static final GenericUrl USER_PROFILE_URL = new GenericUrl("https://api.fitbit.com/1/user/-/profile.json");
    private static final GenericUrl ACTIVITIES_URL = new GenericUrl("https://api.fitbit.com/1/user/-/activities.json");

    private final AuthorizationCodeFlow authorizationCodeFlow;
    private final JacksonFactory jacksonFactory;
    private final HttpTransport httpTransport;

    public EenService(AuthorizationCodeFlow authorizationCodeFlow, JacksonFactory jacksonFactory, HttpTransport httpTransport) {
        this.authorizationCodeFlow = authorizationCodeFlow;
        this.jacksonFactory = jacksonFactory;
        this.httpTransport = httpTransport;
    }

    public User fetchUser(Url57 userId) throws IOException {
        final Credential credential = authorizationCodeFlow.loadCredential(userId.toString());
        HttpResponse httpResponse = Util.executeGet(httpTransport, credential, USER_PROFILE_URL);
        return jacksonFactory.createJsonParser(httpResponse.getContent(), httpResponse.getContentCharset())
                .parse(UserResponse.class)
                .getUser();
    }

    public Activity fetchLifeTimeActivity(Url57 userId) throws IOException {
        final Credential credential = authorizationCodeFlow.loadCredential(userId.toString());
        HttpResponse httpResponse = Util.executeGet(httpTransport, credential, ACTIVITIES_URL);
        return jacksonFactory.createJsonParser(httpResponse.getContent(), httpResponse.getContentCharset())
                .parse(ActivitiesResponse.class)
                .getLifetime()
                .getTotal();
    }

    public void subscribe(Url57 userId) throws IOException {
        final Credential credential = authorizationCodeFlow.loadCredential(userId.toString());
        final GenericUrl url = new GenericUrl("https://api.fitbit.com/1/user/-/apiSubscriptions/" + userId.toString() + ".json");
        HttpResponse httpResponse = Util.executePost(httpTransport, credential, url);

        log.debug("subscribe result: {}", httpResponse.getStatusCode());
    }

    public HeartIntraday latestHeartRate(Url57 userId) throws IOException {
        final Credential credential = authorizationCodeFlow.loadCredential(userId.toString());
        final GenericUrl url = new GenericUrl("https://api.fitbit.com/1/user/-/activities/heart/date/today/1d/1sec.json");
        HttpResponse httpResponse = Util.executeGet(httpTransport, credential, url);


        InputStreamReader reader = new InputStreamReader(httpResponse.getContent(), httpResponse.getContentCharset());
        String targetString = CharStreams.toString(reader);

        log.debug(targetString);

        HeartIntraday heartIntraday = jacksonFactory.createJsonParser(targetString)
                .parse(HeartRateResponse.class)
                .getActivitiesHeartIntraday();

        return heartIntraday;
    }
}
