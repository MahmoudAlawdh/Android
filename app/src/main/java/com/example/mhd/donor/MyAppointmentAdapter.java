package com.example.mhd.donor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by mhd on 3/27/17.
 */

public class MyAppointmentAdapter extends BaseAdapter {
    ArrayList<MyAppointmentModel> model;
    Activity context;
    LayoutInflater inflater;

    public MyAppointmentAdapter(ArrayList<MyAppointmentModel> model, Activity context) {
        this.model = model;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = inflater.inflate(R.layout.list_item_myappointment,null);

        TextView Date = (TextView)v.findViewById(R.id.Date);
        TextView Bloodtype = (TextView)v.findViewById(R.id.BloodType);
        TextView Destination = (TextView)v.findViewById(R.id.Destination);
        ImageView share = (ImageView) v.findViewById(R.id.myappointmentShare);
        final MyAppointmentModel m = model.get(position);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Massgeshare = new Intent(Intent.ACTION_SEND);
                Massgeshare.setType("texet/plain");
                Massgeshare.putExtra(Intent.EXTRA_SUBJECT, "Donation ");
                String appLink = m.getDonationDestination();
                Massgeshare.putExtra(Intent.EXTRA_TEXT,"Am donating blood to "+appLink);
                v.getContext().startActivity(Intent.createChooser(Massgeshare,"Share Via"));
            }
        });
        Date.setText(" "+m.getDDate());
        Bloodtype.setText(" "+m.getDnBloodType());

        Destination.setText(""+m.getDonationDestination());
        return v;
    }
}
