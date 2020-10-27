package com.example.convertmoney;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class main_activity extends AppCompatActivity  {

    Spinner sp_from,sp_to;
    EditText ed_imp;
    TextView txt_res;
    String listM[]={"VND","USD","NDT","BANG","YEN","EURO","DKK","BATH","SGD","WON"};
    double[] listMC ={30235.53,1.30,8.72,1,136.52,1.10,8.18,40.85,1.77,1472.11};

    double imp,res;
    double tigia,tigia1;
    NumberFormat format;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        sp_from = findViewById(R.id.sp_from);
        sp_to = findViewById(R.id.sp_to);
        ed_imp = findViewById(R.id.edit_imp);
        txt_res = findViewById(R.id.text_res);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, listM);

        sp_to.setAdapter(arrayAdapter);
        sp_from.setAdapter(arrayAdapter);

        sp_from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tigia = listMC[position] ;
                if(!ed_imp.getText().toString().matches("")) {
                    imp = Double.parseDouble(ed_imp.getText().toString());
                    format = new DecimalFormat("0.##");
                    res = imp * tigia1 / tigia;
                    txt_res.setText(format.format(res));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tigia1=listMC[position];
                if(!ed_imp.getText().toString().matches("")) {
                    imp = Double.parseDouble(ed_imp.getText().toString());
                    format = new DecimalFormat("0.##");
                    res = imp * tigia1 / tigia;
                    txt_res.setText(format.format(res));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ed_imp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!ed_imp.getText().toString().matches("")) {
                    imp = Double.parseDouble(ed_imp.getText().toString());
                    format = new DecimalFormat("0.##");
                    res = imp * tigia1 / tigia;
                    txt_res.setText(format.format(res));
                }
                else{
                    txt_res.setText("");
                }
            }
        });
    }

}
