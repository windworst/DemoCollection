package com.xbw.democollection.activityLifetime;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by anonymous on 15-8-27.
 */
public abstract class LifetimeBaseActivity extends Activity {

    private final  static String TAG = "LIFE_TIME";
    private void outputInfo(String info) {
        String output = getActivityName() + " : " + info;
        Log.i(TAG, output);
        Toast.makeText(this, output,Toast.LENGTH_SHORT).show();
    }

    protected abstract String getActivityName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        outputInfo("onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        outputInfo("onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        outputInfo("onStart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        outputInfo("onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        outputInfo("onStop()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        outputInfo("onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        outputInfo("onResume()");
    }
}
