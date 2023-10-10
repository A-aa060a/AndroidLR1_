package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private static final int CODE_LENGTH = 4;

    private int numberOfRetry = 0;
//    private int DelNumbers = 0;
    Boolean isNew = true;
//    private int countOfDigit = 0;
    TextView[] textViewElements = new TextView[5];
    TextView[] textViewResults = new TextView[5];
//    private TextView textView1;
//    private TextView textView2;
//    private TextView textView3;
//    private TextView textView4;
//    private TextView textView5;
    private Button start;
    private Button del;
    private Button enter;
    private String resultOfDigits = "";
//    private TextView result1;
//    private TextView result2;
//    private TextView result3;
//    private TextView result4;
//    private TextView result5;
    private String secretCode;
    private int attempts;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewElements[0] = findViewById(R.id.try1);
        textViewElements[1] = findViewById(R.id.try2);
        textViewElements[2] = findViewById(R.id.try3);
        textViewElements[3] = findViewById(R.id.try4);
        textViewElements[4] = findViewById(R.id.try5);


        textViewResults[0] = findViewById(R.id.result1);
        textViewResults[1] = findViewById(R.id.result2);
        textViewResults[2] = findViewById(R.id.result3);
        textViewResults[3] = findViewById(R.id.result4);
        textViewResults[4] = findViewById(R.id.result5);
        del = findViewById(R.id.del);
        start = findViewById(R.id.start);
        enter = findViewById(R.id.enter);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(view.getContext(), "PLease start!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });//починить (ну... или убрать)

        secretCode = generateSecretCode();
        attempts = 0;

//        del.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String dataToCalculate = textView1.getText().toString();
//
//                dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
//
//                textView1.setText(dataToCalculate);
//
//            }
//        }); //переделать

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = textViewElements[numberOfRetry].getText().toString();

                if (guess.length() != CODE_LENGTH) {
                    Toast.makeText(MainActivity.this, "should be" + CODE_LENGTH + "digit", Toast.LENGTH_SHORT).show();
                    return;
                } //сделать только четырехзначное число без повторений!

                int bulls = 0;
                int cows = 0;
                for (int i = 0; i < CODE_LENGTH; i++) {
                    char guessDigit = guess.charAt(i);
                    char secretDigit = secretCode.charAt(i);

                    if (guessDigit == secretDigit) {
                        bulls++;
                    } else if (secretCode.contains(String.valueOf(guessDigit))) {
                        cows++;
                    }
                }//сомнения... Работает 50/50

                textViewResults[numberOfRetry].setText("Bulls: " + bulls + "\nCows: " + cows); //ура, работает

                if (bulls == CODE_LENGTH) {
                    Toast.makeText(MainActivity.this, "Congratulations, you guessed '" + secretCode + "for" + attempts + "guesses", Toast.LENGTH_LONG).show();
                    enter.setEnabled(false);
                    //Не работает(((
                }
                numberOfRetry++;
                isNew = true;
                resultOfDigits = "";
            }
        });
    }

    private String generateSecretCode() {
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int digit = (int) (Math.random() * 10);
            codeBuilder.append(digit);
        }
        return codeBuilder.toString();
    }

    public String defineNumber(View view) {
        String number = "";
        if (view.getId() == R.id.zero) {
            number += "0";
        } else if (view.getId() == R.id.one) {
            number += "1";
        } else if (view.getId() == R.id.two) {
            number += "2";
        } else if (view.getId() == R.id.three) {
            number += "3";
        } else if (view.getId() == R.id.four) {
            number += "4";
        } else if (view.getId() == R.id.five) {
            number += "5";
        } else if (view.getId() == R.id.six) {
            number += "6";
        } else if (view.getId() == R.id.seven) {
            number += "7";
        } else if (view.getId() == R.id.eight) {
            number += "8";
        } else if (view.getId() == R.id.nine) {
            number += "9";
        }
        return number;
    }

    public void setEmptyString(TextView textView, boolean isNew) {
        if (isNew)
            textView.setText("");
        isNew = false;
    }

    public void clickNumber(View view) {
        if (isNew)
            setEmptyString(textViewElements[numberOfRetry], isNew);
        resultOfDigits += defineNumber(view);
        textViewElements[numberOfRetry].setText(resultOfDigits);
    }
// удивительно, но работает
}