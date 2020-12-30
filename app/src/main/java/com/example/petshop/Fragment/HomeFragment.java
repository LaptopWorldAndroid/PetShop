package com.example.petshop.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.petshop.Adapter.CategoryAdapter;
import com.example.petshop.Adapter.ProductInCategoryAdapter;
import com.example.petshop.Class.Category;
import com.example.petshop.Class.Product;
import com.example.petshop.R;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;


public class HomeFragment extends Fragment implements CategoryAdapter.ItemClickListener {
    private View viewRoot;
    private RecyclerView homeCategoryRcv;
    private ArrayList<Category> listCategory = new ArrayList<>();
    private Category category;
    private CategoryAdapter adapter = null;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_home, container, false);

        Init();
        return viewRoot;
    }

    public void getDataCategory() {
        db = FirebaseFirestore.getInstance();
        db.collection("category")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            Log.w("Fail", "Listen failed.", e);
                            return;
                        }
                        for (QueryDocumentSnapshot doc : value) {
                            listCategory.add(new Category(doc.getId().toString(), doc.get("categoryName").toString(), doc.get("imageCategory").toString()));
                            adapter.notifyDataSetChanged();
                        }
                        Log.d("TAG", "Current cites in CA: ");
                    }
                });
    }

    private void Init() {
        homeCategoryRcv = (RecyclerView) viewRoot.findViewById(R.id.homeCategoryRcv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        getDataCategory();
        Log.d("hehe", String.valueOf(listCategory.size()));
        adapter = new CategoryAdapter(getContext(), this, listCategory);
        homeCategoryRcv.setLayoutManager(layoutManager);
        homeCategoryRcv.setAdapter(adapter);

    }

    @Override
    public void onClick(View v, Category category, String idCategory) {
        Toast.makeText(getContext(), category.getNameCategory(), Toast.LENGTH_SHORT).show();
    }


}