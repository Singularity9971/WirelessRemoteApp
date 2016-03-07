package com.example.avirudhtheraja.wirelessremoteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DevicesAdapter extends BaseAdapter {
    private ArrayList<Device> deviceArrayList;
    private Context context;

    public DevicesAdapter(Context context,ArrayList<Device> deviceArrayList) {
        this.deviceArrayList = deviceArrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return deviceArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return deviceArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_adapter,null);
        }
        TextView deviceName = (TextView)convertView.findViewById(R.id.device_name_textview);
        String name = ((Device)getItem(position)).getName();
        deviceName.setText(name);
        return convertView;
    }
}
