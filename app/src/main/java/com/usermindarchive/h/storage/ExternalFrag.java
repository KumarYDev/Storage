package com.usermindarchive.h.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

import static android.content.Context.MODE_PRIVATE;


public class ExternalFrag extends Fragment {
    Button save;
    EditText ext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_external,container,false);
        save=(Button)view.findViewById(R.id.save);
        ext=(EditText) view.findViewById(R.id.file);
        SharedPreferences store=getActivity().getSharedPreferences("extst",MODE_PRIVATE);
        if(store.contains("file"))
            ext.setText(store.getString("file",""));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences store=getActivity().getSharedPreferences("extst",MODE_PRIVATE);
                SharedPreferences.Editor data=store.edit();
                data.putString("file",ext.getText().toString());
                data.apply();
            }
        });

        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public boolean checksharedpref(String file){
        File f = new File(getActivity().getApplicationInfo().dataDir + "/shared_prefs/"
                + file + ".xml");

        if(f.exists())
            return true;
        else
            return false;
    }
}
