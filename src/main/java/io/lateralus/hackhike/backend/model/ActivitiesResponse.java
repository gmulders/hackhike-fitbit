package io.lateralus.hackhike.backend.model;

import com.google.api.client.util.Key;

public class ActivitiesResponse {

    @Key
    private Lifetime lifetime;

    public Lifetime getLifetime() {
        return lifetime;
    }

    public void setLifetime(Lifetime lifetime) {
        this.lifetime = lifetime;
    }
}
