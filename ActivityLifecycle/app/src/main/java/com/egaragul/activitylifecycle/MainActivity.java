package com.egaragul.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LIFECYCLE -> ";

    private AppCompatTextView textView;
    private AppCompatButton touchMeBtn;
    private AppCompatButton exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);
        touchMeBtn = findViewById(R.id.touch_me_btn);
        exitBtn = findViewById(R.id.exit_btn);

        showToastAndLog("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        showToastAndLog("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        showToastAndLog("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        showToastAndLog("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        showToastAndLog("onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        showToastAndLog("onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        showToastAndLog("onDestroy()");
    }

    private void showToastAndLog(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        Log.i(TAG, text);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.touch_me_btn : {
                textView.setText("App was already running");
                break;
            }
            case R.id.exit_btn : {
                finish();
                break;
            }

            default: {
                break;
            }
        }
    }
}
