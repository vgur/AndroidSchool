package com.example.a16719756.cupsandballs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    ImageView imageView1, imageView2, imageView3;
    ImageView imageView11, imageView12, imageView13;
    Button button_new;

    private int ball_place = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);

        button_new = findViewById(R.id.button_new);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage();
            }
        });
    }

    private void showMessage() {
        Toast.makeText(MainActivity.this, "Шарик в "+ball_place, Toast.LENGTH_LONG).show();
        switch (ball_place) {
            case 1:
                imageView11.setVisibility(View.VISIBLE);
                break;
            case 2:
                imageView12.setVisibility(View.VISIBLE);

                break;
            case 3:
                imageView13.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    public void newGame(View view){
        Random rn = new Random();
        int range = 3;
        ball_place =  rn.nextInt(range) + 1;
        imageView11.setVisibility(View.INVISIBLE);
        imageView12.setVisibility(View.INVISIBLE);
        imageView13.setVisibility(View.INVISIBLE);

    }


}
