/*
 ************************ Assignment #HOMEWORK 02 *******************************************
 *********************** File Name- MainActivity.java *************************************
 ************************ Full Name- 1. Manali Ghare 2. Anup Deshpande (Group 19) ***********

 */




package com.example.manalighare.group19_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView length_label1;
    private TextView length_label2;
    private TextView display_shapename;
    private TextView display_result;

    private EditText length1;
    private EditText length2;

    private ImageView triangle;
    private ImageView square;
    private ImageView circle;

    private Button calculate;
    private Button clear;

    private  double area;
    private double l1,l2=0;
    private int shape_value=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");

        length_label1 = (TextView) findViewById(R.id.length_one_label);
        length_label2 = (TextView) findViewById(R.id.length_two_label);
        display_shapename = (TextView) findViewById(R.id.shape);
        display_result = (TextView) findViewById(R.id.display_result);

        length1 = (EditText) findViewById(R.id.length1);
        length2 = (EditText) findViewById(R.id.length2);

        triangle = (ImageView) findViewById(R.id.triangle);
        square = (ImageView) findViewById(R.id.square);
        circle = (ImageView) findViewById(R.id.circle);

        clear = (Button) findViewById(R.id.clear);
        calculate =(Button) findViewById(R.id.calculate_btn);

        triangle.setOnClickListener(this);
        square.setOnClickListener(this);
        circle.setOnClickListener(this);
        clear.setOnClickListener(this);
        calculate.setOnClickListener(this);

    }

    public void onClick(View v) {

        if (v.getId() == R.id.triangle) {
            display_shapename.setText("Triangle");
            display_result.setText(" ");
            shape_value=1;
            length_label2.setVisibility(TextView.VISIBLE);
            length2.setVisibility(EditText.VISIBLE);
            length1.setText("");
            length2.setText("");
            length1.setError(null);
            length2.setError(null);

        } else if (v.getId() == R.id.square) {
            display_shapename.setText("Square");
            display_result.setText(" ");
            shape_value=2;
            length_label2.setVisibility(TextView.INVISIBLE);
            length2.setVisibility(EditText.INVISIBLE);
            length1.setText("");
            length2.setText("");
            length1.setError(null);
            length2.setError(null);

        } else if (v.getId() == R.id.circle) {
            display_shapename.setText("Circle");
            display_result.setText("");
            shape_value=3;
            length_label2.setVisibility(TextView.INVISIBLE);
            length2.setVisibility(EditText.INVISIBLE);
            length1.setText("");
            length2.setText("");
            length1.setError(null);
            length2.setError(null);

        } else if (v.getId() == R.id.clear){
            length_label2.setVisibility(TextView.VISIBLE);
            length2.setVisibility(EditText.VISIBLE);
            length1.setText(" ");
            length2.setText(" ");
            display_result.setText(" ");
            display_shapename.setText(R.string.default_string);
            shape_value=0;
            length1.setError(null);
            length2.setError(null);

        } else if (v.getId() == R.id.calculate_btn){

            l1=0;
            l2=0;

            try{

                l1=Double.parseDouble(length1.getText().toString());
                l2=Double.parseDouble(length2.getText().toString());

            }catch (Exception e) {
                Log.d("error","error aala na bhooo");
                if (length1.getText().length() == 0 && length2.getText().length() == 0) {
                    length1.setError("Please enter length1");
                    length2.setError("Please enter length2");

                } else if (length1.getText().length() == 0) {
                    length1.setError("Please enter length1");
                } else if (length2.getText().length() == 0) {

                    length2.setError("Please enter length2");
                }
            }

           if(shape_value==1){
                area = 0.5*l1*l2;
                display_result.setText(String.valueOf(area));

            }else  if (shape_value==2){
                area = l1*l1;
                display_result.setText(String.valueOf(area));

            }else if (shape_value==3){
                area = 3.1416*l1*l1;
                display_result.setText(String.valueOf(area));
            }else{
                Toast.makeText(this,"Please select a shape", Toast.LENGTH_LONG).show();
            }

        }



    }
}

