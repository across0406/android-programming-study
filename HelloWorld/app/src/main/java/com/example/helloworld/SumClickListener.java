package com.example.helloworld;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SumClickListener implements OnClickListener {
    private EditText inputA_;
    private EditText inputB_;
    private TextView resultTextView_;

    public SumClickListener(EditText inputA, EditText inputB, TextView resultTextView) {
        inputA_ = inputA;
        inputB_ = inputB;
        resultTextView_ = resultTextView;
    }

    @Override
    public void onClick(View view) {
        String inputAContent = inputA_.getText().toString();
        String inputBContent = inputB_.getText().toString();

        double convertedA = 0.0;
        double convertedB = 0.0;

        try {
            convertedA = Double.parseDouble(inputAContent);
            convertedB = Double.parseDouble(inputBContent);
            resultTextView_.setText(String.valueOf(convertedA + convertedB));
        } catch (NumberFormatException ex) {
            resultTextView_.setText(ex.getMessage());
            // Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}