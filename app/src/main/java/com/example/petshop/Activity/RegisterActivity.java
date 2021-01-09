package com.example.petshop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petshop.Class.Customer;
import com.example.petshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    EditText et_fullname, et_place, et_phone, et_email, et_passsword;
    Button bt_register;
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    static final String USER = "user";
    static final String TAG = "registerActivity";
    Customer user;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_fullname = findViewById(R.id.et_fullname);
        et_place = findViewById(R.id.et_place);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        et_passsword = findViewById(R.id.et_password);

        bt_register = findViewById(R.id.bt_register);

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USER);
//        mAuth = FirebaseAuth.getInstance();

        addEvents();
    }

    private void addEvents() {
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Username, Phone, Address, Password, Displayname;
                Displayname = et_fullname.getText().toString();
                Phone = et_phone.getText().toString();
                Username = et_email.getText().toString();
                Address = et_place.getText().toString();
                Password = et_passsword.getText().toString();
                user = new Customer(Username, Password, Displayname, Phone, Address);
                addDocument(user);

                Log.d("USER", user.getDisplayName());

                if (Displayname.isEmpty()) ;
                {
                    Toast.makeText(RegisterActivity.this, "name", Toast.LENGTH_SHORT).show();
                }
                if (Phone.isEmpty());
                {
                    Toast.makeText(RegisterActivity.this, "phone", Toast.LENGTH_SHORT).show();
                }

                if (Address.isEmpty()) ;
                {
                    Toast.makeText(RegisterActivity.this, "place", Toast.LENGTH_SHORT).show();
                }
                if (Password.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "pass", Toast.LENGTH_SHORT).show();
                }
                // register the user in firebase

                //  Log.d("REGISTER", "onClick: 123");
            }
        });

    }
    // Add a new document with a generated id.
    public void addDocument(Customer customer) {
        Map<String, String> data = new HashMap<>();
        data.put("username", customer.getDisplayName());
        data.put("password", customer.getPassword());
        data.put("address", customer.getAddress());
        data.put("email", customer.getUsername());
        data.put("phone", customer.getPhone());

        db.collection("customer")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("dooo", "DocumentSnapshot written with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("faill", "Error adding document", e);
                    }
                });
    }



    public void updateUI(FirebaseUser currentUser) {
        String keyId = mDatabase.push().getKey();
        mDatabase.child(keyId).setValue(user);
        Intent loginIntent = new Intent(this, MainActivity.class);
        startActivity(loginIntent);
    }
}