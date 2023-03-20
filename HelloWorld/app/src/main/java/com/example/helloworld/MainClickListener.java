package com.example.helloworld;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.TextView;

public class MainClickListener implements OnClickListener {
    private TextView textView_;

    public MainClickListener(TextView textView) {
        textView_ = textView;
    }

    @Override
    public void onClick(View view) {
        textView_.setText("Clicked!!!!!!!");
    }
}
