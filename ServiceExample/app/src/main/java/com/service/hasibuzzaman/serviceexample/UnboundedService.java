package com.service.hasibuzzaman.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Hasibuzzaman on 11/22/2017.
 */

public class UnboundedService extends Service {
    @Nullable



    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(intent.getLongExtra("time",00l));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Log.e("alive","alive");
                    stopSelf();
                }
            }).start();
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Statted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Dead", Toast.LENGTH_SHORT).show();

    }
}
