package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Boolean isNew=true;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.vz);


    }

    public void clickNumber(View view) {
        if(isNew)
            editText.setText("");
        isNew=false;
        String number = editText.getText().toString();
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

        editText.setText(number);
    }

}