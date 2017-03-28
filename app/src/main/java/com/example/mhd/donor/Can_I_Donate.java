package com.example.mhd.donor;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Can_I_Donate extends AppCompatActivity {
    TabLayout tabLayoutCan;
    ViewPager viewPagerCan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can__i__donate);
        viewPagerCan = (ViewPager) findViewById(R.id.viewPagerCan);
        viewPagerCan.setAdapter(new CustomAdapterCan(getSupportFragmentManager(),getApplicationContext()));
        tabLayoutCan = (TabLayout) findViewById(R.id.tablayoutCan);
        tabLayoutCan.setupWithViewPager(viewPagerCan);
        tabLayoutCan.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerCan.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPagerCan.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPagerCan.setCurrentItem(tab.getPosition());
            }
        });
    }

    private class CustomAdapterCan extends FragmentPagerAdapter {

        private String CanI[]= {"Can i Donate", "Continue...."};

        public CustomAdapterCan(FragmentManager fm, Context appContext) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                return new canfregment1();
                case 1:
                    return new canfregment2();
            }


            return null;
        }

        @Override
        public int getCount() {
            return CanI.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return CanI[position];
        }
    }
}
