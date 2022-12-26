package com.example.examtest2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText uname,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname=findViewById(R.id.etUsername);
        pass=findViewById(R.id.etPassword);
        login=findViewById(R.id.btnLogin);

        //set method for click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().equals("Hazirah")&&pass.getText().toString().equals("1234")){
                    //create toast for successfull login
                    Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    //intent to next page
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("Uname",uname.getText().toString());
                    uname.setText("");
                    startActivity(intent);
                }else{
                    //call for alert dialog
                    showAlertDialogButtonClicked();
                    uname.setText("");
                    pass.setText("");

                }
            }
        });


    }

    public void showAlertDialogButtonClicked(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Authentication Failed");
        builder.setMessage("Username and Password is Wrong,Please Try Again!");

        //add button
        builder.setPositiveButton("OK",null);

        //create and show alert dialog
        AlertDialog dialog= builder.create();
        dialog.show();
    }
}