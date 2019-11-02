package com.sf_help.app.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.sf_help.app.Home;
import com.sf_help.app.Models.SignIn;
import com.sf_help.app.R;
import com.sf_help.app.Splash;
import com.sf_help.app.api.ApiClient;
import com.sf_help.app.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    Button mLoginBtn;
    TextInputEditText mUserName, mUserPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserName = findViewById(R.id.inputEmail);
        mUserPass = findViewById(R.id.inputPass);

        mLoginBtn = findViewById(R.id.loginBtn);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        signIn();
                    }
                };
                Thread loginThread = new Thread(runnable);
                loginThread.setName("LoginThread");
                loginThread.start();
            }
        });


    }

    private void signIn() {
        String name = mUserName.getText().toString();
        String pass = mUserPass.getText().toString();

        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<SignIn> call =apiInterface.signin(name,pass);
        call.enqueue(new Callback<SignIn>() {
            @Override
            public void onResponse(Call<SignIn> call, Response<SignIn> response) {

                if (response.body().getData().getStatus().equals("1")){

                    String userId = response.body().getRow().getUserId();

                    SharedPreferences sharedPreferences = Login.this.getSharedPreferences("user_id", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("User_Key", userId);
                    editor.apply();
                    Intent intent = new Intent(Login.this, Home.class);
                    intent.putExtra("Fragment","Fragment");
                    intent.putExtra("workerId",0);
                    Login.this.startActivity(intent);
//                    startActivity(new Intent(Login.this, Home.class));
//                    finish();
                }else{
                    Toast.makeText(getApplicationContext(),"Sorry something went wrong",Toast.LENGTH_LONG).show();
                }
                Log.d("status", response.body().getData().getStatus() + "Email: " + response.body().getRow().getUsrEmail());
            }

            @Override
            public void onFailure(Call<SignIn> call, Throwable t) {

                Log.d("status", t.getMessage());
            }
        });
    }

    public void register(View view) {
        startActivity(new Intent(Login.this, Registration.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Login.this, Splash.class));
        super.onBackPressed();
    }
}
