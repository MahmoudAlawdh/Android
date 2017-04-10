package com.example.mhd.donor;


import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import java.util.Locale;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings extends Fragment {

    Button english;
    Button arabic;
    Resources resEnglish;
    Resources resArabic;
    public Settings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        english = (Button)  v.findViewById(R.id.button2);
        arabic= (Button) v.findViewById(R.id.button4);

        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Locale locale = new Locale("en");
               locale.setDefault(locale);
                resEnglish = getResources();
                DisplayMetrics dm = resEnglish.getDisplayMetrics();
                Configuration conf =resEnglish.getConfiguration();
                conf.locale = locale;
                resEnglish.updateConfiguration(conf, dm);
                Intent refresh = new Intent(getActivity(),HomeActivity.class);
                startActivity(refresh);



            }
        });

        arabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Locale locale = new Locale("ar");
                locale.setDefault(locale);
                resArabic = getResources();
                DisplayMetrics dm1 = resArabic.getDisplayMetrics();
                Configuration conf1 = resArabic.getConfiguration();
                conf1.locale = locale;
                resArabic.updateConfiguration(conf1, dm1);
                Intent refresh = new Intent(getActivity(),HomeActivity.class);
                startActivity(refresh);
            }
        });

        return v;
    }


}
