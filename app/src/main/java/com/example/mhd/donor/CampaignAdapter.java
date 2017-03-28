package com.example.mhd.donor;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mikepenz.community_material_typeface_library.CommunityMaterial;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

import java.util.ArrayList;

/**
 * Created by mhd on 3/27/17.
 */

public class CampaignAdapter extends BaseAdapter {
    ArrayList<CampaignModel> model;
    Activity context;
    LayoutInflater inflater;


    public CampaignAdapter(ArrayList<CampaignModel> model, Activity context) {
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

        View v = inflater.inflate(R.layout.list_item_campaign,null);


        TextView Name = (TextView) v.findViewById(R.id.Name);
        TextView StartDate = (TextView)v.findViewById(R.id.StartDate);
        TextView EndDate = (TextView)v.findViewById(R.id.EndDate);
        final CampaignModel m = model.get(position);

        Name.setText(" "+m.getName());

        StartDate.setText(" "+m.getStartDate());

        EndDate.setText(" "+m.getEndDate());



        return v;
    }
}
