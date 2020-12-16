package com.arun.testingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.arun.testingproject.project1.MainActivity;
import com.arun.testingproject.project2.SecondActivity;
import com.arun.testingproject.project3.ThirdActivity;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    Button button, button2, button3;
    private static final String TAG = "BadMan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button: {
                //Log.d(TAG, "onClick: button1");
                startActivity(new Intent(FirstActivity.this, MainActivity.class));
                break;
            }
            case R.id.button2: {
                //Log.d(TAG, "onClick: button2");
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
                break;
            }
            case R.id.button3: {
                //Log.d(TAG, "onClick: button3");
                startActivity(new Intent(FirstActivity.this, ThirdActivity.class));
                break;
            }
        }
    }
}