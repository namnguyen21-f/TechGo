package com.example.techgo;

import com.google.firebase.database.DatabaseReference;

public class Location {
    public double lat;
    public double lng;
    public String id;
    public Location(double lat,double lng){
        this.lat = lat;
        this.lng = lng;
    }

    public void createLocation(DatabaseReference ref){
        String key = ref.child("users").push().getKey();
        id = key;
        ref.child("location").child(key).setValue(this);
    }

    public double GetLat(){
        return lat;
    }

    public double GetLng(){
        return lng;
    }
}
