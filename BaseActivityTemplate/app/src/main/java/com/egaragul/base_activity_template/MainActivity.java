package com.egaragul.base_activity_template;

import android.graphics.Color;
import android.os.Bundle;

import com.egaragul.base_activity_template.util.SnackbarHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Snackbar mSnackbar;

    private View.OnClickListener snackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Молодец!", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSnackbar = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Yes", snackBarClickListener);

//                setCustomSnackbarView(mSnackbar);

                View snackbarView = mSnackbar.getView();
                snackbarView.setBackgroundColor(Color.RED);

                mSnackbar.setActionTextColor(Color.MAGENTA);

                mSnackbar.show();

                mSnackbar.addCallback(new Snackbar.Callback() {
                    @Override
                    public void onShown(Snackbar sb) {
                        Log.d(TAG, "onShown() called with: sb = [" + sb + "]");
                    }

                    @Override
                    public void onDismissed(Snackbar transientBottomBar, int event) {
                        if (event == Snackbar.Callback.DISMISS_EVENT_TIMEOUT) {
                            Log.i("SnackBar", "Закрыт по истечении таймаута");
                        }
                        if(event == Snackbar.Callback.DISMISS_EVENT_SWIPE){
                            Log.i("SnackBar", "Swipe");
                        }
                    }
                });
            }
        });
    }

    private void setCustomSnackbarView(Snackbar snackbarView) {
        SnackbarHelper.configSnackbar(MainActivity.this, snackbarView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
