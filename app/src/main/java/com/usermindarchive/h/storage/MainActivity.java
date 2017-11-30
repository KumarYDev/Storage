package com.usermindarchive.h.storage;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button shrd;
    Button extst;
    Button interst;
    LinearLayout lay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shrd=(Button)findViewById(R.id.shard);
        extst=(Button)findViewById(R.id.extst);
        interst=(Button)findViewById(R.id.interst);
        lay=(LinearLayout) findViewById(R.id.layout);

        extst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExternalFrag ext= new ExternalFrag();
                FragmentTransaction ft=getSupportFragmentManager().beginTransaction();

                ft.add(R.id.layout,ext,"EXTST");
                ft.commit();

            }
        });
    }
}
