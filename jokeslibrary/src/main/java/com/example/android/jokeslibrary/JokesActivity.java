package com.example.android.jokeslibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokesActivity extends AppCompatActivity {

    private static final String JOKE_INTENT = "joke_intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        TextView textView = (TextView) findViewById(R.id.jokes_tv);
        String currentJoke = getIntent().getStringExtra(JOKE_INTENT);
        textView.setText(currentJoke);
    }
}
