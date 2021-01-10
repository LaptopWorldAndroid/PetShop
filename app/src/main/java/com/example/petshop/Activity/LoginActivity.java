package com.example.petshop.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.petshop.Class.Customer;
import com.example.petshop.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {
    EditText et_username, et_password;
    Button bt_submit;
    TextView tv_signup;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Password = "passwordKey";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tv_signup = findViewById(R.id.tv_signup);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        bt_submit = findViewById(R.id.bt_submit);

        getdatauser();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_username.getText().toString().equals("admin") && et_password.getText().toString().equals("123")) {
                    String username  = et_username.getText().toString();
                    String password  = et_password.getText().toString();

                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(Name, username);
                    editor.putString(Password, password);


                    editor.commit();

                    String usernameSession = sharedpreferences.getString(Name, "failed");
                    String passwordSession = sharedpreferences.getString(Password, "failed");

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setIcon(R.drawable.ic_check);
                    builder.setTitle(usernameSession);
                    builder.setMessage(passwordSession);
                    builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                } else {
                    Toast.makeText(getApplicationContext(), "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
                //startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }

        });
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        }

        );
    }




    public class Session {

        private SharedPreferences prefs;

        public Session(Context cntx) {
            // TODO Auto-generated constructor stub
            prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
        }

        public void setusename(String usename) {
            prefs.edit().putString("usename", usename).commit();
        }

        public String getusename() {
            String usename = prefs.getString("usename","");
            return usename;
        }
    }

    private void getdatauser() {

        db.getInstance().collection("customer")
                .whereEqualTo("username", "admin")
                .get()
                .addOnCompleteListener(task -> {

                    Log.d("Logging65", "Data: " + task.getResult());


                });

    }

}