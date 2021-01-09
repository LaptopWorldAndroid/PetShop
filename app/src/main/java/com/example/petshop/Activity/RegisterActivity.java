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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText et_fullname, et_place, et_phone, et_email, et_passsword;
    Button bt_register;
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    FirebaseAuth mAuth;
    static final String USER = "user";
    static final String TAG = "registerActivity";
    Customer user;

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
        mAuth = FirebaseAuth.getInstance();


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
                registerUser(Username, Password);

                if (Displayname.equals("")) ;
                {
                    Toast.makeText(RegisterActivity.this, "name", Toast.LENGTH_SHORT).show();
                }
                if (Phone.equals("")) ;
                {
                    Toast.makeText(RegisterActivity.this, "phone", Toast.LENGTH_SHORT).show();
                }

                if (Address.equals("")) ;
                {
                    Toast.makeText(RegisterActivity.this, "place", Toast.LENGTH_SHORT).show();
                }
                if (Password.equals("")) ;
                {
                    Toast.makeText(RegisterActivity.this, "pass", Toast.LENGTH_SHORT).show();
                }
                // register the user in firebase

                //  Log.d("REGISTER", "onClick: 123");
            }
        });
    }

    public void registerUser(String username, String password) {
        mAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
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