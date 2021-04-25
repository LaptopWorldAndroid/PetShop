package com.example.petshop.Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.petshop.Adapter.CartItemsAdapter;
import com.example.petshop.Adapter.DealHistoryAdapter;
import com.example.petshop.Adapter.OrderAdapter;
import com.example.petshop.Class.DealHistory;
import com.example.petshop.Class.Product;
import com.example.petshop.R;

import java.util.ArrayList;

public class DealHistoryActivity extends AppCompatActivity  {

   RecyclerView rcvDealHistory;
   ImageButton btnClose;
    ArrayList<DealHistory> arrayDealHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal_history);
        btnClose = findViewById(R.id.btnCloseHistory);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rcvDealHistory = (RecyclerView) findViewById(R.id.rcvDealHistory);
        rcvDealHistory.setLayoutManager(new LinearLayoutManager(this));

        arrayDealHistory = new ArrayList<>();

        DealHistoryAdapter adapter = new DealHistoryAdapter(
                DealHistoryActivity.this,
                arrayDealHistory
        );
        rcvDealHistory.setAdapter(adapter);
    }



}