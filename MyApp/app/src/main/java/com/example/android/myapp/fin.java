package com.example.android.myapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fin extends AppCompatActivity {

    EditText phoneNo;
    EditText message;
    Button  button;
    String ph;
    String mess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        Intent yt = getIntent();
//        ph = yt.getStringExtra("ph");
//        mess = yt.getStringExtra("mess");

        sendSMSMessage("+919717325200","helloo");

    }

    public void sendSMSMessage(String ph,String mess){
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(ph, null, mess, null, null);
        Toast.makeText(this, "Message sent", Toast.LENGTH_LONG).show();
    }

}
