package com.muhajirlatif.tekber.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.muhajirlatif.tekber.Model.StandingsRow;
import com.muhajirlatif.tekber.R;

public class FirebaseAddActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etRank, etCountry, etGold, etSilver, etBronze, etFlag;
    private Button btnSubmit;

    private DatabaseReference databaseReference;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_add);

        etRank = findViewById(R.id.etRank);
        etCountry = findViewById(R.id.etCountry);
        etGold = findViewById(R.id.etGold);
        etSilver = findViewById(R.id.etSilver);
        etBronze = findViewById(R.id.etBronze);
        etFlag = findViewById(R.id.etFlag);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit:
                Integer rank = Integer.parseInt(etRank.getText().toString());
                String country = etCountry.getText().toString();
                Integer gold = Integer.parseInt(etGold.getText().toString());
                Integer silver = Integer.parseInt(etSilver.getText().toString());
                Integer bronze = Integer.parseInt(etBronze.getText().toString());
                String flag = etFlag.getText().toString();

                String uid = databaseReference.push().getKey();
                StandingsRow item = new StandingsRow(rank, flag, country, gold, silver, bronze);
                databaseReference.child(uid).setValue(item);

                finish();
                break;
        }
    }
}
