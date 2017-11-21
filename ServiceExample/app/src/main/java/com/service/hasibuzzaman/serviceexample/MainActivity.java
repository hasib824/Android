package com.service.hasibuzzaman.serviceexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText timeInput;
    Button start,End;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
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
        long time = Long.parseLong(trim); time *=60*1000;
        intent.putExtra("time",time);
         startService(intent);
    }

    public void End(View view) {
      stopService(new Intent(MainActivity.this,MyService.class));
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
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }
}
