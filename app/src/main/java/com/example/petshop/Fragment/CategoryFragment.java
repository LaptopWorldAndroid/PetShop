package com.example.petshop.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.petshop.Adapter.CategoryAdapter;
import com.example.petshop.Class.Category;
import com.example.petshop.R;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    private View viewRoot;
    private LinearLayout layoutCategory;
    private RecyclerView rvcCategory;
    private ArrayList<Category> listCategory;
    private CategoryAdapter adapter = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewRoot = inflater.inflate(R.layout.fragment_category, container, false);
        Init();
        return viewRoot;
    }

//    private void categoryListdATA() {
//        listCategory.add(new Category("1", "Thor", "R.drawable.image_thor"));
//        listCategory.add(new Category("2", "IronMan", "R.drawable.image_ironman"));
//        listCategory.add(new Category("4", "SpiderMan", "R.drawable.image_spiderman"));
//        listCategory.add(new Category("5", "Thor", "R.drawable.image_thor"));
//        listCategory.add(new Category("6", "IronMan", "R.drawable.image_ironman"));
//        listCategory.add(new Category("7", "Hulk", "R.drawable.image_hulk"));
//        listCategory.add(new Category("8", "SpiderMan", "R.drawable.image_spiderman"));
//        listCategory.add(new Category("9", "Thor", "R.drawable.image_thor"));
//        listCategory.add(new Category("10", "IronMan", "R.drawable.image_ironman"));
//    }

    private void Init() {
        rvcCategory = (RecyclerView) viewRoot.findViewById(R.id.rcwCategory);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        listCategory = new ArrayList<>();
        listCategory.add(new Category("1", "Thor", "R.drawable.image_thor"));
        listCategory.add(new Category("2", "IronMan", "R.drawable.image_ironman"));
        listCategory.add(new Category("4", "SpiderMan", "R.drawable.image_spiderman"));
        listCategory.add(new Category("5", "Thor", "R.drawable.image_thor"));
        listCategory.add(new Category("6", "IronMan", "R.drawable.image_ironman"));
        listCategory.add(new Category("7", "Hulk", "R.drawable.image_hulk"));
        listCategory.add(new Category("8", "SpiderMan", "R.drawable.image_spiderman"));
        listCategory.add(new Category("9", "Thor", "R.drawable.image_thor"));
        listCategory.add(new Category("10", "IronMan", "R.drawable.image_ironman"));
        listCategory.add(new Category("644", "IronMan", "R.drawable.image_ironman"));
        listCategory.add(new Category("722", "Hulk", "R.drawable.image_hulk"));
        listCategory.add(new Category("833", "SpiderMan", "R.drawable.image_spiderman"));
        listCategory.add(new Category("94", "Thor", "R.drawable.image_thor"));
        listCategory.add(new Category("110", "IronMan", "R.drawable.image_ironman"));
//        categoryListdATA();
        adapter = new CategoryAdapter(getContext(), listCategory);
        rvcCategory.setLayoutManager(layoutManager);
        rvcCategory.setAdapter(adapter);

    }
}