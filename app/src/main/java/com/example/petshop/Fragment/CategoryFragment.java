package com.example.petshop.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.petshop.Adapter.CategoryAdapter;
import com.example.petshop.Class.Category;
import com.example.petshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

public class CategoryFragment extends Fragment implements CategoryAdapter.ItemClickListener{
    private View viewRoot;
    private LinearLayout layoutCategory;
    private RecyclerView rvcCategory;
    private ArrayList<Category> listCategory = new ArrayList<>();
    private Category category;
    private CategoryAdapter adapter = null;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_category, container, false);

        Init();
        return viewRoot;
    }

    public void getData() {
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
        rvcCategory = (RecyclerView) viewRoot.findViewById(R.id.rcwCategory);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        getData();
        adapter = new CategoryAdapter(getContext(), this,listCategory);
        rvcCategory.setLayoutManager(layoutManager);
        rvcCategory.setAdapter(adapter);

    }

    @Override
    public void onClick(View v, Category category) {
        Toast.makeText(getContext(), category.getNameCategory(), Toast.LENGTH_SHORT).show();
    }
}