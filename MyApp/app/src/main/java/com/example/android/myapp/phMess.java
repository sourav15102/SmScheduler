package com.example.android.myapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class phMess extends AppCompatActivity {

    long old;
    Button b;
    EditText ph;
    EditText mess;
    String phone;
    String message;
    TextView datime;
    String finl;
    Button pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph_mess);

        Intent qw = getIntent();

        old = qw.getLongExtra("old",0);
        finl = qw.getStringExtra("finl");
        datime = (TextView) findViewById(R.id.textView6);
        b = (Button) findViewById(R.id.button5);
        ph = (EditText) findViewById(R.id.editText);
        mess = (EditText) findViewById(R.id.editText5);
        datime.setText(finl);
        pb = (Button) findViewById(R.id.button11);

        pb.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });

    }

    public void set(View view){

        if(old==0){
            Toast.makeText(this,"Problem",Toast.LENGTH_LONG).show();
            return;
        }

        phone = ph.getText().toString();
        message = mess.getText().toString();

        Intent it = new Intent(this,mAct.class);

        it.putExtra("ph",phone);
        it.putExtra("mess",message);

        PendingIntent pendintIntent = PendingIntent.getBroadcast(this.getApplicationContext(),1,it,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, old, pendintIntent);

        Toast.makeText(this,"Registered",Toast.LENGTH_LONG).show();
    }
}