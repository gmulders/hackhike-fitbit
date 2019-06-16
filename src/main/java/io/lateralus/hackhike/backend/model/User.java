package io.lateralus.hackhike.backend.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.google.api.client.util.Key;

public class User{
    @Key
    private String country;
    @Key
    private String distanceUnit;
    @Key
    private String lastName;
    @Key
    private String gender;
    @Key
    private String displayName;
    @Key
    private String timezone;
    @Key
    private String waterUnit;
    @Key
    private boolean sdkDeveloper;
    @Key
    private String avatar640;
    @Key
    private String clockTimeDisplayFormat;
    @Key
    private String displayNameSetting;
    @Key
    private String locale;
    @Key
    private Integer offsetFromUTCMillis;
    @Key
    private String foodsLocale;
    @Key
    private String strideLengthRunningType;
    @Key
    private boolean autoStrideEnabled;
    @Key
    private Features features;
    @Key
    private String memberSince;
    @Key
    private String waterUnitName;
    @Key
    private boolean mfaEnabled;
    @Key
    private String heightUnit;
    @Key
    private boolean isChild;
    @Key
    private Integer height;
    @Key
    private double strideLengthWalking;
    @Key
    private String avatar150;
    @Key
    private List<Badge> topBadges;
    @Key
    private boolean isBugReportEnabled;
    @Key
    private boolean familyGuidanceEnabled;
    @Key
    private BigDecimal strideLengthRunning;
    @Key
    private String languageLocale;
    @Key
    private String sleepTracking;
    @Key
    private String fullName;
    @Key
    private BigDecimal weight;
    @Key
    private String dateOfBirth;
    @Key
    private String avatar;
    @Key
    private String encodedId;
    @Key
    private String swimUnit;
    @Key
    private String startDayOfWeek;
    @Key
    private String firstName;
    @Key
    private String glucoseUnit;
    @Key
    private boolean corporate;
    @Key
    private boolean challengesBeta;
    @Key
    private boolean ambassador;
    @Key
    private String strideLengthWalkingType;
    @Key
    private boolean corporateAdmin;
    @Key
    private Integer averageDailySteps;
    @Key
    private Integer age;
    @Key
    private String weightUnit;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return sdkDeveloper == user.sdkDeveloper &&
                autoStrideEnabled == user.autoStrideEnabled &&
                mfaEnabled == user.mfaEnabled &&
                isChild == user.isChild &&
                Double.compare(user.strideLengthWalking, strideLengthWalking) == 0 &&
                isBugReportEnabled == user.isBugReportEnabled &&
                familyGuidanceEnabled == user.familyGuidanceEnabled &&
                corporate == user.corporate &&
                challengesBeta == user.challengesBeta &&
                ambassador == user.ambassador &&
                corporateAdmin == user.corporateAdmin &&
                Objects.equals(country, user.country) &&
                Objects.equals(distanceUnit, user.distanceUnit) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(displayName, user.displayName) &&
                Objects.equals(timezone, user.timezone) &&
                Objects.equals(waterUnit, user.waterUnit) &&
                Objects.equals(avatar640, user.avatar640) &&
                Objects.equals(clockTimeDisplayFormat, user.clockTimeDisplayFormat) &&
                Objects.equals(displayNameSetting, user.displayNameSetting) &&
                Objects.equals(locale, user.locale) &&
                Objects.equals(offsetFromUTCMillis, user.offsetFromUTCMillis) &&
                Objects.equals(foodsLocale, user.foodsLocale) &&
                Objects.equals(strideLengthRunningType, user.strideLengthRunningType) &&
                Objects.equals(features, user.features) &&
                Objects.equals(memberSince, user.memberSince) &&
                Objects.equals(waterUnitName, user.waterUnitName) &&
                Objects.equals(heightUnit, user.heightUnit) &&
                Objects.equals(height, user.height) &&
                Objects.equals(avatar150, user.avatar150) &&
                Objects.equals(topBadges, user.topBadges) &&
                Objects.equals(strideLengthRunning, user.strideLengthRunning) &&
                Objects.equals(languageLocale, user.languageLocale) &&
                Objects.equals(sleepTracking, user.sleepTracking) &&
                Objects.equals(fullName, user.fullName) &&
                Objects.equals(weight, user.weight) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(avatar, user.avatar) &&
                Objects.equals(encodedId, user.encodedId) &&
                Objects.equals(swimUnit, user.swimUnit) &&
                Objects.equals(startDayOfWeek, user.startDayOfWeek) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(glucoseUnit, user.glucoseUnit) &&
                Objects.equals(strideLengthWalkingType, user.strideLengthWalkingType) &&
                Objects.equals(averageDailySteps, user.averageDailySteps) &&
                Objects.equals(age, user.age) &&
                Objects.equals(weightUnit, user.weightUnit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, distanceUnit, lastName, gender, displayName, timezone, waterUnit, sdkDeveloper,
                avatar640, clockTimeDisplayFormat, displayNameSetting, locale, offsetFromUTCMillis, foodsLocale,
                strideLengthRunningType, autoStrideEnabled, features, memberSince, waterUnitName, mfaEnabled,
                heightUnit, isChild, height, strideLengthWalking, avatar150, topBadges, isBugReportEnabled,
                familyGuidanceEnabled, strideLengthRunning, languageLocale, sleepTracking, fullName, weight,
                dateOfBirth, avatar, encodedId, swimUnit, startDayOfWeek, firstName, glucoseUnit, corporate,
                challengesBeta, ambassador, strideLengthWalkingType, corporateAdmin, averageDailySteps, age,
                weightUnit);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistanceUnit() {
        return distanceUnit;
    }

    public void setDistanceUnit(String distanceUnit) {
        this.distanceUnit = distanceUnit;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getWaterUnit() {
        return waterUnit;
    }

    public void setWaterUnit(String waterUnit) {
        this.waterUnit = waterUnit;
    }

    public boolean isSdkDeveloper() {
        return sdkDeveloper;
    }

    public void setSdkDeveloper(boolean sdkDeveloper) {
        this.sdkDeveloper = sdkDeveloper;
    }

    public String getAvatar640() {
        return avatar640;
    }

    public void setAvatar640(String avatar640) {
        this.avatar640 = avatar640;
    }

    public String getClockTimeDisplayFormat() {
        return clockTimeDisplayFormat;
    }

    public void setClockTimeDisplayFormat(String clockTimeDisplayFormat) {
        this.clockTimeDisplayFormat = clockTimeDisplayFormat;
    }

    public String getDisplayNameSetting() {
        return displayNameSetting;
    }

    public void setDisplayNameSetting(String displayNameSetting) {
        this.displayNameSetting = displayNameSetting;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Integer getOffsetFromUTCMillis() {
        return offsetFromUTCMillis;
    }

    public void setOffsetFromUTCMillis(Integer offsetFromUTCMillis) {
        this.offsetFromUTCMillis = offsetFromUTCMillis;
    }

    public String getFoodsLocale() {
        return foodsLocale;
    }

    public void setFoodsLocale(String foodsLocale) {
        this.foodsLocale = foodsLocale;
    }

    public String getStrideLengthRunningType() {
        return strideLengthRunningType;
    }

    public void setStrideLengthRunningType(String strideLengthRunningType) {
        this.strideLengthRunningType = strideLengthRunningType;
    }

    public boolean isAutoStrideEnabled() {
        return autoStrideEnabled;
    }

    public void setAutoStrideEnabled(boolean autoStrideEnabled) {
        this.autoStrideEnabled = autoStrideEnabled;
    }

    public Features getFeatures() {
        return features;
    }

    public void setFeatures(Features features) {
        this.features = features;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public String getWaterUnitName() {
        return waterUnitName;
    }

    public void setWaterUnitName(String waterUnitName) {
        this.waterUnitName = waterUnitName;
    }

    public boolean isMfaEnabled() {
        return mfaEnabled;
    }

    public void setMfaEnabled(boolean mfaEnabled) {
        this.mfaEnabled = mfaEnabled;
    }

    public String getHeightUnit() {
        return heightUnit;
    }

    public void setHeightUnit(String heightUnit) {
        this.heightUnit = heightUnit;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public double getStrideLengthWalking() {
        return strideLengthWalking;
    }

    public void setStrideLengthWalking(double strideLengthWalking) {
        this.strideLengthWalking = strideLengthWalking;
    }

    public String getAvatar150() {
        return avatar150;
    }

    public void setAvatar150(String avatar150) {
        this.avatar150 = avatar150;
    }

    public List<Badge> getTopBadges() {
        return topBadges;
    }

    public void setTopBadges(List<Badge> topBadges) {
        this.topBadges = topBadges;
    }

    public boolean isBugReportEnabled() {
        return isBugReportEnabled;
    }

    public void setBugReportEnabled(boolean bugReportEnabled) {
        isBugReportEnabled = bugReportEnabled;
    }

    public boolean isFamilyGuidanceEnabled() {
        return familyGuidanceEnabled;
    }

    public void setFamilyGuidanceEnabled(boolean familyGuidanceEnabled) {
        this.familyGuidanceEnabled = familyGuidanceEnabled;
    }

    public BigDecimal getStrideLengthRunning() {
        return strideLengthRunning;
    }

    public void setStrideLengthRunning(BigDecimal strideLengthRunning) {
        this.strideLengthRunning = strideLengthRunning;
    }

    public String getLanguageLocale() {
        return languageLocale;
    }

    public void setLanguageLocale(String languageLocale) {
        this.languageLocale = languageLocale;
    }

    public String getSleepTracking() {
        return sleepTracking;
    }

    public void setSleepTracking(String sleepTracking) {
        this.sleepTracking = sleepTracking;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEncodedId() {
        return encodedId;
    }

    public void setEncodedId(String encodedId) {
        this.encodedId = encodedId;
    }

    public String getSwimUnit() {
        return swimUnit;
    }

    public void setSwimUnit(String swimUnit) {
        this.swimUnit = swimUnit;
    }

    public String getStartDayOfWeek() {
        return startDayOfWeek;
    }

    public void setStartDayOfWeek(String startDayOfWeek) {
        this.startDayOfWeek = startDayOfWeek;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGlucoseUnit() {
        return glucoseUnit;
    }

    public void setGlucoseUnit(String glucoseUnit) {
        this.glucoseUnit = glucoseUnit;
    }

    public boolean isCorporate() {
        return corporate;
    }

    public void setCorporate(boolean corporate) {
        this.corporate = corporate;
    }

    public boolean isChallengesBeta() {
        return challengesBeta;
    }

    public void setChallengesBeta(boolean challengesBeta) {
        this.challengesBeta = challengesBeta;
    }

    public boolean isAmbassador() {
        return ambassador;
    }

    public void setAmbassador(boolean ambassador) {
        this.ambassador = ambassador;
    }

    public String getStrideLengthWalkingType() {
        return strideLengthWalkingType;
    }

    public void setStrideLengthWalkingType(String strideLengthWalkingType) {
        this.strideLengthWalkingType = strideLengthWalkingType;
    }

    public boolean isCorporateAdmin() {
        return corporateAdmin;
    }

    public void setCorporateAdmin(boolean corporateAdmin) {
        this.corporateAdmin = corporateAdmin;
    }

    public Integer getAverageDailySteps() {
        return averageDailySteps;
    }

    public void setAverageDailySteps(Integer averageDailySteps) {
        this.averageDailySteps = averageDailySteps;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }
}
