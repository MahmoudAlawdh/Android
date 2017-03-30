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
        View v = inflater.inflate(R.layout.list_item_notification,null);

        TextView Date = (TextView)v.findViewById(R.id.date_noti111111);
        TextView title = (TextView)v.findViewById(R.id.title_noti111111);
        TextView Destination = (TextView)v.findViewById(R.id.desc_noti11111);

        final NotificationModel m = model.get(position);


        Date.setText(" "+m.getTitle());
        title.setText(" "+m.getTitle());

        Destination.setText(""+m.getTitle());


        return v;
    }
}
