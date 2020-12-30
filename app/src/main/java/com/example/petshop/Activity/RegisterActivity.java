package com.example.petshop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.petshop.R;

public class RegisterActivity extends AppCompatActivity {
    EditText et_fullname, et_place, et_phone, et_email, et_passsword;
    Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Init();
        regitser();
    }

    private void Init() {
        bt_register = findViewById(R.id.bt_register);
    }

    public void regitser() {
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "123123121212", Toast.LENGTH_SHORT).show();
                Log.d("REGISTER", "onClick: 123");
            }
        });
    }
}