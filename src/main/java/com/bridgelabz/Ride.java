package com.bridgelabz;

public class Ride {
    int distance;
    int time;
    String userId;

    public Ride(String userId, int distance, int time){
        this.userId = userId;
        this.distance = distance;
        this.time = time;
    }

    public int distance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int time() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String userId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
