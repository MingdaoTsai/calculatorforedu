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
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    TextView textViewDel;
    TextView textViewC;
    TextView textViewLeftp;
    TextView textViewRightp;


    TextView textView0;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textViewPoint;
    TextView textViewEqual;

    TextView textViewDiv;
    TextView textViewMultiply;
    TextView textViewMinus;
    TextView textViewAdd;


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

        textViewDel = (TextView) findViewById(R.id.textViewDel);
        textViewDel.setOnClickListener(textViewDelClickListener);
        textViewC = (TextView) findViewById(R.id.textViewC);
        textViewC.setOnClickListener(textViewClearClickListener);
        textViewLeftp = (TextView) findViewById(R.id.textViewLeftp);
        textViewLeftp.setOnClickListener(textViewNumClickListener);
        textViewRightp = (TextView) findViewById(R.id.textViewRightp);
        textViewRightp.setOnClickListener(textViewNumClickListener);

        textView0 = (TextView) findViewById(R.id.textView0);
        textView0.setOnClickListener(textViewNumClickListener);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(textViewNumClickListener);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(textViewNumClickListener);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(textViewNumClickListener);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(textViewNumClickListener);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(textViewNumClickListener);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(textViewNumClickListener);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setOnClickListener(textViewNumClickListener);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView8.setOnClickListener(textViewNumClickListener);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView9.setOnClickListener(textViewNumClickListener);

        textViewPoint = (TextView) findViewById(R.id.textViewPoint);
        textViewPoint.setOnClickListener(textViewNumClickListener);


        textViewAdd = (TextView) findViewById(R.id.textViewAdd);
        textViewAdd.setOnClickListener(textViewOperatorClickListener);
        textViewMinus = (TextView) findViewById(R.id.textViewMinus);
        textViewMinus.setOnClickListener(textViewOperatorClickListener);
        textViewMultiply = (TextView) findViewById(R.id.textViewMultiply);
        textViewMultiply.setOnClickListener(textViewOperatorClickListener);
        textViewDiv = (TextView) findViewById(R.id.textViewDiv);
        textViewDiv.setOnClickListener(textViewOperatorClickListener);


        textViewEqual = (TextView) findViewById(R.id.textViewEqual);
        textViewEqual.setOnClickListener(textViewEqualClickListener);







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

    View.OnClickListener textViewClearClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView clicked = (TextView) view;
                    String value = clicked.getText().toString();

                    textViewArithmetic.setText("");
                    textViewArithmeticPreview.setText("");
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

    View.OnClickListener textViewOperatorClickListener =
            new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView clicked = (TextView) view;
                    String value = clicked.getText().toString();

                    textViewArithmetic.append(value);

                }
            };

    View.OnClickListener textViewDelClickListener =
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


    View.OnClickListener textViewEqualClickListener =
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
