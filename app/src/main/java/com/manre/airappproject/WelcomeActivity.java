package com.manre.airappproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.redbooth.WelcomeCoordinatorLayout;

public class WelcomeActivity extends AppCompatActivity {

    WelcomeCoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        coordinatorLayout=findViewById(R.id.coordinator);



    }

}
