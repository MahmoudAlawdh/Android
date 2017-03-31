package com.example.mhd.donor;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Share extends Fragment {


    ImageView twitter;


    ImageView whatsapp;
    ImageView Massge;



    Intent whatsappshare;
    Intent Massgeshare;

    public Share() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_share, container, false);



        twitter = (ImageView) v.findViewById(R.id.imageViewtwitter);
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });




        whatsapp = (ImageView) v.findViewById(R.id.imageViewwhatsapp);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whatsappshare = new Intent(Intent.ACTION_SEND);
                whatsappshare.setType("text/plain");
                whatsappshare.setPackage("com.whatsapp");
                whatsappshare.putExtra(Intent.EXTRA_TEXT, "Share with ...");
                try {
                    startActivity(whatsappshare);
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getContext(), "asdf", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Massge = (ImageView) v.findViewById(R.id.imageView30);
        Massge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Massgeshare = new Intent(Intent.ACTION_SEND);
                Massgeshare.setType("texet/plain");
                Massgeshare.putExtra(Intent.EXTRA_SUBJECT, "Donation ");
                String appLink = "mHealth.com";
                Massgeshare.putExtra(Intent.EXTRA_TEXT,"To Donate Go to the Website "+appLink);
                startActivity(Intent.createChooser(Massgeshare,"Share Via"));
            }
        });
        return v;



    }

}
