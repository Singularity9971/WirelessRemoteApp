package com.example.avirudhtheraja.wirelessremoteapp;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

public class AddDeviceActivity extends AppCompatActivity implements View.OnClickListener,ButtonFragment.OnFragmentInteractionListener {

    private FrameLayout frameLayout;
    Fragment frag;
    public static final String TAG = "ButtonFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        frameLayout = (FrameLayout)findViewById(R.id.add_device_framelayout);
        frameLayout.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.done_device_added_button:
                checkDatabase();
                break;
            default:
                break;
        }
    }

    private void checkDatabase() {
        //check if config file exists for current device id
        String id = ((EditText)findViewById(R.id.device_id_edittext)).getText().toString();

    }

    private void showButtonFragment(){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        frag = ButtonFragment.newInstance();
        transaction.add(R.id.add_device_framelayout,frag,TAG);
        frameLayout.setVisibility(View.VISIBLE);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(getSupportFragmentManager().findFragmentByTag(TAG) != null) {
            getSupportFragmentManager().beginTransaction().remove(frag).commit();
            frag = null;
        }
        super.onBackPressed();
    }

    private void storeDevice() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        String name = ((EditText)findViewById(R.id.device_name_edittext)).getText().toString();
        String id = ((EditText)findViewById(R.id.device_id_edittext)).getText().toString();
        Device device = new Device(name,id);
        Gson gson = new Gson();
        String json = gson.toJson(device);
        edit.putString("Device"+ApplicationController.getSize(),json);
        ApplicationController.increaseSize();
        edit.apply();
    }


    @Override
    public void ButtonPressed(String type) {

    }
}
