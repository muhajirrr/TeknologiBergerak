package com.muhajirlatif.tekber.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muhajirlatif.tekber.R;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etResult;
    private Button btnClear, btnDot, btnEqual, btnAdd, btnSubtract, btnMultiply, btnDivide, btnZero,
            btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnLogout,
            btnDB;

    private Double firstValue, secondValue, result;
    private String temp;
    private boolean add, subtract, divide, multiply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        etResult = findViewById(R.id.etResult);
        btnClear = findViewById(R.id.btnClear);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply =  findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);

        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        temp = "";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnZero:
                temp = temp + "0";
                etResult.setText(etResult.getText() + "0");
                break;

            case R.id.btnOne:
                temp = temp + "1";
                etResult.setText(etResult.getText() + "1");
                break;

            case R.id.btnTwo:
                temp = temp + "2";
                etResult.setText(etResult.getText() + "2");
                break;

            case R.id.btnThree:
                temp = temp + "3";
                etResult.setText(etResult.getText() + "3");
                break;

            case R.id.btnFour:
                temp = temp + "4";
                etResult.setText(etResult.getText() + "4");
                break;

            case R.id.btnFive:
                temp = temp + "5";
                etResult.setText(etResult.getText() + "5");
                break;

            case R.id.btnSix:
                temp = temp + "6";
                etResult.setText(etResult.getText() + "6");
                break;

            case R.id.btnSeven:
                temp = temp + "7";
                etResult.setText(etResult.getText() + "7");
                break;

            case R.id.btnEight:
                temp = temp + "8";
                etResult.setText(etResult.getText() + "8");
                break;

            case R.id.btnNine:
                temp = temp + "9";
                etResult.setText(etResult.getText() + "9");
                break;

            case R.id.btnDot:
                temp = temp + ".";
                etResult.setText(etResult.getText() + ".");
                break;

            case R.id.btnAdd:
                if (!temp.isEmpty()) {
                    firstValue = Double.parseDouble(temp);
                    temp = "";
                    add = true;
                    etResult.setText(etResult.getText() + "+");
                }
                break;

            case R.id.btnSubtract:
                if (!temp.isEmpty()) {
                    firstValue = Double.parseDouble(temp);
                    temp = "";
                    subtract = true;
                    etResult.setText(etResult.getText() + "-");
                }
                break;

            case R.id.btnMultiply:
                if (!temp.isEmpty()) {
                    firstValue = Double.parseDouble(temp);
                    temp = "";
                    multiply = true;
                    etResult.setText(etResult.getText() + "*");
                }
                break;

            case R.id.btnDivide:
                if (!temp.isEmpty()) {
                    firstValue = Double.parseDouble(temp);
                    temp = "";
                    divide = true;
                    etResult.setText(etResult.getText() + "/");
                }
                break;

            case R.id.btnEqual:
                if (!temp.isEmpty() && (firstValue != null)) {
                    secondValue = Double.parseDouble(temp);
                    temp = "";

                    if (add) {
                        result = firstValue + secondValue;
                        add = false;
                    } else if (subtract) {
                        result = firstValue - secondValue;
                        subtract = false;
                    } else if (multiply) {
                        result = firstValue * secondValue;
                        multiply = false;
                    } else if (divide) {
                        result = firstValue / secondValue;
                        divide = false;
                    }

                    etResult.setText(result.toString());
                    setEnabledButton(false);
                }
                break;

            case R.id.btnClear:
                temp = "";
                etResult.setText("");
                setEnabledButton(true);
                break;
        }
    }

    private void setEnabledButton(boolean value) {
        btnZero.setEnabled(value);
        btnOne.setEnabled(value);
        btnTwo.setEnabled(value);
        btnThree.setEnabled(value);
        btnFour.setEnabled(value);
        btnFive.setEnabled(value);
        btnSix.setEnabled(value);
        btnSeven.setEnabled(value);
        btnEight.setEnabled(value);
        btnNine.setEnabled(value);
        btnDot.setEnabled(value);
        btnAdd.setEnabled(value);
        btnSubtract.setEnabled(value);
        btnMultiply.setEnabled(value);
        btnDivide.setEnabled(value);
        btnEqual.setEnabled(value);
    }

}
