package com.egaragul.fragmentlifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button fragmentOneBtn, fragmentTwoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOneBtn = findViewById(R.id.buttonFragment1);
        fragmentTwoBtn = findViewById(R.id.buttonFragment2);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FirstFragment firstFragment = FirstFragment.newInstance();

        fragmentTransaction.add(R.id.container, firstFragment);
        fragmentTransaction.commit();

        fragmentOneBtn.setOnClickListener(btnOnclickListener);
        fragmentTwoBtn.setOnClickListener(btnOnclickListener);

    }

    Button.OnClickListener btnOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Fragment fragment = null;

            if (v == fragmentOneBtn) {
                fragment = FirstFragment.newInstance();
            } else {
                fragment = SecondFragment.newInstance();
            }

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    };
}
