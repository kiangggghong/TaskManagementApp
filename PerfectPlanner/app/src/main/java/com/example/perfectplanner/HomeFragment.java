package com.example.perfectplanner;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


/**
 * Created by Siyuan on 18/10/2016.
 */

public class HomeFragment extends Fragment  {
    //implements View.OnClickListener
    View myView;
    Button myButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.home, container, false);
        TextView quoteText = (TextView) myView.findViewById(R.id.quoteText);

        //select random quotes from string res
        generateSetRandomQuote(quoteText);

        return myView;
    }
    public void generateSetRandomQuote(TextView tvv){
        Random r = new Random();
        int i1 = r.nextInt(17)+1;

        switch (i1){
            case 1:
                tvv.setText(getResources().getString(R.string.quote1));
                break;
            case 2:
                tvv.setText(getResources().getString(R.string.quote2));
                break;
            case 3:
                tvv.setText(getResources().getString(R.string.quote3));
                break;
            case 4:
                tvv.setText(getResources().getString(R.string.quote4));
                break;
            case 5:
                tvv.setText(getResources().getString(R.string.quote5));
                break;
            case 6:
                tvv.setText(getResources().getString(R.string.quote6));
                break;
            case 7:
                tvv.setText(getResources().getString(R.string.quote7));
                break;
            case 8:
                tvv.setText(getResources().getString(R.string.quote8));
                break;
            case 9:
                tvv.setText(getResources().getString(R.string.quote9));
                break;
            case 10:
                tvv.setText(getResources().getString(R.string.quote10));
                break;
            case 11:
                tvv.setText(getResources().getString(R.string.quote11));
                break;
            case 12:
                tvv.setText(getResources().getString(R.string.quote12));
                break;
            case 13:
                tvv.setText(getResources().getString(R.string.quote13));
                break;
            case 14:
                tvv.setText(getResources().getString(R.string.quote14));
                break;
            case 15:
                tvv.setText(getResources().getString(R.string.quote15));
                break;
            case 16:
                tvv.setText(getResources().getString(R.string.quote16));
                break;
            case 17:
                tvv.setText(getResources().getString(R.string.quote17));
                break;

        }
        Toast.makeText(getActivity(), tvv.getText(), Toast.LENGTH_LONG);
    }

//    @Override
//    public void onClick(View view) {
//
//        switch (view.getId()) {
//            case R.id.addBtn:
//                /** Do things you need to..
//                 fragmentTwo = new FragmentTwo();
//
//                 fragmentTransaction.replace(R.id.frameLayoutFragmentContainer, fragmentTwo);
//                 fragmentTransaction.addToBackStack(null);
//
//                 fragmentTransaction.commit();
//                 */
////                final FragmentTransaction ft = getFragmentManager().beginTransaction();
////                ft.replace(R.id.content_side_bar, new AddTaskFragment(), "NewFragmentTag");
////                ft.commit();
////                ft.addToBackStack(null);
////                break;
//                Intent i = new Intent(getActivity(), AddTaskActivity.class);
//                startActivity(i);
//
//                break;
//            case R.id.tasksBtn:
//                /** Do things you need to..
//                 fragmentTwo = new FragmentTwo();
//
//                 fragmentTransaction.replace(R.id.frameLayoutFragmentContainer, fragmentTwo);
//                 fragmentTransaction.addToBackStack(null);
//
//                 fragmentTransaction.commit();
//                 */
//                Fragment f2 = new Fragment();
//                final FragmentTransaction ft2 = getFragmentManager().beginTransaction();
//                ft2.replace(R.id.content_side_bar, f2);
//                ft2.commit();
//                ft2.addToBackStack(null);
//                break;
//        }
//    }
}
