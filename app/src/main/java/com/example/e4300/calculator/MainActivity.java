package com.example.e4300.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screenView;
    double currentValue=0;
    double hiddenValue = 0;
    boolean grows = true;
    double sinkingMultiply = 0.1;
    Operations operation = Operations.NOTHING;

    public void PointClick(View view) {
        grows = false;
    }

    public void MuliplyClick(View view) {
        setOperation(Operations.MULTIPLY);
    }

    public void DelimClick(View view) {
        setOperation(Operations.DELIM);
    }
    void setOperation(Operations op){
        if(operation != Operations.NOTHING){
            Result(findViewById(R.id.button_result));
        }
        hiddenValue = currentValue;
        operation = op;
        currentValue = 0;
        screenView.setText("0");
    }

    public void AddClick(View view) {
        setOperation(Operations.PLUS);
    }

    public void SubstractCLick(View view) {
        setOperation(Operations.MINUS);
    }

    public void ClearClick(View view) {
        currentValue = 0;
        hiddenValue = 0;
        grows = true;
        screenView.setText(String.valueOf(currentValue));
        sinkingMultiply = 0.1;
    }

    private enum Operations{NOTHING,PLUS,MINUS,DELIM,MULTIPLY}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screenView = (TextView) findViewById(R.id.screenView);
        if(savedInstanceState != null) {
            currentValue = savedInstanceState.getDouble("value");
            screenView.setText(String.valueOf(currentValue));
        }
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(1);
            }
        });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(2);
            }
        });
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(3);
            }
        });
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(4);
            }
        });
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(5);
            }
        });
        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(6);
            }
        });
        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(7);
            }
        });
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(8);
            }
        });
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(9);
            }
        });
        Button button0 = (Button) findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberClick(0);
            }
        });
    }
    private void numberClick(int number)
    {
        if (grows) currentValue = currentValue*10+number;
        else {
            currentValue = currentValue + (double)number * sinkingMultiply;
            sinkingMultiply *= 0.1;
        }
        screenView.setText(String.valueOf(currentValue));
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putDouble("value", currentValue);
    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity","resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void Result(View view) {
        switch (operation) {
            case DELIM:
                currentValue = hiddenValue/currentValue;
                break;
            case PLUS:
                currentValue = currentValue+hiddenValue;
                break;
            case MULTIPLY:
                currentValue = currentValue*hiddenValue;
                break;
            case  MINUS:
                currentValue = hiddenValue - currentValue;
                break;
        }
        operation = Operations.NOTHING;
        hiddenValue = 0;
        screenView.setText(String.valueOf(currentValue));
    }
}
