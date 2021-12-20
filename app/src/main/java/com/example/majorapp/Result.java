package com.example.majorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

import android.os.Bundle;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        double SWR=getIntent().getExtras().getDouble("Value1");
        double MWR=getIntent().getExtras().getDouble("Value2");
        double NWR=getIntent().getExtras().getDouble("Value3");
        double HWR=getIntent().getExtras().getDouble("Value4");
        double BWR=getIntent().getExtras().getDouble("Value5");

        TextView SMajors=(TextView)findViewById(R.id.Sresult);
        TextView MMajors=(TextView)findViewById(R.id.mresult);
        TextView NMajors=(TextView)findViewById(R.id.nresult);
        TextView HMajors=(TextView)findViewById(R.id.hresult);
        TextView BMajors=(TextView)findViewById(R.id.bresult);

        if (SWR>=89){
            SMajors.setText("Weighted Ratio : "+SWR+"\n You can enroll in the science program");
        }
        else
            SMajors.setText("Weighted Ratio : "+SWR+"\n You cannot enroll in the science program");


        if (MWR>=92){
            MMajors.setText("Weighted Ratio : "+MWR+"\n You can enroll in the medical  program");
        }
        else
            MMajors.setText("Weighted Ratio : "+SWR+"\n You cannot enroll in the medicla program");


        if (NWR>=89){
            NMajors.setText("Weighted Ratio : "+NWR+"\n You can enroll in the nursing program");
        }
        else
            NMajors.setText("Weighted Ratio : "+NWR+"\n You cannot  enroll in the nursing program");


        if (HWR>=87){
            HMajors.setText("Weighted Ratio : "+HWR+"\n You can enroll in the humanitarian program");
        }
        else
            HMajors.setText("Weighted Ratio : "+HWR+"\n You cannot enroll in the humanitarian program");


        if (BWR>=91){
            BMajors.setText("Weighted Ratio : "+BWR+"\n You can enroll in the Business program");
        }
        else
            BMajors.setText("Weighted Ratio : "+BWR+"\n You cannot enroll in the Business program");
        

        Button goBackBtn= (Button) findViewById(R.id.button);
        goBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Result.this, MainActivity.class);
                startActivity(intent);
          }
        });
    }

}