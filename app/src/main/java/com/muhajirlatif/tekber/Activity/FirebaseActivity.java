package com.muhajirlatif.tekber.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muhajirlatif.tekber.Adapter.StandingsAdapter;
import com.muhajirlatif.tekber.Model.StandingsRow;
import com.muhajirlatif.tekber.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FirebaseActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<StandingsRow> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private StandingsAdapter standingsAdapter;
    private Button btnSort, btnAdd;
    private Integer statusSort;

    private DatabaseReference databaseReference;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

        itemList = new ArrayList<>();
        recyclerView = findViewById(R.id.rvStanding);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        standingsAdapter = new StandingsAdapter(getApplicationContext(), itemList);
        recyclerView.setAdapter(standingsAdapter);

        btnSort = findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);
        statusSort = -1;

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
//        String uid = databaseReference.push().getKey();
//        StandingsRow item = new StandingsRow(2, "https://cdn.countryflags.com/thumbs/japan/flag-400.png", "Japan", 75, 56, 74);
//        databaseReference.child(uid).setValue(item);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    itemList = new ArrayList<>();
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                        StandingsRow row = snapshot.getValue(StandingsRow.class);
                        itemList.add(row);
                    }

                    standingsAdapter.setItemList(itemList);
                    standingsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("FirebaseActivity: ", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSort:
                statusSort *= -1;
                Collections.sort(itemList, new Comparator<StandingsRow>() {
                    @Override
                    public int compare(StandingsRow o1, StandingsRow o2) {
                        return statusSort * Integer.compare(o1.getGold(), o2.getGold());
                    }
                });

                standingsAdapter.setItemList(itemList);
                standingsAdapter.notifyDataSetChanged();
                break;

            case R.id.btnAdd:
                startActivity(new Intent(FirebaseActivity.this, FirebaseAddActivity.class));
                break;
        }
    }
}
