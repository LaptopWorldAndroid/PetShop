package com.example.petshop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.petshop.Adapter.ProductAdapter;
import com.example.petshop.Adapter.ProductDetailAdapter;
import com.example.petshop.Class.ListProduct;
import com.example.petshop.Class.Product;
import com.example.petshop.Class.ProductDetails;
import com.example.petshop.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {
    ScrollView prddetal;
    ImageView img, backdetail;
    TextView txtName, txtPrice, txtsoluong, txtmota;
    Button btnAddCart;
    ImageView cart;
    ProductDetailAdapter productDetailAdapter;
    Product product = new Product ();
    private Object Tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_product_detail);

        getIntent ();
        linkViews ();
        initFakeData ();
        addEvents ();
        getDataIntent ();
    }

    private void getDataIntent() {
        Bundle bundle = getIntent ().getExtras ();
        product = (Product) bundle.getSerializable ("Object");

        Picasso.get ().load (product.getImgUrl ()).into (img);
        Log.d ("DATA", String.valueOf (product));
        txtName.setText (String.valueOf (product.getNameProduct ()));
        txtPrice.setText (String.valueOf (product.getUnitPrice ()));
        txtmota.setText (String.valueOf (product.getDescription ()));
        txtsoluong.setText ("      Số lượng: " + String.valueOf (product.getStock ()));
    }

    private void product(Object tag, String s) {
    }

    public void linkViews() {
        img = findViewById (R.id.bigImg);
        txtName = findViewById (R.id.productname);
        txtPrice = findViewById (R.id.productprice);
        txtsoluong = findViewById (R.id.txtsoluong);
        btnAddCart = findViewById (R.id.btnAddCart);
        backdetail = findViewById (R.id.backdetail);
        txtmota = findViewById (R.id.txtmota);
        cart = findViewById (R.id.cart);
    }

    private void addEvents() {
        backdetail.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (backdetail.getBaseline () == View.VISIBLE) {
                    backdetail.setVisibility (View.INVISIBLE); //or GONE

                } else {
                    finish ();
                }
            }
        });
    }
    private void initFakeData() {

    }
}