package com.example.mhd.donor;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class AfterDonation extends AppCompatActivity {
    ViewPager viewPagerAfter;
    TabLayout tabLayoutAfter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_donation);
        Toolbar tb = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPagerAfter = (ViewPager) findViewById(R.id.viewPagerAfter);
        viewPagerAfter.setAdapter(new CustomAdapterAfter(getSupportFragmentManager(),getApplicationContext()));
        tabLayoutAfter = (TabLayout) findViewById(R.id.tablayoutAfter);
        tabLayoutAfter.setupWithViewPager(viewPagerAfter);
        tabLayoutAfter.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }
    private class CustomAdapterAfter extends FragmentPagerAdapter {

        private String AfterDonation[]= {"After Donation", "Continue....", "Continue..."};

        public CustomAdapterAfter(FragmentManager fm, Context appContext) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new afterfregment1();
                case 1:
                    return new afterfregment2();
                case 2:
                    return new afterfrefment3();
            }


            return null;
        }

        @Override
        public int getCount() {
            return AfterDonation.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return AfterDonation[position];
        }
    }
}
