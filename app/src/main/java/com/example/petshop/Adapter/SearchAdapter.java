package com.example.petshop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshop.Class.Product;
import com.example.petshop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<Product> list;
    public SearchAdapter(ArrayList<Product> list){
        this.list=list;
        //  this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item,parent,false);
        return new MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,final int position) {
        holder.itemView.setTag(list.get(position));
        holder.itemView.findViewById(R.id.tvProductName);
        holder.itemView.findViewById(R.id.tvQuantity);
        holder.itemView.findViewById(R.id.tvPrice);
        Picasso.get().load(list.get(position).getImgUrl()).into((ImageView) holder.itemView.findViewById(R.id.imvProduct));

    }

    @Override
    public int getItemCount() {
       return list.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvProductName, tvPrice, tvQuantity;
        ImageView imgProduct;
        CardView cardView;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName=itemView.findViewById(R.id.tvProductName);
            imgProduct=itemView.findViewById(R.id.imvProduct);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvQuantity=itemView.findViewById(R.id.tvQuantity);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}
