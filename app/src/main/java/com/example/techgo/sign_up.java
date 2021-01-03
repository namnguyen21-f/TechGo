package com.example.techgo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

public class sign_up extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        //
        //User newUser = new User("1","1","1","1");
        //Vector<String> error = newUser.CreateAccount(database.getReference());
        //error =0 la Ok
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setAppLocale("en");

        Button bt_next = findViewById(R.id.next_register_bt);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(sign_up.this, sign_up2.class);
                startActivity(intent);
            }
        }) ;
    }


    private void setAppLocale(String localeCode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));
        res.updateConfiguration(conf, dm);
    }
}