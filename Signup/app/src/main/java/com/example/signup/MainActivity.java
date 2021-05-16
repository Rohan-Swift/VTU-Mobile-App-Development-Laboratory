package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import csmp.part_a.p3.Constants;
import csmp.part_a.p3.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button signupbut;
    EditText suuname, suupass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        suuname=(EditText)findViewById(R.id.suname);
        suupass=(EditText)findViewById(R.id.supass);
        signupbut=(Button)findViewById(R.id.subut);

        signupbut.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.signupbut:
                String username, password;
                username = suuname.getText().toString();
                password = suupass.getText().toString();

                String pwdcreator = "^(?=.*[0-9])"
                        + "(?=.*[a-z])(?=.*[A-Z])"
                        + "(?=.*[@#$%^&+=])"
                        + "(?=\\S+$).{8,}$";

                if (username.isEmpty()) {
                    makeToast("Enter Username");
                }
                if (!password.matches(pwdcreator)) {
                    makeToast("Password validation failed!");
                } else {
                    Bundle userBundle = new Bundle();
                    userBundle.putString(Constants.USERNAME_KEY, username);
                    userBundle.putString(Constants.PASSWORD_KEY, password);
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.putExtras(userBundle);
                    startActivity(intent);
                }
                break;
        }
    }

    public void makeToast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}
