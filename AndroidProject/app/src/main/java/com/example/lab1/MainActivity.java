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
    Boolean isNew=true;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private Button start;
    private Button del;
    private Button enter;
    private TextView result1;
    private TextView result2;
    private TextView result3;
    private TextView result4;
    private TextView result5;
    private String secretCode;
    private int attempts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.try1);
        editText2 = findViewById(R.id.try2);
        editText3 = findViewById(R.id.try3);
        editText4 = findViewById(R.id.try4);
        editText5 = findViewById(R.id.try5);

        result1 = findViewById(R.id.result1);
        result2 = findViewById(R.id.result2);
        result3 = findViewById(R.id.result3);
        result4 = findViewById(R.id.result4);
        result5 = findViewById(R.id.result5);
        del = findViewById(R.id.del);
        start = findViewById(R.id.start);
        enter = findViewById(R.id.enter);

       start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast myToast = Toast.makeText(view.getContext(), "PLease start!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        secretCode = generateSecretCode();
        attempts = 0;

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dataToCalculate = editText1.getText().toString();

                dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);

                editText1.setText(dataToCalculate);

            }
        });

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = editText1.getText().toString();
                attempts++;

                if(guess.length() != CODE_LENGTH){
                    Toast.makeText(MainActivity.this, "doljna bit " + CODE_LENGTH + " digit", Toast.LENGTH_SHORT).show();
                    return;
                }

                int bulls = 0;
                int cows = 0;
                for (int i = 0; i < CODE_LENGTH; i++){
                    char guessDigit = guess.charAt(i);
                    char secretDigit = secretCode.charAt(i);

                    if(guessDigit == secretDigit){
                        bulls++;
                    } else if (secretCode.contains(String.valueOf(guessDigit))) {
                        cows++;
                    }
                }

                result1.setText("Bulls: " + bulls + "\nCows: " + cows);

                if(bulls == CODE_LENGTH){
                    Toast.makeText(MainActivity.this, "Congrats, you guessed '" + secretCode + "' for " + attempts + "guesses", Toast.LENGTH_LONG).show();
                    enter.setEnabled(false);
                }
            }
        });
    }
    private String generateSecretCode(){
        StringBuilder codeBuilder = new StringBuilder();
        for(int i = 0; i < CODE_LENGTH; i++){
            int digit = (int) (Math.random() * 10);
            codeBuilder.append(digit);
        }
        return codeBuilder.toString();
    }

    public void clickNumber(View view) {
        if(isNew)
            editText1.setText("");
        isNew=false;
        String number1 = editText1.getText().toString();
        if (view.getId()==R.id.zero) { number1 = number1+"0";
        }
        else if (view.getId()==R.id.one) { number1 = number1+"1";
        }
        else if (view.getId()==R.id.two) { number1 = number1+"2";
        }
        else if (view.getId()==R.id.three) { number1 = number1+"3";
        }
        else if (view.getId()==R.id.four) { number1 = number1+"4";
        }
        else if (view.getId()==R.id.five) { number1 = number1+"5";
        }
        else if (view.getId()==R.id.six) { number1 = number1+"6";
        }
        else if (view.getId()==R.id.seven) { number1 = number1+"7";
        }
        else if (view.getId()==R.id.eight) { number1 = number1+"8";
        }
        else if (view.getId()==R.id.nine) { number1 = number1+"9";
        }

        editText1.setText(number1);

    }

}