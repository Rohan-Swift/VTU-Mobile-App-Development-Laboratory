package com.example.speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech tts;
    EditText text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.input);
        tts= new TextToSpeech(getApplicationContext(), new
                TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status!=TextToSpeech.ERROR)
                        {
                            tts.setLanguage(Locale.UK);
                        }
                    }
                });
    }

    public void convert(View view){
        String tospeak = text.getText().toString();
        tts.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
    }
}
