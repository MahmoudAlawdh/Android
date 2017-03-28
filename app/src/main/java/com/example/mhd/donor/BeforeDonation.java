package com.example.mhd.donor;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BeforeDonation extends AppCompatActivity {
    TabLayout tabLayoutBefore;
    ViewPager viewPagerBefore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_donation);
        viewPagerBefore = (ViewPager) findViewById(R.id.viewPagerBefore);
        viewPagerBefore.setAdapter(new CustomAdapterBefore(getSupportFragmentManager(),getApplicationContext()));
        tabLayoutBefore = (TabLayout) findViewById(R.id.tablayoutBefore);
        tabLayoutBefore.setupWithViewPager(viewPagerBefore);
        tabLayoutBefore.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPagerBefore.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPagerBefore.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPagerBefore.setCurrentItem(tab.getPosition());
            }
        });

    }
    private class CustomAdapterBefore extends FragmentPagerAdapter {

        private String BeforeDonation[]= {"Before Donation", "Continue...."};

        public CustomAdapterBefore(FragmentManager fm, Context appContext) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new beforefregment1();
                case 1:
                    return new beforefregment2();
            }


            return null;
        }

        @Override
        public int getCount() {
            return BeforeDonation.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return BeforeDonation[position];
        }
    }
}
