package com.example.avirudhtheraja.wirelessremoteapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class RemoteActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_device_button:
                startActivity(new Intent(RemoteActivity.this,AddDeviceActivity.class));
                break;
            case R.id.choose_device_button:
                startActivity(new Intent(RemoteActivity.this,ListDevicesAcitivity.class));
                break;
            default:
                break;
        }
    }
}
