package com.muhajirlatif.tekber.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.muhajirlatif.tekber.Model.StandingsRow;
import com.muhajirlatif.tekber.R;

import java.util.ArrayList;

public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.ViewHolder> {

    private ArrayList<StandingsRow> itemList;
    private Context context;

    public StandingsAdapter(Context context, ArrayList<StandingsRow> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public StandingsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_table_row, viewGroup, false);

        return new ViewHolder(view);
    }

    public void setItemList(ArrayList<StandingsRow> itemList) {
        this.itemList = itemList;
    }

    @Override
    public void onBindViewHolder(@NonNull StandingsAdapter.ViewHolder viewHolder, int i) {
        StandingsRow item = itemList.get(i);

        viewHolder.tvRank.setText(String.valueOf(item.getRank()));
        viewHolder.tvCountry.setText(item.getCountry());
        viewHolder.tvGold.setText(String.valueOf(item.getGold()));
        viewHolder.tvSilver.setText(String.valueOf(item.getSilver()));
        viewHolder.tvBronze.setText(String.valueOf(item.getBronze()));
        viewHolder.tvTotal.setText(String.valueOf(item.getTotal()));
        Glide.with(context).load(item.getFlagLink()).into(viewHolder.ivFlag);
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvRank, tvCountry, tvGold, tvSilver, tvBronze, tvTotal;
        public ImageView ivFlag;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRank = itemView.findViewById(R.id.tvRank);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvGold = itemView.findViewById(R.id.tvGold);
            tvSilver = itemView.findViewById(R.id.tvSilver);
            tvBronze = itemView.findViewById(R.id.tvBronze);
            tvTotal = itemView.findViewById(R.id.tvTotal);
            ivFlag = itemView.findViewById(R.id.ivFlag);
        }
    }
}
