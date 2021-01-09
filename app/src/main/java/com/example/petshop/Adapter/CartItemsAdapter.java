package com.example.petshop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petshop.Class.Product;
import com.example.petshop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CartItemsAdapter extends RecyclerView.Adapter<CartItemsAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Product> products;
    private ItemClickListener itemClickListener;

    public CartItemsAdapter(Context context, ArrayList<Product> products, ItemClickListener itemClickListener) {
        this.context = context;
        this.products = products;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View cartView = inflater.inflate(R.layout.cart_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(cartView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = products.get(position);
        Picasso.get().load(product.getImgUrl()).into(holder.imageCart);

        holder.cartItemName.setText(product.getNameProduct());
        holder.cartItemPrice.setText(String.valueOf(product.getUnitPrice()));
        holder.cartItemCounter.setText(String.valueOf(product.getCount()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageCart;
        private TextView cartItemName;
        private TextView cartItemPrice;
        private EditText cartItemCounter;
        private Button btnIncrease;
        private Button btnDecrease;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCart = itemView.findViewById(R.id.imageCart);
            cartItemName = itemView.findViewById(R.id.cartItemName);
            cartItemPrice = itemView.findViewById(R.id.cartItemPrice);
            cartItemCounter = itemView.findViewById(R.id.cartItemCounter);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);

            btnIncrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onClickIncrease(v, getLayoutPosition());
                }
            });
        }
    }

    public interface ItemClickListener {
        void onClickIncrease(View view, int position);
        void onClickDecrease(View view, int position);
    }
}