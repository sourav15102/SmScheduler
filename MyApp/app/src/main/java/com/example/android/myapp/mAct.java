package com.example.android.myapp;

import android.Manifest;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

public class mAct extends BroadcastReceiver {

    String ph;
    String mess;
    Context cf;

    @Override
    public void onReceive(Context context, Intent intent) {

//        Intent i = new Intent();
//
//        i.setClass(context.getApplicationContext(), fin.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(i);

        cf = context;
        String phone = intent.getStringExtra("ph");
        String message = intent.getStringExtra("mess");

        String phoneNumber = "+91";
        phoneNumber += phone;

        sendSMSMessage(phoneNumber,message);

    }

    public void sendSMSMessage(String ph,String mess){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(ph, null, mess, null, null);

        Toast.makeText(cf, "Message sent", Toast.LENGTH_LONG).show();

        Intent i = new Intent();

        i.setClass(cf.getApplicationContext(), fin.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        cf.startActivity(i);

    }
}