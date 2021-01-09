package com.example.petshop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petshop.Adapter.CartItemsAdapter;
import com.example.petshop.Class.Product;
import com.example.petshop.R;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCartActivity extends AppCompatActivity implements CartItemsAdapter.ItemClickListener  {

    private ArrayList<Product> products;
    private RecyclerView rcvCartItems;
    private CartItemsAdapter cartItemsAdapter;
    private EditText cartItemCounter;
    private TextView totalMoney;
    private Button btnSubmitOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        rcvCartItems = findViewById(R.id.rcvCartItems);
        products = new ArrayList<>();
        createProductList();
        Log.d("CART", String.valueOf(products.size()));
        cartItemsAdapter = new CartItemsAdapter(this, products, this);
        rcvCartItems.setLayoutManager(new LinearLayoutManager(this));
        rcvCartItems.setAdapter(cartItemsAdapter);

        linkViews();
        addEvents();
    }

    private void addEvents() {
        btnSubmitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCartActivity.this, OrderActivity.class);

                String total = totalMoney.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putSerializable("cartItems", products);
                bundle.putSerializable("totalMoney", total);

                intent.putExtra("BUNDLE", bundle);

                startActivity(intent);
            }
        });
    }

    private void linkViews() {
        totalMoney = findViewById(R.id.totalMoney);
        btnSubmitOrder = findViewById(R.id.btnSubmitOrder);
    }

    private void createProductList() {
        products.add(new Product(
                "prd1",
                "Thức ăn cho chó 1",
                "description...",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPCUUjJ9AMuVvtDLPo3EY3J_C6Dgf9ixS7riY_BgEB4R67BuBOaljbb3HnJw&usqp=CAc",
                123,
                123456,
                "1"));
        products.add(new Product(
                "prd2",
                "Thức ăn cho chó 2",
                "description...",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPCUUjJ9AMuVvtDLPo3EY3J_C6Dgf9ixS7riY_BgEB4R67BuBOaljbb3HnJw&usqp=CAc",
                123,
                123456,
                "4"));
        products.add(new Product(
                "prd2",
                "Thức ăn cho chó 2",
                "description...",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQPCUUjJ9AMuVvtDLPo3EY3J_C6Dgf9ixS7riY_BgEB4R67BuBOaljbb3HnJw&usqp=CAc",
                123,
                123456,
                "3"
                ));
    }

    public void calcTotalMoney(){
        double total = 0;

        for (Product p: products) {
            total += p.getUnitPrice() * Integer.valueOf(p.getCount());
        }

        totalMoney.setText(String.valueOf(total + " d"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        calcTotalMoney();
    }

    @Override
    public void onClickIncrease(View view, int position) {
        Product p = products.get(position);
        Integer count=Integer.parseInt(p.getCount());
        p.setCount(String.valueOf(count+1));
        cartItemsAdapter.notifyDataSetChanged();
        calcTotalMoney();
        //Toast.makeText(this, p.getCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickDecrease(View view, int position) {
        Product p = products.get(position);
        Integer count=Integer.parseInt(p.getCount());
        p.setCount(String.valueOf(count-1));
        cartItemsAdapter.notifyDataSetChanged();
        calcTotalMoney();
        //Toast.makeText(this, p.getCount(), Toast.LENGTH_SHORT).show();
    }
}