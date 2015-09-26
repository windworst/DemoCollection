package com.xbw.democollection.threaddemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.xbw.democollection.R;

public class AsyncTaskDemoActivity extends Activity {
    private AsyncTask<Integer, Integer, Integer> asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_task_demo);
        final TextView tv = (TextView) findViewById(R.id.textViewAsyncShow);
        asyncTask = new AsyncTask<Integer, Integer,Integer>() {
            @Override
            protected Integer doInBackground(Integer... params) {
                int i = 0;
                while(i < 10000 && !isCancelled())
                {
                    ++i;
                    publishProgress(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return i;
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                Log.i("ASYNC", ""+values[0]);
                tv.setText(""+values[0]);
                super.onProgressUpdate(values);
            }
        };
        asyncTask.execute();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        asyncTask.cancel(true);
    }
}
