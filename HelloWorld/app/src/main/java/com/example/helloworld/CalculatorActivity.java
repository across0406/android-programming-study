package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    private Intent goToMain_;
    private Intent fromMain_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button goToMainButton = (Button)findViewById(R.id.goToMainButton);
        EditText inputA = (EditText)findViewById(R.id.inputA);
        EditText inputB = (EditText)findViewById(R.id.inputB);
        Button sumButton = (Button)findViewById(R.id.sumButton);
        Button subtractButton = (Button)findViewById(R.id.subtractButton);
        TextView resultTextView = (TextView)findViewById(R.id.resultTextView);

        goToMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (goToMain_ == null) {
                    goToMain_ = new Intent(getApplicationContext(), MainActivity.class);
                }

                Bundle bundle = new Bundle();

                String inputAContent = inputA.getText().toString();
                String inputBContent = inputB.getText().toString();
                String resultContent = resultTextView.getText().toString();
                double inputADouble = 0.0;
                double inputBDouble = 0.0;
                double resultDouble = 0.0;

                try {
                    inputADouble = Double.parseDouble(inputAContent);
                    inputBDouble = Double.parseDouble(inputBContent);
                    resultDouble = Double.parseDouble(resultContent);
                } catch (NumberFormatException ex) {
                    inputADouble = 0.0;
                    inputBDouble = 0.0;
                    resultDouble = 0.0;
                }

                bundle.putSerializable("calculatorcontext", new CalculatorContext(inputADouble, inputBDouble, resultDouble));
                goToMain_.putExtras(bundle);
                startActivity(goToMain_);
            }
        });

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

        if (fromMain_ == null) {
            fromMain_ = getIntent();
        }

        CalculatorContext context = (CalculatorContext)fromMain_.getSerializableExtra("calculatorcontext");
        inputA.setText(Double.toString(context.getInputA()));
        inputB.setText(Double.toString(context.getInputB()));
        resultTextView.setText(Double.toString(context.getResult()));
    }
}