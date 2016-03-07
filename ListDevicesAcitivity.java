package com.example.avirudhtheraja.wirelessremoteapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.TreeSet;

public class ListDevicesAcitivity extends AppCompatActivity {

    private ListView lv;
    private ArrayList<Device> deviceArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_devices_acitivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv = (ListView)findViewById(R.id.devices_listview);
        getData();
        if(deviceArrayList.isEmpty()) {
            Toast.makeText(ListDevicesAcitivity.this, "No devices found, please add one", Toast.LENGTH_LONG).show();
            onBackPressed();
        }
        DevicesAdapter adapter = new DevicesAdapter(ListDevicesAcitivity.this,deviceArrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(ListDevicesAcitivity.this,DeviceActivity.class);
                in.putExtra("Name",deviceArrayList.get(position).getName());
                startActivity(in);
            }
        });
    }

    private void getData(){
        Gson gson = new Gson();
        int i = 0;
        for(;;){
            String json = getPreferences(MODE_PRIVATE).getString("Device"+i,null);
            if(json == null)
                break;
            Device device = gson.fromJson(json,Device.class);
            deviceArrayList.add(device);
            i++;
        }
    }


}
