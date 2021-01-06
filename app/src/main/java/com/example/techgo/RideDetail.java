package com.example.techgo;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RideDetail {
    public String rideId;
    public String driverId = null;
    public String customerId = null ;
    public Location driverLocation = null ;
    public Location customerLocation = null;
    public Location destination = null;
    public Location pickupLocation = null;
    public boolean completeTrip = false;

    public RideDetail() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public RideDetail(String driverId,String customerId,Location driverLocation ,Location customerLocation,Location destination,Location pickupLocation) {
        this.driverId = driverId;
        this.customerId = customerId;
        this.driverLocation = driverLocation;
        this.customerLocation = customerLocation;
        this.destination = destination;
        this.pickupLocation = pickupLocation;
    }

    public void createRide(DatabaseReference ref){
        boolean flag = false;
        String key = ref.child("users").push().getKey();
        rideId = key;
        ref.child("rideDetail").child(key).setValue(this);
    }

    public void findRide(DatabaseReference ref,String id){
        ref.child("rideDetail").orderByChild("rideId").equalTo(id)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (!dataSnapshot.exists()){

                        }else{
                            // Display UI about successful
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

    public void completeRide(DatabaseReference ref,String rideId){
        ref.child("rideDetail").orderByChild("rideId").equalTo(rideId)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            //Display UI about "User was registered" notifications to the user
                            HashMap map = new HashMap();
                            map.put("completeTrip", true);
                            ref.child("rideDetail").child(rideId).updateChildren(map);
                        }else{

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }

}
