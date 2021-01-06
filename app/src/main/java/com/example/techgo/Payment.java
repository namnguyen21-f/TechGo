package com.example.techgo;

import com.google.firebase.database.DatabaseReference;

public class Payment {
    public double amount;
    public String rideId;
    public String type;

    public Payment(double amount,String rideId,String type){
        this.amount = amount;
        this.rideId = rideId;
        this.type = type;
    }


    public void createPayment(DatabaseReference ref){
        String key = ref.child("users").push().getKey();
        ref.child("payment").child(key).setValue(this);
    }
}
