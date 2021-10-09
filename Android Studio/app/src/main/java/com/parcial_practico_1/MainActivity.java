package com.parcial_practico_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout container;
    private TextView txtTitle, txtSubTitle1, txtSubTitle2, txtSubTitle3, txtSubTitle4, txtSubTitle5, txtSubTitle6;
    private EditText editTxt1, editTxt2, editTxt3, editTxt4;
    private Button bnCreate, bnDelete;

    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;

    private String groupName;
    private int Red, Green, Blue, posX, posY, particleNumber;

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

        bnCreate.setOnClickListener(
                (v) -> {

                    if(editTxt1.getText().toString().isEmpty() || editTxt2.getText().toString().isEmpty() || editTxt3.getText().toString().isEmpty() || editTxt4.getText().toString().isEmpty()){
                        Toast.makeText(this, "Por favor llenar los campos", Toast.LENGTH_SHORT).show();
                    } else{
                       groupName = editTxt1.getText().toString().replace(" ", "");
                       particleNumber = Integer.parseInt(editTxt2.getText().toString().replace(" ", ""));
                       posX = Integer.parseInt(editTxt3.getText().toString().replace(" ", ""));
                       posY = Integer.parseInt(editTxt4.getText().toString().replace(" ", ""));
                    }
                }
        );
    }

    public void startClient(){
        new Thread(
                () -> {
                    try {
                        socket = new Socket("192.168.1.53", 5000);
                        System.out.println("Se ha conectado al servidor!!!");

                        /////////////////////////////////////////////////////

                        InputStream is = socket.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is);
                        br = new BufferedReader(isr);

                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bw = new BufferedWriter(osw);

                        /////////////////////////////////////////////////////

                        while (true){
                            String line = br.readLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    public void send(String msg){
        new Thread(
                () -> {
                    try {
                        bw.write(msg + "\n");
                        bw.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        ).start();
    }
}