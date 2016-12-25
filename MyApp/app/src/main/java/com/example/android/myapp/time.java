package com.example.android.myapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class time extends AppCompatActivity {

    String date;
    String month;
    String year;
    String hour;
    String min;
    String tv;
    String ph;
    String mess;

    TimePicker timePicker;
    SimpleDateFormat df;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        TextView top = (TextView) findViewById(R.id.top);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        //bot = (TextView) findViewById(R.id.textView4);

        Intent in = getIntent();
        date = in.getStringExtra("date");
        month = in.getStringExtra("month");
        year = in.getStringExtra("year");

        String str = "Date: "  + date + "/" + month + "/" + year;
        tv = "Time: 12:00";
        top.setText(str);

        df = new SimpleDateFormat("dd/MM/yy, HH:mm");


        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
               hour = Integer.toString(i);
                min = Integer.toString(i1);
               tv = "Time: " + i + ":" + i1;
            }

        });
    }

    public long prepareCurr(){

        Date d = new  Date();
        String str;
        Date dd;
        long rr  = 0;

            str = df.format(d);
            try {
                dd = df.parse(str);
                Log.d("curr",str);
                rr = dd.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        return rr;
    }

    public long prepareOld(){
        String stry = date + "/" + month + "/" + year  + ", " + hour + ":" + min;
        Log.d("old",stry);
        long tyu = 0;

            try {
                Date dfg = df.parse(stry);
                tyu = dfg.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        return tyu;
    }

    public void tim(View view){
        //bot.setText(tv);

        Intent iy = new Intent(this,phMess.class);

        long curr = prepareCurr();
        long old = prepareOld();

        long diff = old - curr;

        if(diff<=0) {
            Toast.makeText(this,"You have selected a date from past",Toast.LENGTH_LONG).show();
            return;
        }

        iy.putExtra("old",old);

        Toast.makeText(this,"Alarm is set",Toast.LENGTH_LONG).show();
        startActivity(iy);
    }
}
