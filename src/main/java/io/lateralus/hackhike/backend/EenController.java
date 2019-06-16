package io.lateralus.hackhike.backend;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import io.lateralus.hackhike.backend.model.Activity;
import io.lateralus.hackhike.backend.model.HeartIntraday;
import io.lateralus.hackhike.backend.model.Notification;
import io.lateralus.hackhike.backend.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EenController {

    private static final Logger log = LoggerFactory.getLogger(EenController.class);

    private static final String VERIFICATION_CODE = "...";

    private final AuthorizationCodeFlow authorizationCodeFlow;

    private final LoadingCache<Url57, User> userCache;

    private final EenService service;

    public EenController(AuthorizationCodeFlow authorizationCodeFlow, EenService service) {
        this.authorizationCodeFlow = authorizationCodeFlow;
        this.service = service;

        userCache = CacheBuilder.newBuilder()
//                .maximumSize(1000)
//                .expireAfterWrite(10, TimeUnit.MINUTES)
//                .removalListener(MY_LISTENER)
                .build(
                        new CacheLoader<Url57, User>() {
                            public User load(Url57 key) throws IOException {
                                return service.fetchUser(key);
                            }
                        });
    }

    @GetMapping("/user")
    public User user(Authentication authentication) throws ExecutionException, IOException {
        Url57 userId = (Url57)authentication.getPrincipal();
//        service.subscribe(userId);
        return userCache.get(userId);
    }

    @GetMapping("/lifetime-activity")
    public Activity lifeTimeActivity(Authentication authentication) throws IOException {
        Url57 userId = (Url57)authentication.getPrincipal();
        return service.fetchLifeTimeActivity(userId);
    }

    @GetMapping("/notifications")
    public void verify(@RequestParam String verify, HttpServletResponse response) {
        if (VERIFICATION_CODE.equals(verify)) {
            response.setStatus(204);
        } else {
            response.setStatus(404);
        }
    }

    @PostMapping("/notifications")
    public void notifications(@RequestBody List<Notification> notifications) {
        log.debug(Arrays.toString(notifications.toArray()));
    }

    @GetMapping("/latest-heartrate")
    public HeartIntraday latestHeartRate(Authentication authentication) throws IOException {
        Url57 userId = (Url57)authentication.getPrincipal();
        return service.latestHeartRate(userId);
    }
}
