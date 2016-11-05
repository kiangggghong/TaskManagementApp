package com.example.perfectplanner;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

/**
 * Created by fangy on 3/11/2016.
 */

public class Profile extends Fragment{
    View myView;
    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TabHost tabHost;

        myView = inflater.inflate(R.layout.activity_profile, container, false);


        TabHost host = (TabHost) myView.findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("Friends");

        spec.setIndicator("Friends");
        host.addTab(spec);
        Intent intent = new Intent(getActivity(),FriendTb.class);
        spec.setContent(intent);
        startActivity(intent);

        spec = host.newTabSpec("Media");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Media");
        host.addTab(spec);

        spec = host.newTabSpec("Awards");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Awards");
        host.addTab(spec);

        return myView;
    }


}
