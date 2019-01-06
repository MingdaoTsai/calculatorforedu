package com.imagelab.calculatorforedu;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    //test pc sync
    boolean initstat= true;
    Button button_c;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    Button button_point;

    Button button_add;
    Button button_minus;
    Button button_multiply;
    Button button_div;
    Button button_percentage;

    Button button_equal;

    TextView textViewArithmetic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewArithmetic = (TextView) findViewById(R.id.textViewArithmetic);

        button_c = (Button) findViewById(R.id.button_c);
        button_c.setOnClickListener(buttonClearClickListener);

        button0 = (Button) findViewById(R.id.button_0);
        button0.setOnClickListener(buttonNumClickListener);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(buttonNumClickListener);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(buttonNumClickListener);
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(buttonNumClickListener);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(buttonNumClickListener);
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(buttonNumClickListener);
        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(buttonNumClickListener);
        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(buttonNumClickListener);
        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(buttonNumClickListener);
        button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(buttonNumClickListener);

        button_point = (Button) findViewById(R.id.button_point);
        button_point.setOnClickListener(buttonNumClickListener);

        button_add = (Button) findViewById(R.id.button_add);
        button_add.setOnClickListener(buttonOperatorClickListener);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_minus.setOnClickListener(buttonOperatorClickListener);
        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_multiply.setOnClickListener(buttonOperatorClickListener);
        button_div = (Button) findViewById(R.id.button_div);
        button_div.setOnClickListener(buttonOperatorClickListener);
        button_percentage = (Button) findViewById(R.id.button_percentage);
        button_percentage.setOnClickListener(buttonOperatorClickListener);

        button_equal = (Button) findViewById(R.id.button_equal);
        button_equal.setOnClickListener(buttonEqualClickListener);
        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
    }

    View.OnClickListener buttonClearClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clicked = (Button) view;
                    String value = clicked.getText().toString();

                    textViewArithmetic.setText("0");
                    initstat=true;
                }
            };

    View.OnClickListener buttonNumClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clicked = (Button) view;
                    String value = clicked.getText().toString();

                    if(initstat)
                    {
                        initstat = false;
                        textViewArithmetic.setText("");
                    }
                    textViewArithmetic.append(value);

                }
            };

    View.OnClickListener buttonOperatorClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clicked = (Button) view;
                    String value = clicked.getText().toString();

                    textViewArithmetic.append(value);

                }
            };

    View.OnClickListener buttonEqualClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Button clicked = (Button) view;
                    //String value = clicked.getText().toString();

                    //textViewTest1.setText(Build.MODEL);
                    //textViewArithmetic.append(value);
                    String calcString;
                    calcString = textViewArithmetic.getText().toString();
                    calcString = calcString.replace('÷','/');
                    calcString = calcString.replace('x','*');
                    Expression calc = new ExpressionBuilder(calcString)
                            .build();
                    double result1 = calc.evaluate();
                    textViewArithmetic.setText(String.valueOf(result1));

                }
            };
}
