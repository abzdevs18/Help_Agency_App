package com.sf_help.app.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.sf_help.app.Home;
import com.sf_help.app.R;
import com.sf_help.app.Splash;

public class Registration extends AppCompatActivity {
    Switch mUserType;
    TextView mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mLogin = findViewById(R.id.backLogin);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, Home.class));
                finish();
            }
        });

        mUserType = findViewById(R.id.iUType);
        mUserType.setTextOff("No");
        mUserType.setTextOn("Yes");
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Registration.this, Login.class));
        super.onBackPressed();
    }
}
