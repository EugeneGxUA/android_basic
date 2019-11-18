package com.egaragul.fragmentlifecycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private static final String TAG = "Fragment2 LIFECYCLE -> ";

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    public SecondFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showToastAndLog("onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        showToastAndLog("onCreateView()");

        final View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        showToastAndLog("onAttach()");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        showToastAndLog("onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();

        showToastAndLog("onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();

        showToastAndLog("onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();

        showToastAndLog("onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();

        showToastAndLog("onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        showToastAndLog("onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        showToastAndLog("onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        showToastAndLog("onDetach()");
    }

    private void showToastAndLog(String text) {
        Toast.makeText(getActivity(), TAG + text, Toast.LENGTH_SHORT).show();

        Log.i(TAG, text);
    }
}
