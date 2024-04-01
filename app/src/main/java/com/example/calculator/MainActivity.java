package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView resultTv;
    Integer firstNumber;
    Integer secondNumber;
    String operation;
    boolean isOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       resultTv= findViewById(R.id.resultTV);

    }

    public void numberClick(View view) {
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (isOperation) {
                resultTv.setText("");
            }
            resultTv.append(text);
            isOperation = false;
        }
    }

    public void operationClick(View view) {
        int id = view.getId();
        if (id == R.id.clearBtn) {
            resultTv.setText("");

        } else if (id == R.id.plusBtn || id == R.id.minusBtn || id == R.id.divideBtn
                || id == R.id.multiplyBtn) {
            firstNumber = Integer.valueOf(resultTv.getText().toString());
            isOperation = true;
            operation = ((MaterialButton) view).getText().toString();
        } else if (id == R.id.equalBtn) {
            if (firstNumber != null && operation != null) {
                secondNumber = Integer.valueOf(resultTv.getText().toString());
                Integer resultOfValues = 0;
                switch (operation) {
                    case "+":
                        resultOfValues = firstNumber + secondNumber;
                        break;
                    case "-":
                        resultOfValues = firstNumber - secondNumber;
                        break;
                    case "*":
                        resultOfValues = firstNumber * secondNumber;
                        break;
                    case "/":
                        if (secondNumber == 0) {
                            resultTv.setText("Ошибка");
                            return;
                        } else {
                            resultOfValues = firstNumber / secondNumber;
                        }

                }
                resultTv.setText(String.valueOf(resultOfValues));
                firstNumber = resultOfValues;
                isOperation = false;
            }
        }
    }
}