package com.example.techgo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class sign_up2 extends AppCompatActivity {

    private Button Customer_bt;
    private EditText username_text;
    private EditText password_text;
    private EditText confirmpassword_text;
    private EditText email_text;
    private EditText phone_text;

    private boolean is_customer = false;

    private EditText displayname_text;
    private EditText address_text;
    private EditText birthday_text;
    private Button bt_finish;

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        Customer_bt = findViewById(R.id.customer_bt);
        Customer_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                is_customer = true;
            }
        });


        username_text = findViewById(R.id.user_name_register_text);
        password_text = findViewById(R.id.pw_register_text);
        confirmpassword_text = findViewById(R.id.retype_pw_register_text);

        email_text = findViewById(R.id.email_register_text);
        phone_text = findViewById(R.id.phone_num_register_text);
        displayname_text = findViewById(R.id.display_name_register_text);
        address_text = findViewById(R.id.address_register_text);

        birthday_text = findViewById(R.id.birth_register_text);

        bt_finish = findViewById(R.id.finish_register_bt);

        bt_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String birhday = birthday_text.getText().toString();
                String address = address_text.getText().toString();
                String display_name = displayname_text.getText().toString();
                //name and password
                String username = username_text.getText().toString();
                String password = password_text.getText().toString();
                //email and phone number
                String confirmPassword = confirmpassword_text.getText().toString();
                String email = email_text.getText().toString();
                String phone = password_text.getText().toString();

                //User newUser = new User(username,email,password,confirmPassword,phone,address,birhday,display_name);
                //Vector<String> arr =  newUser.CreateAccount(database.getReference());
            }
        }) ;

        Button bt_pre = findViewById(R.id.previous_register_bt);
        bt_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }) ;
    }
}