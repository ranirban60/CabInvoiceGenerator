package com.bridgelabz;

public class Ride {
    int distance;
    int time;
    String userId;
    CabInvoiceGenerator.RideType rideType;

    public Ride(String userId, int distance, int time, CabInvoiceGenerator.RideType variable){
        this.userId = userId;
        this.distance = distance;
        this.time = time;
        this.rideType = variable;
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
