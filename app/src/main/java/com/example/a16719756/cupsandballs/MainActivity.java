package com.example.a16719756.cupsandballs;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    ImageView imageView1, imageView2, imageView3;
    ImageView imageView11, imageView12, imageView13;
    ImageView imageUsd;
    Button button_new;

    private int ball_place = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Наперстки (фото)
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        // Шарики (рисунок)
        imageView11 = findViewById(R.id.imageView11);
        imageView12 = findViewById(R.id.imageView12);
        imageView13 = findViewById(R.id.imageView13);
        // Картинка с баксом
        imageUsd = findViewById(R.id.image_usd);

        // Слушатели выбора наперстка
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoney(1);
                showMessage();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoney(2);
                showMessage();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMoney(3);
                showMessage();
            }
        });
    }

    // Визуализация шарика
    private void showMessage() {
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

        // через 2 секунда инициализируется исходное состояние
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                initt();
            }
        }, 2000);
    }

    // Если угадали высвечиваем доллар
    private void showMoney(int choice) {
        if (choice == ball_place) {
            imageUsd.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Поздравляем !!!", Toast.LENGTH_LONG).show();
        }
    }

    public void initt() {
        Random rn = new Random();
        int range = 3;
        ball_place = rn.nextInt(range) + 1;
        // Шариков не видно
        imageView11.setVisibility(View.INVISIBLE);
        imageView12.setVisibility(View.INVISIBLE);
        imageView13.setVisibility(View.INVISIBLE);
        imageUsd.setVisibility(View.INVISIBLE);
    }

}
