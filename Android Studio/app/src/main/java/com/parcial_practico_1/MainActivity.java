package com.parcial_practico_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout container;
    private TextView txtTitle, txtSubTitle1, txtSubTitle2, txtSubTitle3, txtSubTitle4, txtSubTitle5, txtSubTitle6;
    private EditText editTxt1, editTxt2, editTxt3, editTxt4;
    private Button bnCreate, bnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.container);

        txtTitle = findViewById(R.id.txtTitle);
        txtSubTitle1 = findViewById(R.id.txtSubTitle1);
        txtSubTitle2 = findViewById(R.id.txtSubTitle2);
        txtSubTitle3 = findViewById(R.id.txtSubTitle3);
        txtSubTitle4 = findViewById(R.id.txtSubTitle4);
        txtSubTitle5 = findViewById(R.id.txtSubTitle5);
        txtSubTitle6 = findViewById(R.id.txtSubTitle6);

        editTxt1 = findViewById(R.id.editTxt1);
        editTxt2 = findViewById(R.id.editTxt2);
        editTxt3 = findViewById(R.id.editTxt3);
        editTxt4 = findViewById(R.id.editTxt4);

        bnCreate = findViewById(R.id.bnCreate);
        bnDelete = findViewById(R.id.bnDelete);

        startClient();
    }

    public void startClient(){
    }
}