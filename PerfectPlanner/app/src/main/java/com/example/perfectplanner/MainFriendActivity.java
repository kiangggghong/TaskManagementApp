package com.example.perfectplanner;

/**
 * Created by fangy on 27/10/2016.
 */
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class MainFriendActivity extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.main_friends, container, false);

        String[] names = {"Alice", "Bob", "Charlie"};
        ListView listView = (ListView) myView.findViewById(R.id.friendListView);
        SearchView searchView = (SearchView) myView.findViewById(R.id.searchView1);
        final ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1, names
        );

        listView.setAdapter(listViewAdapter);


        searchView.setOnQueryTextListener(new onQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String text){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text){

                listViewAdapter.getFilter().filter(text);
                return false;
            }
        });

        return myView;
    }

    private class onQueryTextListener implements OnQueryTextListener {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    }


    //Defining android ListView
//        ListView mListView;
//
//        //Elements that will be displayed in android ListView
//        //String[] Countries = new String[]{"Alice", "Bob", "Charlie"};
//
//        //Ids of flag Images that are placed in res> drawable folder. They return the int value
//        int[] FlagId = new int[]{R.drawable.alice, R.drawable.bob,
//                R.drawable.charlie};
//
//        mListView = (ListView)myView.findViewById(R.id.friendListView);

        //Declaring Array adapter
        //ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Countries);

//        ArrayList<Pair<String, Integer>> countries = new ArrayList<Pair<String, Integer>>();
//        countries.add(Pair.create("My Profile", R.drawable.alice));
//        ArrayAdapter listadaptor = new ArrayAdapter<Pair<String, Integer>>(this,android.R.layout.simple_list_item_1, R.id.item_nameTxt, Countries);
//        public View getView(int position, View convertView, ViewGroup container){
//
//        }
        //Setting the android ListView's adapter to the newly created adapter
//        mListView.setAdapter(countryAdapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //The position where the list item is clicked is obtained from the
//                //the parameter position of the android listview
//                int itemPosition = position;
//
//                //Get the String value of the item where the user clicked
//                String itemValue = (String) mListView.getItemAtPosition(position);
//
//    }
//
//
//    //Defining android ListView
//    ListView mListView;
//
//    //Elements that will be displayed in android ListView
//    String[] Countries = new String[]{"Alice", "Bob", "Charlie"};
//
//    //Ids of flag Images that are placed in res> drawable folder. They return the int value
//    int[] FlagId = new int[]{R.drawable.alice, R.drawable.bob,
//            R.drawable.charlie};
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    private GoogleApiClient client;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main_friends);
//
//        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        //Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
//        //setSupportActionBar(toolbar1);
//
//        mListView = (ListView) findViewById(R.id.friendListView);
//
//        //Declaring Array adapter
//        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Countries);
//
////        ArrayList<Pair<String, Integer>> countries = new ArrayList<Pair<String, Integer>>();
////        countries.add(Pair.create("My Profile", R.drawable.alice));
////        ArrayAdapter listadaptor = new ArrayAdapter<Pair<String, Integer>>(this,android.R.layout.simple_list_item_1, R.id.item_nameTxt, Countries);
////        public View getView(int position, View convertView, ViewGroup container){
////
////        }
//        //Setting the android ListView's adapter to the newly created adapter
//        mListView.setAdapter(countryAdapter);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                //The position where the list item is clicked is obtained from the
//                //the parameter position of the android listview
//                int itemPosition = position;
//
//                //Get the String value of the item where the user clicked
//                String itemValue = (String) mListView.getItemAtPosition(position);
//
//                //In order to start displaying new activity we need an intent
//                //Intent intent = new Intent(getApplicationContext(),CountryActivity.class);
//
//                //Putting the Id of image as an extra in intent
//                //intent.putExtra("flag",FlagId[position]);
//
//                //Here we will pass the previously created intent as parameter
//                //startActivity(intent);
//
//            }
//        });
//
////        MyFragment fragment1 = new MyFragment();
////        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new fragment1()).commit();
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
//    }
//
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    public Action getIndexApiAction() {
//        Thing object = new Thing.Builder()
//                .setName("MainFriend Page") // TODO: Define a title for the content shown.
//                // TODO: Make sure this auto-generated URL is correct.
//                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
//                .build();
//        return new Action.Builder(Action.TYPE_VIEW)
//                .setObject(object)
//                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
//                .build();
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        AppIndex.AppIndexApi.start(client, getIndexApiAction());
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        AppIndex.AppIndexApi.end(client, getIndexApiAction());
//        client.disconnect();
//    }
}