package com.example.petshop.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshop.Class.DealHistory;
import com.example.petshop.R;

import java.util.ArrayList;
import java.util.List;

public class DealHistoryAdapter extends RecyclerView.Adapter<DealHistoryAdapter.ViewHolder> {

    Context myContext;

    ArrayList<DealHistory> arrayList;

    public DealHistoryAdapter(Context context, ArrayList<DealHistory> dealHistoryList) {
        this.myContext = context;
        this.arrayList = dealHistoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(myContext);
        View dealView = inflater.inflate(R.layout.deal_history, parent, false);
        DealHistoryAdapter.ViewHolder viewHolder = new ViewHolder(dealView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DealHistory dealhistory = arrayList.get(position);

        holder.textViewName.setText(dealhistory.getName());
        holder.textViewAmount.setText(dealhistory.getAmount());
        holder.textViewPrice.setText((int) dealhistory.gerPrice());
        holder.textViewTotalMoney.setText((int) dealhistory.getTotalMoney());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewAmount;
        public TextView textViewPrice;
        public TextView textViewTotalMoney;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewTotalMoney = itemView.findViewById(R.id.textViewTotalMoney);

        }
    }
}
