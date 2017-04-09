package com.example.mhd.donor;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        ImageView share = (ImageView)v.findViewById(R.id.notificationShare);
        final NotificationModel m = model.get(position);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Massgeshare = new Intent(Intent.ACTION_SEND);
                Massgeshare.setType("texet/plain");
                Massgeshare.putExtra(Intent.EXTRA_SUBJECT, "Donation ");
                String appLink = m.getTitle();
                Massgeshare.putExtra(Intent.EXTRA_TEXT,"Am Sharing this notification:"+appLink);
                v.getContext().startActivity(Intent.createChooser(Massgeshare,"Share Via"));
            }
        });

        Date.setText(" Date: "+m.getTitle());
        title.setText(" Title: "+m.getTitle());

        Destination.setText(" Description: "+m.getTitle());


        return v;
    }
}
