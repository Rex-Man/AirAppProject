package com.manre.airappproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.redbooth.WelcomeCoordinatorLayout;

public class WelcomeActivity extends AppCompatActivity {

    WelcomeCoordinatorLayout coordinatorLayout;
    SharedPreferences share;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        share = getSharedPreferences("isFirstRun", Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor = share.edit();
        if(!share.contains("isFirstRun"))
        {

            int num = share.getInt("isFirstRun", 0);
            editor.putInt("isFirstRun", num++);
            editor.commit();
            setContentView(R.layout.activity_welcome);
            coordinatorLayout=findViewById(R.id.coordinator);
            initializePages();
            initializeListeners();
        }else{
            setContentView(R.layout.activity_welcome_third);
            skipActivity(1);
        }
    }
    private void initializePages() {
        final WelcomeCoordinatorLayout coordinatorLayout
                = (WelcomeCoordinatorLayout)findViewById(R.id.coordinator);
        coordinatorLayout.addPage(R.layout.activity_welcome_first,
                R.layout.activity_welcome_second);
    }
    private void initializeListeners() {
        coordinatorLayout.setOnPageScrollListener(new WelcomeCoordinatorLayout.OnPageScrollListener() {

            @Override
            public void onScrollPage(View v, float progress, float maximum) {


            }

            @Override
            public void onPageSelected(View v, int pageSelected) {


            }
        });
    }
    void GoToMainPage(View v){
        Toast toast = Toast.makeText(getApplicationContext(),"你点击了1次", Toast.LENGTH_LONG);//提示被点击了
        toast.show();
        skipActivity(0);
    }

    private void skipActivity(int min) {
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,
                        MainActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        }, 1000*min);
    }
}
