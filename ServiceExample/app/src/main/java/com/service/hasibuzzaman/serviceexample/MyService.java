package com.service.hasibuzzaman.serviceexample;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Hasibuzzaman on 11/21/2017.
 */

public class MyService extends IntentService {

    Long time ;

    public MyService() {
        super("Has");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Ending", Toast.LENGTH_SHORT).show();
        stopSelf();
        super.onDestroy();

    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        time = intent.getLongExtra("time",000l);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Intent localIntent = new Intent("broadcast");
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);

        // Code will come to here after task completion , If interrupted , below section Doesn't run
        Log.e("Service Completed","Service");
       // Toast.makeText(this, "Service completed", Toast.LENGTH_SHORT).show();

    }
}
