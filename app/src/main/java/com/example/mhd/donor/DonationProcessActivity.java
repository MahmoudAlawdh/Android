package com.example.mhd.donor;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DonationProcessActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_process);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new CustomAdapter(getSupportFragmentManager(),getApplicationContext()));

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }


    private class CustomAdapter extends FragmentPagerAdapter {

        private String donationFregments [] = {"Donation Process", "Continue....", };
        public CustomAdapter(FragmentManager supportFragmentManager, Context appliContext) {
            super(supportFragmentManager);

        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new donationfregment1();
                case 1:
                    return new donationfregment2();



            }
           return null;
        }

        @Override
        public int getCount() {
            return donationFregments.length;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return donationFregments[position];
        }
    }

}
