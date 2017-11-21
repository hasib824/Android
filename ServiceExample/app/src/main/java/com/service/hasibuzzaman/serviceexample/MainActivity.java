package com.service.hasibuzzaman.serviceexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText timeInput;
    Button start,End;
    LocalBroadcastManager localBroadcastManager ;
    MyBroadcastReceiver myBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        localBroadcastManager = LocalBroadcastManager.getInstance(MainActivity.this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("broadcast");
        myBroadcastReceiver = new MyBroadcastReceiver();
        localBroadcastManager.registerReceiver(myBroadcastReceiver,intentFilter);
    }

    private class MyBroadcastReceiver extends BroadcastReceiver
    {
        // Prevents instantiation
        private MyBroadcastReceiver() {
        }
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("broadcast"))
                 MainActivity.this.finish();
        }
    }

    void getViews()
    {
        timeInput = findViewById(R.id.time);
        start = findViewById(R.id.start);
        End = findViewById(R.id.end);
    }

    public void Start(View view) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        final String trim = timeInput.getText().toString().trim();
        timeInput.clearFocus();
        long time = Long.parseLong(trim); time *=60*1000;
        intent.putExtra("time",time);
         startService(intent);
    }

    public void End(View view) {
      stopService(new Intent(MainActivity.this,MyService.class));
        timeInput.clearFocus();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        localBroadcastManager.unregisterReceiver(myBroadcastReceiver);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }
}
