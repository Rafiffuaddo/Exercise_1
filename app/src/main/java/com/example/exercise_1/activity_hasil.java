package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
public class activity_hasil extends AppCompatActivity {
    TextView txemail, txpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        txemail =findViewById(R.id.tvEmail);
        txpassword = findViewById(R.id.tvPassword);
        Bundle bundle = getIntent().getExtras();
        String email = bundle.getString("a");
        String pass = bundle.getString("b");
        txemail.setText(email);
        txpassword.setText(pass);
    }
}