package com.example.petshop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.petshop.Adapter.NavigationAdapter;
import com.example.petshop.Adapter.SearchAdapter;
import com.example.petshop.Class.Product;
import com.example.petshop.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;

public class HomeActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private ArrayList<String> listProductName = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hone);

        autoCompleteTextView = findViewById(R.id.searchBox);
        getData();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listProductName);
        autoCompleteTextView.setAdapter(adapter);

        ViewPager2 viewPager2 = findViewById(R.id.viewPager);
        viewPager2.setAdapter(new NavigationAdapter(this));

        TabLayout tabLayout = findViewById(R.id.tabLayout);


        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: {
                        tab.setText("Trang chủ");
                        tab.setIcon(R.drawable.ic_baseline_home_24);

//                        BadgeDrawable badgeDrawable = tab.getOrCreateBadge();
//                        badgeDrawable.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
//                        badgeDrawable.setVisible(true);

                        break;
                    }
                    case 1: {
                        tab.setText("Danh mục");
                        tab.setIcon(R.drawable.ic_baseline_category_24);

                        break;
                    }
                    case 2: {
                        tab.setText("Tìm kiếm");
                        tab.setIcon(R.drawable.ic_baseline_search_24);
                        break;
                    }
                    case 3: {
                        tab.setText("Tài khoản");
                        tab.setIcon(R.drawable.ic_baseline_account_circle_24);
                        break;
                    }
                }

            }

        }
        );
        tabLayoutMediator.attach();

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomeActivity.this,
                        adapter.getItem(position),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getData() {
        db = FirebaseFirestore.getInstance();
        db.collection("product")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w("Fail", "Listen failed.", e);
                            return;
                        }
                        listProductName.clear();
                        for (QueryDocumentSnapshot doc : value) {

                            listProductName.add(new String(
                                    doc.get("name").toString()
                            ));
                            adapter.notifyDataSetChanged();
                        }
                    }
                });
    }
}