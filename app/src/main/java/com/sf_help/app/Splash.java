package com.sf_help.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.sf_help.app.Views.Login;

public class Splash extends AppCompatActivity {
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        mLogin = findViewById(R.id.login);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            login();
                        }
                    };

                    Thread thread = new Thread(runnable);
                    thread.setName("Login");
                    thread.start();
            }
        });

    }

    private void login() {
        final ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()){
            startActivity(new Intent(Splash.this, Login.class));
            finish();
            Log.d("State", "Connected");
        }else {
            Log.d("State", "Please connect to the internet first");
        }
    }

}
