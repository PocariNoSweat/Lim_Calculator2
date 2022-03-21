package com.example.lim_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btndot, btnequal, btnreset, btnmodule, btnplus, btnminus, btnmultiply, btndivide;

    TextView inputtxt, outputtxt;

    String data;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        enableFullscreen();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputtxt = findViewById(R.id.outPuttxt);
        inputtxt = findViewById(R.id.inputTxt);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btndot = findViewById(R.id.btndot);
        btnequal = findViewById(R.id.btnequal);
        btnreset = findViewById(R.id.btnreset);
        btnmodule = findViewById(R.id.btnmodule);
        btnplus = findViewById(R.id.btnplus);
        btnminus = findViewById(R.id.btnminus);
        btnmultiply = findViewById(R.id.btnmultiply);
        btndivide = findViewById(R.id.btndivide);

        btn0.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "0");
        });

        btn1.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "1");
        });

        btn2.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "2");
        });


        btn3.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "3");
        });

        btn4.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "4");
        });

        btn5.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "5");
        });

        btn6.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "6");
        });

        btn7.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "7");
        });

        btn8.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "8");
        });

        btn9.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "9");
        });

        btnreset.setOnClickListener(v -> {
            inputtxt.setText("");
            outputtxt.setText("");
        });

        btndot.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + ".");
        });

        btnplus.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "+");
        });

        btnminus.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "-");
        });

        btnmodule.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "%");
        });

        btnmultiply.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "×");
        });

        btndivide.setOnClickListener(v -> {
            data = inputtxt.getText().toString();
            inputtxt.setText(data + "÷");
        });

        btnequal.setOnClickListener(v -> {
            data = inputtxt.getText().toString();

            data = data.replaceAll("×", "*");
            data = data.replaceAll("%", "/100");
            data = data.replaceAll("÷", "/");

            Context rhino=Context.enter();
            rhino.setOptimizationLevel(-1);

            String finalResult;

            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable, data, "Javascript", 1, null).toString();

            outputtxt.setText(finalResult);

        });

    }
    private void enableFullscreen() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }
}