package csmp.part_a.p3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.signup.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button loginbut;
    EditText loginname, loginpass;
    int attempts;
    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        attempts=0;
        loginname=(EditText)findViewById(R.id.loname);
        loginpass=(EditText)findViewById(R.id.lopass);

        loginbut=(Button)findViewById(R.id.subtn);

        getValueFromUserBundle();

        loginbut.setOnClickListener(this);
    }

    private void getValueFromUserBundle() {
        username = getIntent().getExtras().getString(Constants.USERNAME_KEY);
        password = getIntent().getExtras().getString(Constants.PASSWORD_KEY);
    }

    @Override
    public void onClick(View view) {
        attempts++;
        if (attempts > 2) {
            makeToast("Failed Login Attempts");
            loginbut.setEnabled(false);
        } else {
            String usernameLocal, passwordLocal;
            usernameLocal = loginname.getText().toString();
            passwordLocal = loginpass.getText().toString();

            if (usernameLocal.equals(username) && passwordLocal.equals(password))
                makeToast("Successful Login");
            else makeToast("Login Failed");
        }
    }

    public void makeToast(String toastMessage) {
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }
}

