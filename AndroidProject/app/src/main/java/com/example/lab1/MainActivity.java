package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Boolean isNew=true;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button start;
    private Button del;
    private Button enter;

    private TextView try1;
    private TextView try2;
    private TextView try3;
    private TextView try4;
    private TextView try5;
    private TextView result1;
    private TextView result2;
    private TextView result3;
    private TextView result4;
    private TextView result5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.vz1);
        editText2 = findViewById(R.id.vz2);
        editText3 = findViewById(R.id.vz3);
        editText4 = findViewById(R.id.vz4);

        findViewById(R.id.start).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast myToast = Toast.makeText(view.getContext(), "PLease start!", Toast.LENGTH_SHORT);
                myToast.show();
            }
        });


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

        if(isNew)
            editText2.setText("");
        isNew=false;
        String number2 = editText2.getText().toString();
        if (view.getId()==R.id.zero) { number2 = number2+"0";
        }
        else if (view.getId()==R.id.one) { number2 = number2+"1";
        }
        else if (view.getId()==R.id.two) { number2 = number2+"2";
        }
        else if (view.getId()==R.id.three) { number2 = number2+"3";
        }
        else if (view.getId()==R.id.four) { number2 = number2+"4";
        }
        else if (view.getId()==R.id.five) { number2 = number2+"5";
        }
        else if (view.getId()==R.id.six) { number2 = number2+"6";
        }
        else if (view.getId()==R.id.seven) { number2 = number2+"7";
        }
        else if (view.getId()==R.id.eight) { number2 = number2+"8";
        }
        else if (view.getId()==R.id.nine) { number2 = number2+"9";
        }

        editText2.setText(number2);

        if(isNew)
            editText3.setText("");
        isNew=false;
        String number3 = editText3.getText().toString();
        if (view.getId()==R.id.zero) { number3 = number3+"0";
        }
        else if (view.getId()==R.id.one) { number3 = number3+"1";
        }
        else if (view.getId()==R.id.two) { number3 = number3+"2";
        }
        else if (view.getId()==R.id.three) { number3 = number3+"3";
        }
        else if (view.getId()==R.id.four) { number3 = number3+"4";
        }
        else if (view.getId()==R.id.five) { number3 = number3+"5";
        }
        else if (view.getId()==R.id.six) { number3 = number3+"6";
        }
        else if (view.getId()==R.id.seven) { number3 = number3+"7";
        }
        else if (view.getId()==R.id.eight) { number3 = number3+"8";
        }
        else if (view.getId()==R.id.nine) { number3 = number3+"9";
        }

        editText3.setText(number3);

        if(isNew)
            editText4.setText("");
        isNew=false;
        String number = editText4.getText().toString();
        if (view.getId()==R.id.zero) { number = number+"0";
        }
        else if (view.getId()==R.id.one) { number = number+"1";
        }
        else if (view.getId()==R.id.two) { number = number+"2";
        }
        else if (view.getId()==R.id.three) { number = number+"3";
        }
        else if (view.getId()==R.id.four) { number = number+"4";
        }
        else if (view.getId()==R.id.five) { number = number+"5";
        }
        else if (view.getId()==R.id.six) { number = number+"6";
        }
        else if (view.getId()==R.id.seven) { number = number+"7";
        }
        else if (view.getId()==R.id.eight) { number = number+"8";
        }
        else if (view.getId()==R.id.nine) { number = number+"9";
        }

        editText4.setText(number);

    }

}