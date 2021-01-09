package com.example.petshop.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.petshop.Class.Customer;
import com.example.petshop.Class.Product;
import com.example.petshop.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProfileEditActivity extends AppCompatActivity {

    EditText edtDisplayName,edtPhone,edtAddress;
    Button btnUpdate;
    Customer customer;
    ArrayList<String> list = new ArrayList();
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        Init();
        getData("37yx9CWrBEfh9SZ2Cr2n");
        addEvents();
    }

    private void addEvents() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference c = db.collection("customer").document("37yx9CWrBEfh9SZ2Cr2n");
                c
                        .update("address", customer.getAddress())
                        .update("phone", customer.getPhone())
                        .update("address", customer.getAddress())
                        .update("address", customer.getAddress())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Log.d("TAG", "DocumentSnapshot successfully updated!");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("TAG", "Error updating document", e);
                            }
                        });

            }
        });
    }

    private void Init() {
        edtDisplayName=findViewById(R.id.edtDisplayName);
        edtPhone=findViewById(R.id.edtPhone);
        edtAddress=findViewById(R.id.edtAddress);
        btnUpdate=findViewById(R.id.btnUpdateProfile);
    }

    private void onSetData() {
        edtDisplayName.setText(customer.getDisplayName());
        edtPhone.setText(customer.getPhone());
        edtAddress.setText(customer.getAddress());
    }

    private void getData(String idUser) {
        final DocumentReference docRef = db.collection("customer").document(idUser);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w("1", "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {

                    Map<String, Object> data = new HashMap<>();
                    data=snapshot.getData();

                    customer = new Customer(
                            data.get("email").toString(),
                            data.get("username").toString(),
                            data.get("address").toString(),
                            data.get("password").toString(),
                            data.get("phone").toString());
                    Log.d("33333", customer.getDisplayName());
                    onSetData();
                } else {
                    Log.d("3", "Current data: null");
                }
            }
        });
    }
}