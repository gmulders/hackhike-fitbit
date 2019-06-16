package io.lateralus.hackhike.backend.model;

import java.time.LocalDate;

import com.google.api.client.util.Key;

public class Notification {

    @Key
    private String collectionType;
    @Key
    private LocalDate date;
    @Key
    private String ownerId;
    @Key
    private String ownerType;
    @Key
    private String subscriptionId;

    @Override
    public String toString() {
        return "Notification{" +
                "collectionType='" + collectionType + '\'' +
                ", date=" + date +
                ", ownerId='" + ownerId + '\'' +
                ", ownerType='" + ownerType + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                '}';
    }

    public String getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(String collectionType) {
        this.collectionType = collectionType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
}
