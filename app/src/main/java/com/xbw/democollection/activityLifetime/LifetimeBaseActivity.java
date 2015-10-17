package com.xbw.democollection.activityLifetime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.xbw.democollection.R;

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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        outputInfo("onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outputInfo("onSaveInstanceState()");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        Activity a = this.getParent();
        if(a!=null){
            a.overridePendingTransition(R.anim.slide_left_in,R.anim.slide_left_out);
        }
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }
}
