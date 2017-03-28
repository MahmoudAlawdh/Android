package com.example.mhd.donor;

import android.support.v4.app.Fragment;

/**
 * Created by mhd on 3/26/17.
 */

class FragmentM {
    private final Fragment about = new AboutUs();
    private final Fragment camp = new Campaigns();
    private final Fragment maked = new MakeDonations();
    private final Fragment ma = new MyAppointments();
    private final Fragment myd = new MyDonations();
    private final Fragment n = new Notifications();
    private final Fragment set = new Settings();
    private final Fragment share = new Share();
    private final Fragment staticinf = new StaticInfoFragment();

    final private static  FragmentM ourInstance = new FragmentM();

    static FragmentM getInstance() {
        return ourInstance;
    }

    private FragmentM() {

    }

    public Fragment getAboutUs() {
        return about;
    }

    public Fragment getCampaigns() {
        return camp;
    }

    public Fragment getMakeDonations() {
        return maked;
    }

    public Fragment getMyAppointments() {
        return ma;
    }

    public Fragment getMyDonations() {
        return myd;
    }

    public Fragment getNotifications() {
        return n;
    }

    public Fragment getSettings() {
        return set;
    }

    public Fragment getShare() {
        return share;
    }

    public Fragment getStaticInfo() {
        return staticinf;
    }
}
