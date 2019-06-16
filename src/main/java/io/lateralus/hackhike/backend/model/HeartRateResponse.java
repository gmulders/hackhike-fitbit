package io.lateralus.hackhike.backend.model;

import com.google.api.client.util.Key;

public class HeartRateResponse {

    @Key("activities-heart-intraday")
    private HeartIntraday activitiesHeartIntraday;

    public HeartIntraday getActivitiesHeartIntraday() {
        return activitiesHeartIntraday;
    }

    public void setActivitiesHeartIntraday(HeartIntraday activitiesHeartIntraday) {
        this.activitiesHeartIntraday = activitiesHeartIntraday;
    }
}
