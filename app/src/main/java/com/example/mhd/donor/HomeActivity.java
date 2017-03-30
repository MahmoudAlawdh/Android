package com.example.mhd.donor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class HomeActivity extends AppCompatActivity {
    final FragmentM f = FragmentM.getInstance();
    final FragmentManager fm=getSupportFragmentManager();
    public final static String Filee ="donor";
    public final static String profile ="profile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences preferences=getSharedPreferences(Filee,MODE_PRIVATE);
        String email=preferences.getString(profile,"notfound");
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();





        fm.beginTransaction()
                .replace(R.id.Layout,f.getMakeDonations()).commit();
        Materialdrawer(HomeActivity.this);

    }

    @Override
    public void onBackPressed() {
    }
    public void Materialdrawer(final Context c){

        Toolbar TB = (Toolbar) findViewById(R.id.Hometoolbar);
        final Drawable MakeDonation = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_plus).color(Color.rgb(130,7,7));
        Drawable Myappointments = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_calendar);
        Drawable Notifications = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_bell);
        Drawable Campaigns = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_users);
        Drawable MyDonations = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_history);
        Drawable Share = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_share);
        Drawable Aboutus = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_info);
        Drawable Settings = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_wrench);
        Drawable Logout = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_sign_out);
        Drawable staticinf = new IconicsDrawable(this).icon(FontAwesome.Icon.faw_user_md);

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withIcon(MakeDonation).withName(R.string.MakeDonation);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(1).withIcon(Myappointments).withName(R.string.Myappointments);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(1).withIcon(Notifications).withName(R.string.Notification);
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(1).withIcon(Campaigns).withName(R.string.Campaigns);
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(1).withIcon(MyDonations).withName(R.string.MyDonations);
        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(1).withIcon(Share).withName(R.string.Share);
        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(1).withIcon(staticinf).withName(R.string.staticinfo);
        PrimaryDrawerItem item8 = new PrimaryDrawerItem().withIdentifier(1).withIcon(Aboutus).withName(R.string.Aboutus);
        PrimaryDrawerItem item9 = new PrimaryDrawerItem().withIdentifier(1).withIcon(Settings).withName(R.string.Settings);
        PrimaryDrawerItem item10 = new PrimaryDrawerItem().withIdentifier(1).withIcon(Logout).withName(R.string.Logout);



        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.navi)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com")
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        Intent i = new Intent(HomeActivity.this,ProfileActivity.class);
                        startActivity(i);
                        return false;
                    }
                })
                .build();



        new DrawerBuilder()
                .withActivity(this)
                .withToolbar(TB)
                .addDrawerItems(item1,item2,item3,item4,item5,item6,item7,item8,item9,item10)
                .withAccountHeader(headerResult)
                .build().setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                switch (position){

                    case 1:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getMakeDonations()).commit();
                        Toast.makeText(c, "Make Donation", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getMyAppointments()).commit();
                        Toast.makeText(c, "My appointments", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getNotifications()).commit();
                        Toast.makeText(c, "Notifications", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getCampaigns()).commit();
                        Toast.makeText(c, "Campaigns", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getMyDonations()).commit();
                        Toast.makeText(c, "My Donations", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getShare()).commit();
                        Toast.makeText(c ,"Share", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getStaticInfo()).commit();
                        Toast.makeText(c, "static info", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getAboutUs()).commit();
                        Toast.makeText(c, "About us", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        fm.beginTransaction()
                                .replace(R.id.Layout,f.getSettings()).commit();
                        Toast.makeText(c, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Intent i = new Intent(HomeActivity.this,LoginActivity.class);
                        startActivity(i);
                        Toast.makeText(c, "Logout", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }
}
