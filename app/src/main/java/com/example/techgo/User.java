package com.example.techgo;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.Vector;


class User {
    public String userId;
    public String username;
    public String email;
    public String password;
    public String confirmPassword;
    public String phoneNumber;
    public String address;
    public String dob;
    public double lat;
    public double lng;
    public String displayname;
    public String userType;
    public int totalRide;
    public boolean rideStatus;
    public int wallet;
    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email,String password, String confirmPassword,String phone,String address,String birthdata
    ,String dpayname,String type,double lat,double lng) {
        this.username = username;
        this.email = email;
        this.confirmPassword = confirmPassword;
        this.password = password;
        this.userType = type;
        this.phoneNumber = phone;
        this.address = address;
        this.dob = birthdata;
        this.displayname = dpayname;
        this.lat = lat;
        this.lng = lng;
        totalRide = 0;
        rideStatus = false;
        wallet = 0;
    }

    public String GetUserID(DatabaseReference ref){
        DatabaseReference userRef = ref.child("user");
        String key = userRef.push().getKey();
        return key;
    }

    public Vector<String> CreateAccount(DatabaseReference ref){
        ValidatorAccount validatorUser = new ValidatorAccount();
        final Vector<String> error = validatorUser.Validator(email,password,confirmPassword,username);
        if (error.size() == 0){
            ref.child("users").orderByChild("email").equalTo(email)
                    .addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                //Display UI about "User was registered" notifications to the user
                                error.add("User was registered");
                            }else{

                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }else{
            //Display UI about error notifications to the user
            return error;
        }
        if (error.size() ==0){
            String id = GetUserID(ref);
            userId = id;
            ref.child("users").child(id).setValue(this);
        }

        return error;
    }

    public boolean ForgetPassword(FirebaseAuth mAuth){
        final boolean[] f = {false};
        mAuth.sendPasswordResetEmail("user@example.com")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            f[0] = true;
                        }
                    }
                });
        return f[0];
    }

    public String toString(){
        return username + ":" + password;
    }
}



