package com.egaragul.base_activity_template.util;

import android.content.Context;
import android.view.ViewGroup;

import com.egaragul.base_activity_template.R;
import com.google.android.material.snackbar.Snackbar;

public class SnackbarHelper {

    public static void configSnackbar(Context context, Snackbar snackbar) {
        //Margins
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) snackbar.getView().getLayoutParams();
        params.setMargins(12, 12, 12, 12);
        snackbar.getView().setLayoutParams(params);

        //Set corners API 21
        snackbar.getView().setBackground(context.getDrawable(R.drawable.bg_snackbar));
    }

}
