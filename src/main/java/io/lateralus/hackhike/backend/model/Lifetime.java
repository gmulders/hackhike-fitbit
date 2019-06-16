package io.lateralus.hackhike.backend.model;

import com.google.api.client.util.Key;

public class Lifetime {
    @Key
    private Activity total;


    public Activity getTotal() {
        return total;
    }

    public void setTotal(Activity total) {
        this.total = total;
    }
}
