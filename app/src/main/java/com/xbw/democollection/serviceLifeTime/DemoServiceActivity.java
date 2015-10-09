package com.xbw.democollection.serviceLifeTime;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.xbw.democollection.R;

public class DemoServiceActivity extends Activity {
    private final  static String TAG = "SERVICE_LIFE_TIME";
    private ServiceConnection mConn;
    private IDemoService mAidlService;

    private void outputInfo(String info) {
        String output = "DemoServiceActivity" + " : " + info;
        Log.i(TAG, output);
        Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);
        final Context context = this;
        final Intent intent = new Intent(context, DemoService.class);
        findViewById(R.id.buttonBindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mConn = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        mAidlService = IDemoService.Stub.asInterface(service);
                        outputInfo(name.toString());
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        mAidlService = null;
                        outputInfo(name.toString());
                    }
                };
                bindService(intent, mConn, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.buttonStartService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        findViewById(R.id.buttonStopService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        findViewById(R.id.buttonUnbindService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mConn != null) {
                    unbindService(mConn);
                    mConn = null;
                }
            }
        });
        findViewById(R.id.buttonAidlCall).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAidlService != null) {
                    String string = null;
                    try {
                        string = mAidlService.get();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    outputInfo(string);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mConn != null) {
            unbindService(mConn);
            mConn = null;
        }
    }
}
