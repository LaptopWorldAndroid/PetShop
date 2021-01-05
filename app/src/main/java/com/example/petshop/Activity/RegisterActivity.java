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

        et_fullname = findViewById(R.id.et_fullname);
        et_place = findViewById(R.id.et_place);
        et_email = findViewById(R.id.et_email);
        et_phone = findViewById(R.id.et_phone);
        et_passsword = findViewById(R.id.et_password);

        bt_register = findViewById(R.id.bt_register);
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
                String Name,Phone,Mail,Place,Passw;
                Name = et_fullname.getText().toString();
                Phone = et_phone.getText().toString();
                Mail = et_email.getText().toString();
                Place = et_place.getText().toString();
                Passw  = et_passsword.getText().toString();

                if(Name.equals(""));{
                Toast.makeText(RegisterActivity.this, "name", Toast.LENGTH_SHORT).show();
                }
                if(Phone.equals(""));{
                    Toast.makeText(RegisterActivity.this, "phone", Toast.LENGTH_SHORT).show();
                }
                if(Mail.equals(""));{
                    Toast.makeText(RegisterActivity.this, "mail", Toast.LENGTH_SHORT).show();
                }
                if(Place.equals(""));{
                    Toast.makeText(RegisterActivity.this, "place", Toast.LENGTH_SHORT).show();
                }
                if(Passw.equals(""));{
                    Toast.makeText(RegisterActivity.this, "pass", Toast.LENGTH_SHORT).show();
                }
              //  Log.d("REGISTER", "onClick: 123");
            }
        });
    }
}