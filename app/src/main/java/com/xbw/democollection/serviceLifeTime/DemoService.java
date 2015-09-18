package com.xbw.democollection.serviceLifeTime;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class DemoService extends Service {

    private final  static String TAG = "SERVICE_LIFE_TIME";
    private void outputInfo(String info) {
        String output = "DemoService" + " : " + info;
        Log.i(TAG, output);
        Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        outputInfo("onBind()");
        return null;
    }

    @Override
    public void onRebind(Intent intent) {
        outputInfo("onRebind()");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        outputInfo("onUnbind()");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        outputInfo("onDestroy()");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        outputInfo("onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        outputInfo("onCreate()");
        super.onCreate();
    }
}
