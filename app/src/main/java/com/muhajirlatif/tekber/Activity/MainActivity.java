package com.muhajirlatif.tekber.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.muhajirlatif.tekber.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button btnStandings, btnFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        btnStandings = findViewById(R.id.btnStandings);
        btnStandings.setOnClickListener(this);

        btnFirebase = findViewById(R.id.btnFirebase);
        btnFirebase.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(MainActivity.this, CalculatorActivity.class));
                break;

            case R.id.btnStandings:
                startActivity(new Intent(MainActivity.this, StandingsActivity.class));
                break;

            case R.id.btnFirebase:
                startActivity(new Intent(MainActivity.this, FirebaseActivity.class));
                break;
        }
    }
}
