package com.tuantran.custombroadcast2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtName,edtAddress,edtPhone;
    private static final String MY_ACTION = "MY_ACTION";
    private static final String MY_KEY_NAME = "MY_KEY_NAME";
    private static final String MY_KEY_ADDRESS = "MY_KEY_ADDRESS";
    private static final String MY_KEY_PHONENUMBER = "MY_KEY_PHONENUMBER";
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (MY_ACTION.equals(intent.getAction())){
                String name = intent.getStringExtra(MY_KEY_NAME);
                String address = intent.getStringExtra(MY_KEY_ADDRESS);
                String phone = intent.getStringExtra(MY_KEY_PHONENUMBER);
                edtName.setText(name);
                edtAddress.setText(address);
                edtPhone.setText(phone);

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtPhone = findViewById(R.id.edtPhone);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(MY_ACTION);
        registerReceiver(broadcastReceiver,intentFilter);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}