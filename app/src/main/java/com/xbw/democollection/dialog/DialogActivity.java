package com.xbw.democollection.dialog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.xbw.democollection.R;

public class DialogActivity extends Activity {
    private Button mButton;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
        mButton = (Button) findViewById(R.id.buttonDialog);
        mButton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(mFragment, "").commit();
                Fragment f1 = new Fragment() {
                    @Nullable
                    @Override
                    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                        return LayoutInflater.from(DialogActivity.this).inflate(R.layout.dialog_fragment1, null);
                    }
                };
//                Fragment f2 = new Fragment() {
//                    @Nullable
//                    @Override
//                    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//                        return LayoutInflater.from(DialogActivity.this).inflate(R.layout.dialog_fragment2, null);
//                    }
//                };
//                mFragment.getFragmentManager().beginTransaction().add(R.id.child_content, f1).commit();
            }
        });
        mFragment = new DialogFragment(){
            @Nullable
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                return LayoutInflater.from(DialogActivity.this).inflate(R.layout.dialog_fragment,null);
            }
        };
    }
}
