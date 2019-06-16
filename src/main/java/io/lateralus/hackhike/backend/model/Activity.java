package io.lateralus.hackhike.backend.model;

import java.math.BigDecimal;

import com.google.api.client.util.Key;

public class Activity {

    @Key
    private BigDecimal activeScore;

    @Key
    private BigDecimal caloriesOut;

    @Key
    private BigDecimal distance;

    @Key
    private Integer floors;

    @Key
    private Integer steps;

    public BigDecimal getActiveScore() {
        return activeScore;
    }

    public void setActiveScore(BigDecimal activeScore) {
        this.activeScore = activeScore;
    }

    public BigDecimal getCaloriesOut() {
        return caloriesOut;
    }

    public void setCaloriesOut(BigDecimal caloriesOut) {
        this.caloriesOut = caloriesOut;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getFloors() {
        return floors;
    }

    public void setFloors(Integer floors) {
        this.floors = floors;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }
}
