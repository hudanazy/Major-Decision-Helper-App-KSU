package com.example.majorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ShowMajorBtn= (Button) findViewById(R.id.ShowMajorbtn);
        ShowMajorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText Hsgpam=(EditText) findViewById(R.id.Hsgpa);
                EditText GAAT=(EditText) findViewById(R.id.Gaat);
                EditText SAAT=(EditText) findViewById(R.id.Saat);

                /* HighS ,G and S is used convert Hsgpam,GAAT and SAAT to string for ifNumerical Function and others*/
                String HighS=Hsgpam.getText().toString();
                String G=GAAT.getText().toString();
                String S=SAAT.getText().toString();



                if(ifNumerical(HighS)&&ifNumerical(G)&&ifNumerical(S)) {
                    Intent intent = new Intent(MainActivity.this, Result.class);
                    startActivity(intent);

                    double HighSchool = Double.parseDouble(HighS);
                    double Gaat = Double.parseDouble(G);
                    double Saat = Double.parseDouble(S);

                    double SWR = (double) ((HighSchool * 0.30) + (Gaat * 0.30) + (Saat * 0.40)); // Weighted ratio for Science Program
                    double MWR = (double) ((HighSchool * 0.30) + (Gaat * 0.30) + (Saat * 0.40)); // Weighted ratio for Medical Program
                    double NWR = (double) ((HighSchool * 0.30) + (Gaat * 0.30) + (Saat * 0.40)); // Weighted ratio for Nursing Program
                    double HWR = (double) ((HighSchool * 0.50) + (Gaat * 0.25) + (Saat * 0.25)); // Weighted ratio for Humanitarian Program
                    double BWR = (double) ((HighSchool * 0.50) + (Gaat * 0.50)); // Weighted ratio for Business Program


                    intent.putExtra("Value1", SWR);
                    intent.putExtra("Value2", MWR);
                    intent.putExtra("Value3", NWR);
                    intent.putExtra("Value4", HWR);
                    intent.putExtra("Value5", BWR);
                    startActivity(intent);
                    finish();
                }

                else {
                    if(!ifNumerical(HighS))
                        Hsgpam.setError("Please enter your correct GPA \nex.90");

                    if(!ifNumerical(G))
                        GAAT.setError("Please enter your correct GAAT \nex.90");

                    if(!ifNumerical(S))
                        SAAT.setError("Please enter your correct SAAT \nex.90");
                }




            }
        });
    }

     public boolean  ifNumerical (String Input){ //checks string if it is numercial (TRUE) and if it's less than zero or more than 100(FALSE)
       double num;
        String in = Input;
        boolean flag = false;

         String s ="\\d*\\.?\\d+"; //wanted format

        CharSequence inputS= (CharSequence) Input;

         Pattern p= Pattern.compile(s,Pattern.CASE_INSENSITIVE);
         Matcher match=p.matcher(inputS);

         if (match.matches()){
             flag=true;
         }
         if(flag){// check if num larger than 00
            num=Double.parseDouble(in);
            if(num<=0||num>100)
                flag=false;
         }
         return flag;
    }// END numerical METHOD

}