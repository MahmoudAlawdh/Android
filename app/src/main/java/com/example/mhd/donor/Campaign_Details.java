package com.example.mhd.donor;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Campaign_Details extends AppCompatActivity implements OnMapReadyCallback {
    String name;
    double llate;
    double llong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign__details);
        Toolbar tb = (Toolbar)findViewById(R.id.barrrr);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        setup();

    }
    public void setup(){
        llate = Double.parseDouble(getIntent().getStringExtra("LLate"));
        llong = Double.parseDouble(getIntent().getStringExtra("LLong"));
        TextView Name = (TextView) findViewById(R.id.Name);
        TextView time = (TextView) findViewById(R.id.Time);
        TextView location = (TextView) findViewById(R.id.Location);
        Name.setText("Campaign : "+getIntent().getStringExtra("Name"));
        time.setText("Time : "+getIntent().getStringExtra("StartDate"));
        location.setText("Location : "+getIntent().getStringExtra("LocationName"));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng sydney = new LatLng(llate,llong);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},0);
            return;
        }
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

        map.addMarker(new MarkerOptions()
                .position(sydney));
    }
}
