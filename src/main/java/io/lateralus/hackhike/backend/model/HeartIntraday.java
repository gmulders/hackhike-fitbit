package io.lateralus.hackhike.backend.model;

import java.util.List;

import com.google.api.client.util.Key;

public class HeartIntraday {

    @Key
    private List<DatasetItem> dataset;

    public List<DatasetItem> getDataset() {
        return dataset;
    }

    public void setDataset(List<DatasetItem> dataset) {
        this.dataset = dataset;
    }
}
