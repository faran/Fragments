package com.pg.fk.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected{

    TextView tvDescription;
    String[] descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);
        descriptions = getResources().getStringArray(R.array.descriptions);


        //the phone is in portrait mode
        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .hide(fragmentManager.findFragmentById(R.id.detailFrag))
                    .show(fragmentManager.findFragmentById(R.id.listFrag))
                    .commit();
        }

        //the phone is in landscape mode
        if(findViewById(R.id.layout_land) != null){
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.listFrag))
                    .show(fragmentManager.findFragmentById(R.id.detailFrag))
                    .commit();
        }

    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions[index]);

        if(findViewById(R.id.layout_portrait) != null){
            FragmentManager fragmentManager = this.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .show(fragmentManager.findFragmentById(R.id.detailFrag))
                    .hide(fragmentManager.findFragmentById(R.id.listFrag))
                    .addToBackStack(null)
                    .commit();
        }

    }
}
