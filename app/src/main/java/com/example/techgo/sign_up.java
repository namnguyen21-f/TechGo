package com.example.techgo;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class sign_up extends AppCompatActivity {

    EditText password_text;
    EditText email_text;
    EditText phone_text;
    String is_customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setAppLocale("en");

        is_customer = "false";

        email_text = findViewById(R.id.email_register_text);

        password_text = findViewById(R.id.pw_register_text);

        phone_text = findViewById(R.id.phone_num_register_text);

        Button Customer_bt = findViewById(R.id.customer_bt);

        Customer_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_customer = "true";
            }
        }) ;

        Button bt_next = findViewById(R.id.next_register_bt);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String is_cus = is_customer;
                String email =  email_text.getText().toString();
                String phone =  phone_text.getText().toString();
                String pw =  password_text.getText().toString();

                Intent intent = new Intent(sign_up.this, sign_up2.class);

                intent.putExtra("PW", pw);
                intent.putExtra("PHONE", phone);
                intent.putExtra("EMAIL", email);
                intent.putExtra("IS_CUS", is_cus);

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