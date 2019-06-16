package io.lateralus.hackhike.backend.model;

import com.google.api.client.util.Key;

public class UserResponse {
    @Key
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
