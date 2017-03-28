package com.example.mhd.donor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Campaigns extends Fragment {


    public Campaigns() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_campaigns, container, false);

        ListView lv = (ListView) v.findViewById(R.id.CampaingListview);

        final ArrayList<CampaignModel> model= new ArrayList<>();
        //   llate = 29.3640416;
        // llong = 47.9814006;
        model.add(new CampaignModel(1,"KOC","2017/1/1","2017/1/3","Marina","29.3640416","47.9814006","O+"));
        model.add(new CampaignModel(1,"Zain","2017/1/5","2017/1/9","Hawali","29.3640416","47.9814006","O-"));
        model.add(new CampaignModel(1,"National Day","2017/2/1","2017/2/9","Jabrya","29.3640416","47.9814006","A+"));
        model.add(new CampaignModel(1,"blood type AB","2017/2/13","2017/2/9","Jabrya","29.3640416","47.9814006","AB-"));
        model.add(new CampaignModel(1,"Emergancy","2017/11/11","2017/11/15","Jabrya","29.3640416","47.9814006","B-"));
        model.add(new CampaignModel(1,"Wataniya","2017/12/1","2017/12/6","avnyoz","29.3640416","47.9814006","A-"));
        model.add(new CampaignModel(1,"Viva","2017/12/7","2017/12/25","360","29.3640416","47.9814006","AB+"));

        CampaignAdapter myv = new CampaignAdapter(model,getActivity());


        lv.setAdapter(myv);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(),Campaign_Details.class);
                i.putExtra("Name",model.get(position).getName());
                i.putExtra("StartDate",model.get(position).getStartDate());
                i.putExtra("EndDate",model.get(position).getEndDate());
                i.putExtra("LocationName",model.get(position).getLocationName());
                i.putExtra("LLate",model.get(position).getLLate());
                i.putExtra("LLong",model.get(position).getLLong());
                i.putExtra("BloodType",model.get(position).getBloodType());
                startActivity(i);
            }
        });



        return v;
    }

}
