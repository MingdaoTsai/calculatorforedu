package com.imagelab.calculatorforedu;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

//import net.objecthunter.exp4j.Expression;
//import net.objecthunter.exp4j.ExpressionBuilder;
//import net.objecthunter.exp4j.ValidationResult;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

public class MainActivity extends AppCompatActivity {

    //test pc sync
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

    Button button_leftp;
    Button button_rightp;

    Button button_point;

    Button button_add;
    Button button_minus;
    Button button_multiply;
    Button button_div;
    Button button_percentage;

    Button button_del;
    Button button_equal;


    TextView textViewDel;
    TextView textView7;
    TextView textView4;
    TextView textView1;
    TextView textView0;

    TextView textViewArithmetic;
    public TextView textViewArithmeticPreview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        textViewArithmetic = (TextView) findViewById(R.id.textViewArithmetic);

        textViewArithmeticPreview = (TextView) findViewById(R.id.textViewArithmeticPreview);
        textViewArithmeticPreview.setOnClickListener(textViewArithmeticPreviewClickListener);

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

        button_leftp = (Button) findViewById(R.id.button_leftp);
        button_leftp.setOnClickListener(buttonNumClickListener);
        button_rightp = (Button) findViewById(R.id.button_rightp);
        button_rightp.setOnClickListener(buttonNumClickListener);

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

        button_del = (Button) findViewById(R.id.button_del);
        button_del.setOnClickListener(buttonDelClickListener);

        button_equal = (Button) findViewById(R.id.button_equal);
        button_equal.setOnClickListener(buttonEqualClickListener);


        textViewDel = (TextView) findViewById(R.id.textViewDel);
        textViewDel.setOnClickListener(buttonDelClickListener);

        textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setOnClickListener(textViewNumClickListener);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(textViewNumClickListener);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(textViewNumClickListener);
        textView0 = (TextView) findViewById(R.id.textView0);
        textView0.setOnClickListener(textViewNumClickListener);


        //顯示DPI type
        //DisplayMetrics metrics = getResources().getDisplayMetrics();
        //textViewArithmeticPreview.setText(String.valueOf(metrics.densityDpi));



        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //Here you can get the size!
        //button_c.setText(String.valueOf(button_c.getHeight()));
        //button7.setTextSize(pxToDp(button7.getHeight()/2));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            //button7.setTextSize(pxToDp(button7.getHeight()/2));
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            //Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
            //button7.setTextSize(pxToDp(button7.getHeight()/2));
        }
    }
    /*
    private static String getDensityName(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return "xxxhdpi";
        }
        if (density >= 3.0) {
            return "xxhdpi";
        }
        if (density >= 2.0) {
            return "xhdpi";
        }
        if (density >= 1.5) {
            return "hdpi";
        }
        if (density >= 1.0) {
            return "mdpi";
        }
        return "ldpi";
    }
*/

    View.OnClickListener buttonClearClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clicked = (Button) view;
                    String value = clicked.getText().toString();

                    textViewArithmetic.setText("");
                    textViewArithmeticPreview.setText("");
                }
            };

    View.OnClickListener buttonNumClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button clicked = (Button) view;
                    String value = clicked.getText().toString();

                    textViewArithmetic.append(value);

                }
            };

    View.OnClickListener textViewNumClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView clicked = (TextView) view;
                    String value = clicked.getText().toString();

                    textViewArithmetic.append(value);

                }
            };

    View.OnClickListener textViewArithmeticPreviewClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView clicked = (TextView) view;
                    String value = clicked.getText().toString();


                    textViewArithmetic.setText(value);
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

    View.OnClickListener buttonDelClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String str =textViewArithmetic.getText().toString();
                    if (str.length()>0)
                    {
                        str = str.substring(0, str.length() - 1);
                    }
                    textViewArithmetic.setText(str);
                    //textViewArithmeticPreview.setText("");
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

                    textViewArithmeticPreview.setText(ExpressionToDouble(calcString));

                }
            };

    public static String fmt(double d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }

    //use mXparser lib
    public static String ExpressionToDouble(String calc_str)
    {
        calc_str = calc_str.replace('÷','/');
        calc_str = calc_str.replace('x','*');

        Expression eh = new Expression(calc_str);
        //String h = mXparser.number( eh.calculate() );

        return fmt((double) eh.calculate());
    }
    /*
    //use exp4j
    public static String ExpressionToDouble(String calc_str)
    {
        calc_str = calc_str.replace('÷','/');
        calc_str = calc_str.replace('x','*');

        Expression calc;
        try {
            calc = new ExpressionBuilder(calc_str)
                    .build();

        }
        catch (Exception e) {
            return "ERR1";
            //extViewArithmeticPreview.setText("not a valid expression");
        }

        ValidationResult res = calc.validate();

        if (res.isValid()) {
            double result1 = calc.evaluate();
            return fmt(result1);
        } else {
            return "ERR2";
        }
    }
    */
}
