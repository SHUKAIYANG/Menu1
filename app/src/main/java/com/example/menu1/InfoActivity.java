package com.example.menu1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    private EditText editTextData;
    private String data;
    private Button buttonOK;
    private Context context;
    private final int ReturnInfo = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        context = this;

        editTextData = (EditText) findViewById(R.id.editText_data);
        editTextData.setText("");

        buttonOK = (Button) findViewById(R.id.button_ok);

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data = editTextData.getText().toString();

                if(data.length() == 0) {
                    Toast.makeText(context, "Please input data.", Toast.LENGTH_SHORT).show();
                }else {

                    Intent intent = new Intent();
                    intent.putExtra("infoData", data);

                    setResult(ReturnInfo, intent);

                    // 呼叫 Dialog
                    showDialog_1();
                }

            }
        });

    } // onCreate()


    private void showDialog_1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.information);
        builder.setTitle("Input data");
        builder.setMessage(data);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                dialog.dismiss();
            }
        });


        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.create().show(); // 這樣 Dialog 才會顯示

    }


} // class InfoActivity
