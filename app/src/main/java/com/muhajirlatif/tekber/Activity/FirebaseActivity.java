package com.muhajirlatif.tekber.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muhajirlatif.tekber.Adapter.MedalAdapter;
import com.muhajirlatif.tekber.Model.Medal;
import com.muhajirlatif.tekber.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FirebaseActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Medal> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MedalAdapter standingsAdapter;
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

        standingsAdapter = new MedalAdapter(getApplicationContext(), itemList);
        recyclerView.setAdapter(standingsAdapter);

        btnSort = findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);
        statusSort = -1;

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
//        String uid = databaseReference.push().getKey();
//        Medal item = new Medal(2, "https://cdn.countryflags.com/thumbs/japan/flag-400.png", "Japan", 75, 56, 74);
//        databaseReference.child(uid).setValue(item);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    itemList = new ArrayList<>();
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                        Medal row = snapshot.getValue(Medal.class);
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
                Collections.sort(itemList, new Comparator<Medal>() {
                    @Override
                    public int compare(Medal o1, Medal o2) {
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
