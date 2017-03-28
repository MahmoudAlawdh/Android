package com.example.mhd.donor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class StaticInfoFragment extends Fragment {


    public StaticInfoFragment() {
        // Required empty public constructor



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_static_info, container, false);
       Button donationPro = (Button)  v.findViewById(R.id.donationProcess);
       Button canIdonate= (Button) v.findViewById(R.id.CanI);
       Button beforDonation= (Button) v.findViewById(R.id.BeforeDonation);
        Button afterDonateion= (Button) v.findViewById(R.id.AfterDonation);

        donationPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),DonationProcessActivity.class);
                startActivity(i);
            }
        });

        canIdonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Can_I_Donate.class);
                startActivity(i);
            }
        });

        beforDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),BeforeDonation.class);
                startActivity(i);
            }
        });

        afterDonateion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),AfterDonation.class);
                startActivity(i);
            }
        });
        return v;
    }

}
