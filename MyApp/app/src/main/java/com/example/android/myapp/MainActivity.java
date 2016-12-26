package com.example.android.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    //public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    TextView change;
    Calendar cal;
    String str;
    CalendarView calV;
    String date;
    String mon;
    String year;
    String ph;
    String mess;
    int fl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            fl=0;
//        Intent ip = getIntent();
//        ph = ip.getStringExtra("ph");
//        mess = ip.getStringExtra("mess");

        cal = Calendar.getInstance();
        //change = (TextView) findViewById(R.id.textView2) ;
        calV = (CalendarView) findViewById(R.id.calendarView2);
        str = "Date: " + 23 + " / " + 1 + " / " + 1996;

        calV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                fl=1;
                //change.setText("Date: " + i2 + " / " + i1 + " / " + i);
                date = Integer.toString(i2);
                mon = Integer.toString(i1+1);
                year = Integer.toString(i);
                str = "Date: " + date + " / " + mon + " / " + year;
            }
        });

    }

    public void sendMessage(View view) {

        if(fl==0)
        {
            Toast.makeText(this,"You have selected a date from past",Toast.LENGTH_LONG).show();
            return;
        }

        Intent intent2 = new Intent(this,time.class);
        intent2.putExtra("date", date);
        intent2.putExtra("month",mon);
        intent2.putExtra("year",year);

        startActivity(intent2);
    }
}