package com.example.menu1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private TextView textViewTitle;
    private int currentColor;
    private int newColor;
    private boolean pictureFlag, colorFlag;
    private ImageView imageViewPicture;
    private TextView textViewReturn;
    private final int ChangePicture = 1;
    private final int ChangColor = 2;
    private final int SelectInfo = 3;
    private final String TAG = "main";
    private Intent intent;
    private final int InfoRequestCode = 100;
    private final int ReturnInfo = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        context = this;

        pictureFlag = false;
        colorFlag = false;

        textViewTitle = (TextView) findViewById(R.id.textView_title);

        currentColor = textViewTitle.getCurrentTextColor();
        newColor = 0xff800080;
        colorFlag = true;

        imageViewPicture = (ImageView) findViewById(R.id.imageView_id);
        textViewReturn = (TextView) findViewById(R.id.textView_return);
        textViewReturn.setText("");


    } // onCreate()


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

            menu.add(1, ChangePicture, Menu.NONE, "Change Picture");
            menu.add(1, ChangColor, Menu.NONE, "Change Color");
            menu.add(1, SelectInfo, Menu.NONE, "Select Info");
            return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.d(TAG, "item id = " + item.getItemId());

        switch (item.getItemId()) {

            case ChangePicture:
                if(pictureFlag) {
                    imageViewPicture.setImageResource(R.drawable.steak);
                    textViewTitle.setText("You select Steak.");
                    pictureFlag = false;

                }else {
                    imageViewPicture.setImageResource(R.drawable.soup);
                    textViewTitle.setText("You select Soup.");
                    pictureFlag = true;
                }
                break;

            case ChangColor:
                if(colorFlag) {
                    textViewTitle.setTextColor(newColor);
                    colorFlag = false;
                }else {
                    textViewTitle.setTextColor(currentColor);
                    colorFlag = true;
                }
                break;

            case SelectInfo:

                intent = new Intent(context, InfoActivity.class);

                startActivityForResult(intent, InfoRequestCode);


                break;

        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == InfoRequestCode) {
            if(resultCode == ReturnInfo) {
                Log.d(TAG, "requestcode Info = " + requestCode);
                String message = data.getStringExtra("infoData");
                textViewReturn.setText(message);
            }

        }
    }


} // class MainActivity
