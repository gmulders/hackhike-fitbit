package io.lateralus.hackhike.backend.model;

import java.util.List;

import com.google.api.client.util.Key;

public class Badge {
    @Key
    private String dateTime;
    @Key
    private int timesAchieved;
    @Key
    private String badgeGradientStartColor;
    @Key
    private String image100px;
    @Key
    private String image50px;
    @Key
    private String shareImage640px;
    @Key
    private String description;
    @Key
    private String shortDescription;
    @Key
    private String badgeGradientEndColor;
    @Key
    private String encodedId;
    @Key
    private String earnedMessage;
    @Key
    private String badgeType;
    @Key
    private String image300px;
    @Key
    private String marketingDescription;
    @Key
    private String name;
    @Key
    private String shareText;
    @Key
    private String image125px;
    @Key
    private String image75px;
    @Key
    private String category;
    @Key
    private String shortName;
    @Key
    private int value;
    @Key
    private List<Cheer> cheers;
    @Key
    private String mobileDescription;
    @Key
    private String unit;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getTimesAchieved() {
        return timesAchieved;
    }

    public void setTimesAchieved(int timesAchieved) {
        this.timesAchieved = timesAchieved;
    }

    public String getBadgeGradientStartColor() {
        return badgeGradientStartColor;
    }

    public void setBadgeGradientStartColor(String badgeGradientStartColor) {
        this.badgeGradientStartColor = badgeGradientStartColor;
    }

    public String getImage100px() {
        return image100px;
    }

    public void setImage100px(String image100px) {
        this.image100px = image100px;
    }

    public String getImage50px() {
        return image50px;
    }

    public void setImage50px(String image50px) {
        this.image50px = image50px;
    }

    public String getShareImage640px() {
        return shareImage640px;
    }

    public void setShareImage640px(String shareImage640px) {
        this.shareImage640px = shareImage640px;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getBadgeGradientEndColor() {
        return badgeGradientEndColor;
    }

    public void setBadgeGradientEndColor(String badgeGradientEndColor) {
        this.badgeGradientEndColor = badgeGradientEndColor;
    }

    public String getEncodedId() {
        return encodedId;
    }

    public void setEncodedId(String encodedId) {
        this.encodedId = encodedId;
    }

    public String getEarnedMessage() {
        return earnedMessage;
    }

    public void setEarnedMessage(String earnedMessage) {
        this.earnedMessage = earnedMessage;
    }

    public String getBadgeType() {
        return badgeType;
    }

    public void setBadgeType(String badgeType) {
        this.badgeType = badgeType;
    }

    public String getImage300px() {
        return image300px;
    }

    public void setImage300px(String image300px) {
        this.image300px = image300px;
    }

    public String getMarketingDescription() {
        return marketingDescription;
    }

    public void setMarketingDescription(String marketingDescription) {
        this.marketingDescription = marketingDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShareText() {
        return shareText;
    }

    public void setShareText(String shareText) {
        this.shareText = shareText;
    }

    public String getImage125px() {
        return image125px;
    }

    public void setImage125px(String image125px) {
        this.image125px = image125px;
    }

    public String getImage75px() {
        return image75px;
    }

    public void setImage75px(String image75px) {
        this.image75px = image75px;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Cheer> getCheers() {
        return cheers;
    }

    public void setCheers(List<Cheer> cheers) {
        this.cheers = cheers;
    }

    public String getMobileDescription() {
        return mobileDescription;
    }

    public void setMobileDescription(String mobileDescription) {
        this.mobileDescription = mobileDescription;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
