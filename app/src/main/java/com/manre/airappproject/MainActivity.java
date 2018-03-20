package com.manre.airappproject;

import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.manre.airappproject.adapter.ViewPagerAdapter;
import com.manre.airappproject.common.BottomNavigationViewHelper;
import com.manre.airappproject.fragment.dashboard.DashboardFragment;
import com.manre.airappproject.fragment.flight.FlightFragment;
import com.manre.airappproject.fragment.home.HomeFragment;
import com.manre.airappproject.fragment.myself.MyselfFragment;
import com.manre.airappproject.fragment.notification.NotificationFragment;



public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    private MenuItem menuItem;
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.tab_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.tab_notification:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.tab_dashboard:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.tab_flight:
                    viewPager.setCurrentItem(3);
                    return true;
                case R.id.tab_myself:
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(5);//这是个坑来的，如果不设置，默认是3
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        setupViewPager(viewPager);

    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new NotificationFragment());
        adapter.addFragment(new DashboardFragment());
        adapter.addFragment(new FlightFragment());
        adapter.addFragment(new MyselfFragment());
        viewPager.setAdapter(adapter);
    }



}
