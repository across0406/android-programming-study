package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputA = (EditText)findViewById(R.id.inputA);
        EditText inputB = (EditText)findViewById(R.id.inputB);
        Button sumButton = (Button)findViewById(R.id.sumButton);
        Button subtractButton = (Button)findViewById(R.id.subtractButton);
        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);

        sumButton.setOnClickListener(new SumClickListener(inputA, inputB, resultTextView));
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputAContent = inputA.getText().toString();
                String inputBContent = inputB.getText().toString();

                double convertedA = 0.0;
                double convertedB = 0.0;

                try {
                    convertedA = Double.parseDouble(inputAContent);
                    convertedB = Double.parseDouble(inputBContent);
                    resultTextView.setText(String.valueOf(convertedA - convertedB));
                } catch (NumberFormatException ex) {
                    // resultTextView.setText(ex.getMessage());
                    Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}