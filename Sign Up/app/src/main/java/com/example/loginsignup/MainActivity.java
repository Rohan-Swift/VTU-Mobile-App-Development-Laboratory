package com.example.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText sunametxt, supasstxt;
    Button subtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sunametxt=findViewById(R.id.suname);
        supasstxt=findViewById(R.id.supass);
        subtn=findViewById(R.id.subut);

        subtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname=sunametxt.getText().toString();
                String pwd= supasstxt.getText().toString();

                if(!pwdval(pwd))
                {
                    Toast.makeText(MainActivity.this, "Password Does not match the rules", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.putExtra("email", uname);
                intent.putExtra("password", pwd);
                startActivity(intent);
            }
        });
    }
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacter = Pattern.compile("^.*[^a-zA-Z0-9].*$");

    private Boolean pwdval(String password) {
        if (password.length() < 8) {
            return false;
        }
        if (!lowercase.matcher(password).matches()) {
            return false;
        }
        if (!uppercase.matcher(password).matches()) {
            return false;
        }
        if (!number.matcher(password).matches()) {
            return false;
        }
        if (!specialCharacter.matcher(password).matches()) {
            return false;
        }
        return true;
    }
}
