package com.example.lenovo.retailshoppingapp.UI.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.retailshoppingapp.R;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              //  Intent intent=new Intent(MainActivity.this,UserAccountActivity.class);
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                MainActivity.this.finish();

            }
        },SPLASH_TIME_OUT);
    }
}
