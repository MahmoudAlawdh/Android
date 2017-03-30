package com.example.mhd.donor;

import android.app.Activity;
import android.app.Notification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mhd on 3/30/17.
 */

public class NotificationAdapter extends BaseAdapter {
    ArrayList<NotificationModel> model;
    Activity context;
    LayoutInflater inflater;

    public NotificationAdapter(ArrayList<NotificationModel> model, Activity context) {
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

        final NotificationModel m = model.get(position);


        Date.setText(" "+m.getDate());
        Bloodtype.setText(" "+m.getTitle());

        Destination.setText(""+m.getDescription());


        return v;
    }
}
