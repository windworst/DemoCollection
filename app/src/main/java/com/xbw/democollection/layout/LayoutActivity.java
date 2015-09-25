package com.xbw.democollection.layout;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.xbw.democollection.R;

public class LayoutActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int index = getIntent().getExtras().getInt("index");
        int ids[] = { R.layout.frame_layout, R.layout.relative_layout, R.layout.linear_layout, R.layout.absolute_layout, R.layout.table_layout };
        if(0>index) index = 0;
        if(ids.length<=index) index = ids.length;
        setContentView(ids[index]);
        Toast.makeText(this,"" + index, Toast.LENGTH_LONG).show();
    }
}
