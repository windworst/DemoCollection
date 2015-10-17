package com.xbw.democollection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.xbw.democollection.activityLifetime.DemoActivityLifeTimeAActivity;
import com.xbw.democollection.dialog.DialogActivity;
import com.xbw.democollection.layout.LayoutDemoActivity;
import com.xbw.democollection.serviceLifeTime.DemoServiceActivity;
import com.xbw.democollection.threaddemo.AsyncTaskDemoActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private List<Map<String,Object>> mData = null;
    private List<Map<String,Object>> getData(String[] titleList) {
        if(mData == null) {
            mData = new ArrayList<>();
            for(String title:titleList) {
                Map<String,Object> map = new HashMap<>();
                map.put("title", title);
                mData.add(map);
            }
        }
        return mData;
    }
    String[] titleList = {
            "Activity生命周期演示", "Service生命周期演示", "Intent演示", "Layout演示", "AsyncTask", "Dialog"
    };
    Intent[] intentList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentList = new Intent[]{
                new Intent(MainActivity.this, DemoActivityLifeTimeAActivity.class),
                new Intent(MainActivity.this, DemoServiceActivity.class),
                new Intent().setData(Uri.parse("tel:" + 1111111)),
                new Intent(MainActivity.this, LayoutDemoActivity.class),
                new Intent(MainActivity.this, AsyncTaskDemoActivity.class),
                new Intent(MainActivity.this, DialogActivity.class)
        };
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new SimpleAdapter(this, getData(titleList), R.layout.listview_item, new String[]{"title"}, new int[]{R.id.tv_title}));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (0 <= position && position < intentList.length && 0 < titleList.length) {
                    startActivity(intentList[position]);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
