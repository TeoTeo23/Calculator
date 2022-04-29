package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calculator calculator = new Calculator(0, 0);

        EditText inFirst = findViewById(R.id.firstInput);
        EditText inSecond = findViewById(R.id.secondInput);
        TextView out = findViewById(R.id.output);

        Button sum = findViewById(R.id.sum);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!viewToast(inFirst, inSecond))
                    return;
                String first = inFirst.getText().toString();
                String second = inSecond.getText().toString();

                calculator.setResult(calculator.sum(Integer.parseInt(first), Integer.parseInt(second)));
                out.setText(calculator.toString());
            }
        });
        Button sub = findViewById(R.id.sub);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!viewToast(inFirst, inSecond))
                    return;
                String first = inFirst.getText().toString();
                String second = inSecond.getText().toString();

                calculator.setResult(calculator.sub(Integer.parseInt(first), Integer.parseInt(second)));
                out.setText(calculator.toString());
            }
        });
        Button mul = findViewById(R.id.mul);

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!viewToast(inFirst, inSecond))
                    return;
                String first = inFirst.getText().toString();
                String second = inSecond.getText().toString();

                calculator.setResult(calculator.mul(Integer.parseInt(first), Integer.parseInt(second)));
                out.setText(calculator.toString());
            }
        });
        Button div = findViewById(R.id.div);

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!viewToast(inFirst, inSecond))
                    return;
                String first = inFirst.getText().toString();
                String second = inSecond.getText().toString();

                try{
                    calculator.setResult(calculator.div(Integer.parseInt(first), Integer.parseInt(second)));
                }catch(DivisionException exception){
                    Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                    out.setText("ERR");
                    return;
                }
                out.setText(calculator.toString());
            }
        });
        Button pow = findViewById(R.id.pow);

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!viewToast(inFirst, inSecond))
                    return;
                String first = inFirst.getText().toString();
                String second = inSecond.getText().toString();

                calculator.setResult(calculator.elv(Integer.parseInt(first), Integer.parseInt(second)));
                out.setText(calculator.toString());
            }
        });
        Button mod = findViewById(R.id.module);

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!viewToast(inFirst, inSecond))
                    return;
                String first = inFirst.getText().toString();
                String second = inSecond.getText().toString();

                calculator.setResult((int)calculator.mod(Integer.parseInt(first), Integer.parseInt(second)));
                out.setText(calculator.toString());
            }
        });
        Button fact = findViewById(R.id.factorial);

        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inFirst.getText().toString().equals("")){
                    inFirst.setText("");
                    String second = inSecond.getText().toString();

                    try{
                        calculator.setResult(calculator.factorial(Integer.parseInt(second)));
                    }catch(FactorialException exception){
                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                if(inSecond.getText().toString().equals("")){
                    inSecond.setText("");
                    String first = inFirst.getText().toString();

                    try{
                        calculator.setResult(calculator.factorial(Integer.parseInt(first)));
                    }catch(FactorialException exception){
                        Toast.makeText(getApplicationContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                out.setText(calculator.toString());
            }
        });
    }

    public static boolean viewToast(EditText inF, EditText inS){
        if(inF.getText().toString().equals("") && inS.getText().toString().equals("")){
            Toast.makeText(inS.getContext(), "Missing both operands.\r\n", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(inF.getText().toString().equals("")){
            Toast.makeText(inF.getContext(), "Missing first operand.\r\n", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(inS.getText().toString().equals("")){
            Toast.makeText(inF.getContext(), "Missing second operand.\r\n", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}