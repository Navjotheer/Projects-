package com.example.navjotheer.powergenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double exponent;
    private double answer;
    private double rounded;
    Button button, button2, button3, button4;
    EditText etExponent, etExponent2, etExponent3, etExponent4;
    TextView tvAnswer, tvAnswer2, tvAnswer3, tvAnswer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        etExponent = (EditText) findViewById(R.id.etExponent);
        tvAnswer = (TextView) findViewById(R.id.tvAnswer);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    double exp = Double.parseDouble(etExponent.getText().toString());
                    double answer = Math.pow(2, exp);
                    double rounded = Math.round(answer * 1000) / ((double) 1000);
                    String s = String.format("%.2f", rounded);
                    tvAnswer.setText("Answer: " + String.valueOf(s));




            }
        });



        button2 = (Button) findViewById(R.id.button2);
        etExponent2 = (EditText) findViewById(R.id.etExponent2);
        tvAnswer2 = (TextView) findViewById(R.id.tvAnswer2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double exp = Double.parseDouble(etExponent2.getText().toString());
                double answer = Math.pow(3,exp);
                double rounded = Math.round(answer*1000)/((double)1000);
                String s = String.format("%.2f", rounded);
                tvAnswer2.setText("Answer: "+String.valueOf(s));



            }
        });

        button3 = (Button) findViewById(R.id.button3);
        etExponent3 = (EditText) findViewById(R.id.etExponent3);
        tvAnswer3 = (TextView) findViewById(R.id.tvAnswer3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double exp = Double.parseDouble(etExponent3.getText().toString());
                double answer = Math.pow(4,exp);
                double rounded = Math.round(answer*1000)/((double)1000);
                String s = String.format("%.2f", rounded);
                tvAnswer3.setText("Answer: "+String.valueOf(s));



            }
        });

        button4 = (Button) findViewById(R.id.button4);
        etExponent4 = (EditText) findViewById(R.id.etExponent4);
        tvAnswer4 = (TextView) findViewById(R.id.tvAnswer4);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double exp = Double.parseDouble(etExponent4.getText().toString());
                double answer = Math.pow(4,exp);
                double rounded = Math.round(answer*1000)/((double)1000);
                String s = String.format("%.2f", rounded);
                tvAnswer4.setText("Answer: "+String.valueOf(s));



            }
        });


    }
}
