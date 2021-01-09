package com.example.petshop.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.petshop.R;

public class AccountFragment extends Fragment {

    private View viewRoot;
    TextView txtName,txtEmail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewRoot = inflater.inflate(R.layout.fragment_account, container, false);

        Init();
        addEvents();
        return viewRoot;
    }

    private void addEvents() {
        txtEmail.setText("abc@gmail.com");
        txtName.setText("Việt Fi");
    }

    private void Init() {
        txtName=viewRoot.findViewById(R.id.txtName);
        txtEmail=viewRoot.findViewById(R.id.txtEmail);
    }
}