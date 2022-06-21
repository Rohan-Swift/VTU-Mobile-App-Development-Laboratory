package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText lonametxt, lopasstxt;
    Button lobtn;
    int i=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lonametxt=findViewById(R.id.loname);
        lopasstxt=findViewById(R.id.lopass);
        lobtn=findViewById(R.id.lobut);

        String regUname=getIntent().getStringExtra("uname");
        String regPass=getIntent().getStringExtra("pwd");

        lobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=lonametxt.getText().toString();
                String upass=lopasstxt.getText().toString();

                if (regUname.equals(uname) && regPass.equals(upass))
                {
                    Intent intent=new Intent(LoginActivity.this,LoginSuccess.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Invalid Credentials",Toast.LENGTH_LONG).show();
                }
                i--;
                if(i==0)
                {
                    Toast.makeText(getBaseContext(),"FAILED LOGIN ATTEMPTS",Toast.LENGTH_LONG).show();
                    lobtn.setEnabled(false);
                }
            }
        });
    }
}
