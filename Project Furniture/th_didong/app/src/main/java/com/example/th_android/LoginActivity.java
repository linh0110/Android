package com.example.th_android;

import android.os.*;
import android.content.*;
import android.support.v4.app.INotificationSideChannel;
import android.view.*;
import android.app.*;
import android.view.inputmethod.EditorInfo;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.th_android.Main2Activity;
import com.example.th_android.RegisterActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin, btnRegister, btnOK, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsername = findViewById(R.id.editText);
        edtUsername.setOnEditorActionListener(editorListener);
        edtPassword = findViewById(R.id.editText1);
        edtPassword.setOnEditorActionListener(editorListener);
        edtPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if ((keyEvent.getAction() == KeyEvent.ACTION_DOWN) &&
                        (i == KeyEvent.KEYCODE_ENTER)) {
                    if(edtUsername.getText().toString().isEmpty())
                    {
                        edtUsername.setError("Không được để trống");

                    }
                    if(edtPassword.getText().length()<6)
                    {
                        edtPassword.setError("Mật khẩu lớn hơn 6 ký tự");
                    }
                    else {

                        Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                        intent.putExtra("Username",edtUsername.getText().toString());
                        startActivity(intent);
                    }
                    return true;
                }
                return false;
            }
        });
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUsername.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()) {
                    final Dialog dialog = new Dialog(LoginActivity.this);
                    dialog.setContentView(R.layout.activity_dialog);
                    btnOK = dialog.findViewById(R.id.btnOK);
                    btnCancel = dialog.findViewById(R.id.btnCancel);
                    btnOK.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                            startActivityForResult(intent, 100);
                            dialog.dismiss();
                        }
                    });
                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });
                    dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    dialog.show();
                } else if (edtPassword.getText().toString().length() < 6) {
                    edtPassword.setError("Minimum 6 number");
                } else {
                    Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                    //send data to Info form Login with key-value
                    intent.putExtra("Username", edtUsername.getText().toString());
                    startActivity(intent);
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == 101){
            edtUsername.setText(data.getStringExtra("username"));
            edtPassword.setText(data.getStringExtra("password"));
        }
        if(requestCode == 102 && resultCode == 101) {
            edtUsername.setText(data.getStringExtra("username"));
            edtPassword.setText(data.getStringExtra("password"));
        }
    }
    private TextView.OnEditorActionListener editorListener= new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId){
                case EditorInfo
                        .IME_ACTION_NEXT:Toast.makeText(LoginActivity.this,"Next",Toast.LENGTH_SHORT).show();
                    break;
                case  EditorInfo.IME_ACTION_SEND: Toast.makeText(LoginActivity.this,"Send",Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    };

}
