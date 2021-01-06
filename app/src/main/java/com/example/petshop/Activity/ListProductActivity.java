package com.example.petshop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.petshop.Adapter.ProductAdapter;
import com.example.petshop.Class.ListProduct;
import com.example.petshop.Class.Product;
import com.example.petshop.R;

import java.util.ArrayList;

public class ListProductActivity extends AppCompatActivity {
    GridView grvlistProduct;
    ProductAdapter productAdapter;
    ArrayList<ListProduct> listProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_list_product);

        linkViews();
        setAdapterListView();
        initFakeData();
        addEvents();
        getIntent ();
    }

    private void initFakeData() {
        listProducts.add(new ListProduct (R.drawable.ic_bone, "1", "chocon",12500 ));
        listProducts.add(new ListProduct (R.drawable.ic_bone, "2", "cc", 11125 ));
        listProducts.add(new ListProduct (R.drawable.ic_bone, "3", "aaa", 13000));
    }

    private void addEvents() {

    }

    private void setAdapterListView() {
        listProducts = new ArrayList<ListProduct>();
        productAdapter = new ProductAdapter (ListProductActivity.this, R.layout.item_product_gridview, listProducts);
        grvlistProduct.setAdapter(productAdapter);
    }

    private void linkViews() {
        grvlistProduct = findViewById (R.id.grvlistProduct);
    }
}

