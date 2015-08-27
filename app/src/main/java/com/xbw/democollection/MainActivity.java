package com.xbw.democollection;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.xbw.democollection.activityLifetime.DemoAActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private String[] mTitle = {
        "Activity生命周期演示"
    };

    private Class[] mActivityClassList = {
        DemoAActivity.class
    };

    private List<Map<String,Object>> mData = null;
    private List<Map<String,Object>> getData() {
        if(mData == null) {
            mData = new ArrayList<>();
            for(String title:mTitle) {
                Map<String,Object> map = new HashMap<>();
                map.put("title", title);
                mData.add(map);
            }
        }
        return mData;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(new SimpleAdapter(this,getData(),R.layout.listview_item,new String[]{"title"}, new int[]{R.id.tv_title}));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(0<=position && position< mActivityClassList.length) {
                    startActivity(new Intent(MainActivity.this, mActivityClassList[position]));
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
