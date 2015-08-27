package com.xbw.democollection.activityLifetime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xbw.democollection.R;

/**
 * Created by anonymous on 15-8-27.
 */
public class DemoAActivity extends LifetimeBaseActivity {
    @Override
    protected String getActivityName() {
        return getLocalClassName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_a);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DemoAActivity.this,DemoBActivity.class));
            }
        });
    }
}
