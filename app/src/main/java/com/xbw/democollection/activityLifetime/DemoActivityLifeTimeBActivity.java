package com.xbw.democollection.activityLifetime;

import android.os.Bundle;

import com.xbw.democollection.R;

/**
 * Created by anonymous on 15-8-27.
 */
public class DemoActivityLifeTimeBActivity extends LifetimeBaseActivity{
    @Override
    protected String getActivityName() {
        return getLocalClassName();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_b);
    }
}
