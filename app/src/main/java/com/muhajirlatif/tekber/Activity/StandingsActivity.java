package com.muhajirlatif.tekber.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.muhajirlatif.tekber.Model.Medal;
import com.muhajirlatif.tekber.R;
import com.muhajirlatif.tekber.Adapter.MedalAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StandingsActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Medal> itemList;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private MedalAdapter standingsAdapter;
    private Button btnSort;
    private Integer statusSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        itemList = new ArrayList<>();
        generateItemList();

        recyclerView = findViewById(R.id.rvStanding);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        standingsAdapter = new MedalAdapter(getApplicationContext(), itemList);
        recyclerView.setAdapter(standingsAdapter);

        btnSort = findViewById(R.id.btnSort);
        btnSort.setOnClickListener(this);
        statusSort = -1;
    }

    public void generateItemList() {
        itemList.add(new Medal(1, "https://cdn.countryflags.com/thumbs/china/flag-400.png", "China", 132, 92, 65));
        itemList.add(new Medal(2, "https://cdn.countryflags.com/thumbs/japan/flag-400.png", "Japan", 75, 56, 74));
        itemList.add(new Medal(3, "https://cdn.countryflags.com/thumbs/south-korea/flag-400.png", "South Korea", 49, 58, 43));
        itemList.add(new Medal(4, "https://cdn.countryflags.com/thumbs/indonesia/flag-400.png", "Indonesia", 31, 24, 25));
        itemList.add(new Medal(5, "https://cdn.countryflags.com/thumbs/uzbekistan/flag-400.png", "Uzbekistan", 21, 24, 22));
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
        }
    }
}
