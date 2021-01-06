package com.example.petshop.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.petshop.Adapter.CategoryAdapter;
import com.example.petshop.Adapter.SearchAdapter;
import com.example.petshop.Class.Category;
import com.example.petshop.Class.Product;
import com.example.petshop.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class SearchViewFragment extends Fragment {

    private View viewRoot;
    private RecyclerView rcvResultList;
    private SearchView searchView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    SearchAdapter adapter;
    private ArrayList<Product> listProduct = new ArrayList<>();
    ArrayList<Product> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        viewRoot = inflater.inflate(R.layout.fragment_search_view, container, false);

        Init();
        return viewRoot;
    }

    @Override
    public void onStart() {
        super.onStart();
    }


    private void search(String s){
        ArrayList<Product>mylist=new ArrayList<>();

        for (Product object: list){
            if(object.getNameProduct().toLowerCase().contains(s.toLowerCase()))
            {
                mylist.add(object);
            }

        }

        SearchAdapter adapter=new SearchAdapter(listProduct);

        rcvResultList.setAdapter(adapter);
    }

    private void Init() {
        rcvResultList = (RecyclerView) viewRoot.findViewById(R.id.rcvResultList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);

    }
}