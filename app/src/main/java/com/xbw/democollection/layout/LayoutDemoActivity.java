package com.xbw.democollection.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.xbw.democollection.R;

public class LayoutDemoActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo);
        int layouts[] = new int[] {R.id.buttonFrameLayout, R.id.buttonRelativeLayout, R.id.buttonLinearLayout, R.id.buttonAbsoluteLayout, R.id.buttonTableLayout};
        for(int i=0; i<layouts.length; ++i) {
            final int finalI = i;
            findViewById(layouts[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LayoutDemoActivity.this, LayoutActivity.class).putExtra("index", finalI));
                }
            });
        }
    }
}
