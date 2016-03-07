package com.example.avirudhtheraja.wirelessremoteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.remote_button:
                startActivity(new Intent(MainActivity.this,RemoteActivity.class));
                break;
            case R.id.routine_button:
                break;
            default:
                break;
        }
    }
}
