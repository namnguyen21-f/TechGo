package com.example.techgo;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;
import java.util.Vector;

public class sign_up extends AppCompatActivity {
    private Button Customer_bt;
    private EditText username_text;
    private EditText password_text;
    private EditText confirmpassword_text;
    private EditText email_text;
    private EditText phone_text;
    private boolean is_customer = false;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setAppLocale("en");
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        username_text = findViewById(R.id.user_name_register_text);
        password_text = findViewById(R.id.pw_register_text);
        confirmpassword_text = findViewById(R.id.retype_pw_register_text);

        email_text = findViewById(R.id.email_register_text);
        phone_text = findViewById(R.id.phone_num_register_text);
        Button bt_next = findViewById(R.id.next_register_bt);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = username_text.getText().toString();
                String password = password_text.getText().toString().trim();
                //email and phone number
                String confirmPassword = confirmpassword_text.getText().toString().trim();
                String email = email_text.getText().toString();
                String phone = password_text.getText().toString();
                System.out.println(password.length());
                System.out.println(confirmPassword.length());
                User newUser = new User(username,email,password,confirmPassword,phone,"","","","",102.222,60.000);
                Vector<String> arr =  newUser.CreateAccount(database.getReference());
                System.out.println(arr);
                //Intent intent = new Intent();
                //Intent.setClass(sign_up.this, sign_up2.class);
                //startActivity(intent);
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