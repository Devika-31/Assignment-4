package com.example.assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class SecondActivity extends AppCompatActivity {
    private  TextView tvTitle;
    private EditText edtEnterText;
    private Button btnEdit;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
//calling listeners;
         str=edtEnterText.getText().toString();
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditDialog editDialog = new
                        EditDialog(SecondActivity.this,edtEnterText.getText().toString());

                editDialog.setMaxLoginAttempts(3);
                editDialog.setTitle("Convert Your Text");


                editDialog.setOnLoginListener(new MyLoginListener());
                editDialog.show();


            }
        });
    }

    private void initUI() {
        tvTitle=findViewById(R.id.tvTitleMain);
        edtEnterText=findViewById(R.id.edtEnterText);
        btnEdit=findViewById(R.id.btnEdit);
    }


    class EditAction {
        public void UpperCAse() {
            edtEnterText.getText().toString().toUpperCase();
        }

        public void LowerCase() {
           edtEnterText.getText().toString().toLowerCase();
        }

        public void InItCap() {

        }
    }

    public void makeToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
    class MyLoginListener implements EditDialog.OnEditListener {
        @Override
        public void onSuccess() {
            edtEnterText.getText().toString().toUpperCase();
        }

        @Override
        public void onFailure() {
            makeToast("My failure Actions");
        }

        @Override
        public void onMaxAttempts() {
            makeToast("MAx attempts");
        }
    }

}