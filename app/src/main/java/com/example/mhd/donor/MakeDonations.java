package com.example.mhd.donor;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.common.data.DataBufferUtils;

import java.util.ArrayList;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class MakeDonations extends Fragment {


    public MakeDonations() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vv = inflater.inflate(R.layout.fragment_make_donations, container, false);


        TextView InstructionForDonation = (TextView) vv.findViewById(R.id.text_donation);

        InstructionForDonation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),StaticInfoFragment.class);
                startActivity(i);
            }
        });

        Spinner donationType = (Spinner) vv.findViewById(R.id.spinnerSelectDonationType);
        final ArrayList<String> model=new ArrayList<>();

        model.add("Select Donation Type");
        model.add("Blood Cells");
        model.add("Platelets");

        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,model);
        donationType.setAdapter(adapter);





        Spinner branchType = (Spinner) vv.findViewById(R.id.spinnerBranches);
        final ArrayList<String> model1=new ArrayList<>();

        model1.add("Select Branch");
        model1.add("AlJabriya- Main Branch");
        model1.add("AlAdan");
        model1.add("AlJahra'a");
        model1.add("AlAsma");

         final ArrayAdapter<String> adapterr =new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,model1);

        branchType.setAdapter(adapterr);


//
//
//
//        donationType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), model.get(position), Toast.LENGTH_SHORT).show();
//            }
//        });
//
        final EditText date = (EditText) vv.findViewById(R.id.editTextDate);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {



                DatePickerDialog d = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        Toast.makeText(getActivity(), year + "/" + month + "/" + dayOfMonth, Toast.LENGTH_SHORT).show();

                        date.setText(year + "/" + month + "/" + dayOfMonth);



                    }
                }, 2017, 3, 30);

                d.show();
            }
        });


        final EditText time = (EditText) vv.findViewById(R.id.editTextTime);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {




                TimePickerDialog d = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay+":"+minute);
                    }
                }, 12, 0, false);

                d.show();
            }
        });


        Button confirm =(Button) vv.findViewById(R.id.confirmButton);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            Toast

                startActivity(i);
            }
        });

        });
        return vv;

    }


