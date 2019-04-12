package com.muhajirlatif.tekber.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private Button btnSort;
    private Integer statusSort;

    private DatabaseReference databaseReference;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);

//        itemList = new ArrayList<>();
//        generateItemList();
//
//        recyclerView = findViewById(R.id.rvStanding);
//
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//
//        standingsAdapter = new StandingsAdapter(getApplicationContext(), itemList);
//        recyclerView.setAdapter(standingsAdapter);
//
//        btnSort = findViewById(R.id.btnSort);
//        btnSort.setOnClickListener(this);
//        statusSort = -1;

        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();
//        String uid = databaseReference.push().getKey();
//        StandingsRow item = new StandingsRow(2, "https://cdn.countryflags.com/thumbs/japan/flag-400.png", "Japan", 75, 56, 74);
//        databaseReference.child(uid).setValue(item);

        databaseReference.addValueEventListener()
    }

    public void generateItemList() {
        itemList.add(new StandingsRow(1, "https://cdn.countryflags.com/thumbs/china/flag-400.png", "China", 132, 92, 65));
        itemList.add(new StandingsRow(2, "https://cdn.countryflags.com/thumbs/japan/flag-400.png", "Japan", 75, 56, 74));
        itemList.add(new StandingsRow(3, "https://cdn.countryflags.com/thumbs/south-korea/flag-400.png", "South Korea", 49, 58, 43));
        itemList.add(new StandingsRow(4, "https://cdn.countryflags.com/thumbs/indonesia/flag-400.png", "Indonesia", 31, 24, 25));
        itemList.add(new StandingsRow(5, "https://cdn.countryflags.com/thumbs/uzbekistan/flag-400.png", "Uzbekistan", 21, 24, 22));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.btnSort:
//                statusSort *= -1;
//                Collections.sort(itemList, new Comparator<StandingsRow>() {
//                    @Override
//                    public int compare(StandingsRow o1, StandingsRow o2) {
//                        return statusSort * Integer.compare(o1.getGold(), o2.getGold());
//                    }
//                });
//
//                standingsAdapter.setItemList(itemList);
//                standingsAdapter.notifyDataSetChanged();
        }
    }
}
