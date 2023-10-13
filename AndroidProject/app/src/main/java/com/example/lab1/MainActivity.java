package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final int CODE_LENGTH = 4;
    private int numberOfRetry = 0;
    Boolean isNew = true;
    TextView[] textViewElements = new TextView[5];
    TextView[] textViewResults = new TextView[5];
    private Button start;
    private boolean onGame = true;
    private Button del;
    private Button enter;
    private String resultOfDigits = "";
    private String secretCode;
    private TextView result;
    private int attempts;

    public MainActivity() {
        secretCode = generateSecretCode();
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
        result = findViewById(R.id.result9);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOfRetry == 0) {
                    Toast myToast = Toast.makeText(view.getContext(), "Введите четырёхзначное число без повторений", Toast.LENGTH_SHORT);
                    myToast.show();
                }
            }
        });//починить (ну... или убрать)

        attempts = 0;

       del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String currentText = textViewElements[numberOfRetry].getText().toString();
                currentText = currentText.substring(0, currentText.length() - 1);
                resultOfDigits = resultOfDigits.substring(0, resultOfDigits.length() - 1);
                textViewElements[numberOfRetry].setText(currentText);
            }

        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(secretCode);
                String guess = textViewElements[numberOfRetry].getText().toString();
                result.setText("");

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
                }

                textViewResults[numberOfRetry].setText("Bulls: " + bulls + "\nCows: " + cows);

                if (bulls == CODE_LENGTH) {
                    onGame = false;
                    result.setText("Congratulations, you guessed '" + Arrays.toString(secretCode.toCharArray()));
                    enter.setEnabled(false);
                }
                else if (numberOfRetry == 4) {
                    result.setText("You lose:(" + Arrays.toString(secretCode.toCharArray()));
                    enter.setEnabled(false);
                }
                numberOfRetry++;
                isNew = true;
                resultOfDigits = "";
            }
        });
    }

    private String generateSecretCode() {
        int counter = 1;
        int tempDigit;
        List<Integer> currentDigitsOfNumber = new ArrayList<>();
        int digit = (int)(Math.random() * 9 + 1);
        currentDigitsOfNumber.add(digit);
        String randomDigit = "";
        while (counter != 4) {
            tempDigit = (int)(Math.random() * 10);
            if (!currentDigitsOfNumber.contains(tempDigit))
            {
                currentDigitsOfNumber.add(tempDigit);
                counter++;
            }
        }
        for (int i: currentDigitsOfNumber)
            randomDigit += Integer.toString(i);
        return randomDigit;
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
        if (resultOfDigits.length() <= 3 && onGame)
        {
            if (isNew)
                setEmptyString(textViewElements[numberOfRetry], isNew);
            String tempDigit = defineNumber(view);
            if (!resultOfDigits.contains(tempDigit))
                resultOfDigits += defineNumber(view);
            textViewElements[numberOfRetry].setText(resultOfDigits);
        }
    }
}