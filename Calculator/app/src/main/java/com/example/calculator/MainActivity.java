package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnadd, btnsub, btnmul, btndiv, btndec, btneql, btnclr;

    EditText input;
    TextView output;

    float val1, val2;

    boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn0=(Button)findViewById(R.id.num0);
        btn1=(Button)findViewById(R.id.num1);
        btn2=(Button)findViewById(R.id.num2);
        btn3=(Button)findViewById(R.id.num3);
        btn4=(Button)findViewById(R.id.num4);
        btn5=(Button)findViewById(R.id.num5);
        btn6=(Button)findViewById(R.id.num6);
        btn7=(Button)findViewById(R.id.num7);
        btn8=(Button)findViewById(R.id.num8);
        btn9=(Button)findViewById(R.id.num9);

        btndec=(Button)findViewById(R.id.dec);
        btnadd=(Button)findViewById(R.id.add);
        btnsub=(Button)findViewById(R.id.sub);
        btnmul=(Button)findViewById(R.id.mul);
        btndiv=(Button)findViewById(R.id.div);
        btneql=(Button)findViewById(R.id.eql);
        btnclr=(Button)findViewById(R.id.clr);

        input=(EditText)findViewById(R.id.inp);
        output=(TextView)findViewById(R.id.res);




        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"0");
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"3");

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"9");
            }
        });


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input==null)
                {
                    input.setText("");
                }
                else
                {
                    val1=Float.parseFloat(input.getText()+"");
                    add=true;
                    input.setText(null);
                }
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(input.getText()+"");
                sub=true;
                input.setText(null);
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(input.getText()+"");
                mul=true;
                input.setText(null);
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1=Float.parseFloat(input.getText()+"");
                div=true;
                input.setText(null);
            }
        });


        btneql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val2=Float.parseFloat(input.getText()+"");

                if(add)
                {
                    output.setText(val1+val2 +"");
                    add=false;
                }

                if(sub)
                {
                    output.setText(val1-val2+"");
                    sub=false;
                }

                if(mul)
                {
                    output.setText(val1*val2+"");;
                    mul=false;
                }

                if(div)
                {
                    output.setText(val1/val2+"");
                    div=false;
                }
            }
        });


        btnclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });

        btndec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+".");
            }
        });
    }
}