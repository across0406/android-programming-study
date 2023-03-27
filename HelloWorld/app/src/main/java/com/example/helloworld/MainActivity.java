package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Intent goToCalculator_;
    private Intent fromCalcultor_;

    private double inputA_;
    private double inputB_;
    private double result_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputA_ = 0.0;
        inputB_ = 0.0;
        result_ = 0.0;

        Button goToCalculatorButton = (Button)findViewById(R.id.goToCalculatorButton);

        goToCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (goToCalculator_ == null) {
                    goToCalculator_ = new Intent(getApplicationContext(), CalculatorActivity.class);
                }

                Bundle bundle = new Bundle();
                bundle.putSerializable("calculatorcontext", new CalculatorContext(inputA_, inputB_, result_));
                goToCalculator_.putExtras(bundle);
                startActivity(goToCalculator_);
            }
        });

        if (fromCalcultor_ == null) {
            fromCalcultor_ = getIntent();
        }

        CalculatorContext context = (CalculatorContext)fromCalcultor_.getSerializableExtra("calculatorcontext");
        if (context != null) {
            inputA_ = context.getInputA();
            inputB_ = context.getInputB();
            result_ = context.getResult();
        }
    }
}