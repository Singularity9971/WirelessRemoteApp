package com.example.avirudhtheraja.wirelessremoteapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class DeviceActivity extends AppCompatActivity implements ButtonFragment.OnFragmentInteractionListener{

    TextView nameTextview;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nameTextview = (TextView)findViewById(R.id.device_name_device_textview);
        frameLayout = (FrameLayout)findViewById(R.id.device_show_frame_layout);
        String deviceName = getIntent().getExtras().getString("Name");
        nameTextview.setText(deviceName);
        showButtonFragment();
    }

    private void showButtonFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.device_show_frame_layout,ButtonFragment.newInstance(),AddDeviceActivity.TAG);
        frameLayout.setVisibility(View.VISIBLE);
        transaction.commit();
    }

    @Override
    public void ButtonPressed(String type) {

    }
}
