package com.egaragul.toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton toastBtn = findViewById(R.id.toast_btn);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "Default", Toast.LENGTH_SHORT);

                toast.setGravity(Gravity.TOP, 0 , 0);
                toast.show();
            }
        });

        AppCompatButton toastWithIv = findViewById(R.id.toast_with_iv);
        toastWithIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastWithImage();
            }
        });

        AppCompatButton customToastBtn = findViewById(R.id.toast_custom_btn);
        customToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast();
            }
        });
    }

    private void showToastWithImage() {
        Toast toast = Toast.makeText(
                getApplicationContext(),
                "Toast with image and transparent background",
                Toast.LENGTH_SHORT
        );
        toast.setGravity(Gravity.CENTER, 0, 0);

        LinearLayout layoutContainer = (LinearLayout) toast.getView();
        layoutContainer.setBackgroundColor(Color.TRANSPARENT);

        AppCompatImageView imageView = new AppCompatImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.ic_warning);
        layoutContainer.addView(imageView, 0);

        toast.show();
    }

    private void showCustomToast() {
        View customToast = getLayoutInflater().inflate(R.layout.layout_custom_toast, (ViewGroup) findViewById(R.id.toast_layout));

        AppCompatTextView toastTv = customToast.findViewById(R.id.toast_tv);
        toastTv.setText("Custom toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0 , 0);
        toast.setDuration(Toast.LENGTH_LONG);

        toast.setView(customToast);
        toast.show();
    }
}
