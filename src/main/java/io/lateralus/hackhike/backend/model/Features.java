package io.lateralus.hackhike.backend.model;

import com.google.api.client.util.Key;

public class Features{
    @Key
    private boolean exerciseGoal;
    @Key
    private PhoneNumberFriendFinding phoneNumberFriendFinding;

    public boolean isExerciseGoal() {
        return exerciseGoal;
    }

    public void setExerciseGoal(boolean exerciseGoal) {
        this.exerciseGoal = exerciseGoal;
    }

    public PhoneNumberFriendFinding getPhoneNumberFriendFinding() {
        return phoneNumberFriendFinding;
    }

    public void setPhoneNumberFriendFinding(PhoneNumberFriendFinding phoneNumberFriendFinding) {
        this.phoneNumberFriendFinding = phoneNumberFriendFinding;
    }
}
