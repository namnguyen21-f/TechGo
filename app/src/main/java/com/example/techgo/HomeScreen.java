package com.example.techgo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Button bt_wallet = findViewById(R.id.wallet_home_screen);
        bt_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HomeScreen.this, wallet.class);
                startActivity(intent);
            }
        }) ;

        Button bt_book = findViewById(R.id.book_trip_bt);
        bt_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(HomeScreen.this, bookScreen.class);
                startActivity(intent);
            }
        }) ;

    }
}