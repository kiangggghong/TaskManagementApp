package com.example.perfectplanner;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Siyuan on 18/10/2016.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.app.Fragment;

    public class SummaryFragment extends Fragment {
        @Nullable

        View myView;
        String[] itemname = {
                "Alice",
                "Bob",
                "Charlie"
        };

        Integer[] imgid = {
                R.drawable.alice,
                R.drawable.bob,
                R.drawable.charlie
        };

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            myView = inflater.inflate(R.layout.activity_summary, null, false);

            //inflate the layout for this fragment
            ListView summaryLv = (ListView) myView.findViewById(R.id.summarylistview);

            final CustomListAdapter myAdapter = new CustomListAdapter(getActivity(), itemname, imgid);
            summaryLv.setAdapter(myAdapter);

            final Button button = (Button) myView.findViewById(R.id.summarybtn);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    android.app.FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_side_bar, new HomeFragment()).commit();

                }
            });

            return myView;
        }
}
