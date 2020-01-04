package com.example.th_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {
    Button btnSignIn,btnCanCel;
    EditText txtEmail,txtUser,txtPass,txtConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmail=findViewById(R.id.editText);
        txtUser = findViewById(R.id.editText2);
        txtPass=findViewById(R.id.editText3);
        txtConfirm= findViewById(R.id.editText4);
        btnSignIn=findViewById(R.id.btnLogin);
        btnCanCel=findViewById(R.id.btnCancel);
        txtConfirm.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (i == KeyEvent.KEYCODE_ENTER)) {

                    if (!isValid(txtEmail.getText().toString())) {
                        txtEmail.setError("Invalid Email Address");
                        return false;
                    }
                    if (txtUser.getText().toString().isEmpty()) {
                        txtUser.setError("Username cannot be null ");
                        return false;
                    }
                    if (txtPass.getText().toString().isEmpty()) {
                        txtPass.setError("Password required");
                        return false;
                    }
                    if (txtConfirm.getText().toString().isEmpty()) {
                        txtConfirm.setError("Password required");
                        return false;
                    }
                    if (txtPass.getText().toString().equals(txtConfirm.getText().toString())) {
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        intent.putExtra("username", txtUser.getText().toString());
                        intent.putExtra("password", txtPass.getText().toString());
                        setResult(101, intent);
                        finish();

                        return true;
                    } else {
                        txtPass.setError("Password and confirm password does not match");
                        txtConfirm.setText("");
                        return false;
                    }





                }
                return false;
            }
        });
        btnCanCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               finish();
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isValid(txtEmail.getText().toString())){
                    txtEmail.setError("Invalid Email Address");
                    return;                 }
                if(txtUser.getText().toString().isEmpty()){
                    txtUser.setError("Username cannot be null ");
                    return;
                }
                if(txtPass.getText().toString().isEmpty()){
                    txtPass.setError("Password required");
                    return;
                }
                if(txtConfirm.getText().toString().isEmpty()){
                    txtConfirm.setError("Password required");
                    return;
                }
                if(txtPass.getText().toString().equals(txtConfirm.getText().toString())) {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    intent.putExtra("username", txtUser.getText().toString());
                    intent.putExtra("password", txtPass.getText().toString());
                    setResult(101, intent);
                    finish();
                }else {
                    txtPass.setError("Password and confirm password does not match");
                    txtConfirm.setText("");
                    return;
                }
            }

        });
    }
    public static boolean isValid(String email)     {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();}
    }
