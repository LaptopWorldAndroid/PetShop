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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.petshop.Adapter.CategoryAdapter;
import com.example.petshop.Adapter.SearchAdapter;
import com.example.petshop.Class.Category;
import com.example.petshop.Class.ChildCategory;
import com.example.petshop.Class.Product;
import com.example.petshop.R;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import javax.annotation.Nullable;


public class SearchViewFragment extends Fragment {

    private View viewRoot;
    private RecyclerView rcvResultList;
    private AutoCompleteTextView autoCompleteTextView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    SearchAdapter adapter;
    private ArrayList<String> listProductName = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        viewRoot = inflater.inflate(R.layout.fragment_search_view, container, false);
        return viewRoot;
    }

}