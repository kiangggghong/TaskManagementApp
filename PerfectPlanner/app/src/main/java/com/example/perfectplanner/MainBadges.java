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

public class MainBadges extends Fragment{
    //    private GridView gv, pv;
//    private ArrayAdapter<String> adapter;
//    private static final String RESULT_OK = null;
//    public Uri CONTENT_URI;
//
//    private static String[] names = {"5 Tasks Completed!",
//            "10 Tasks Completed!",
//            "30 Tasks Completed!",
//            "100 Tasks Completed!",
//            "Networking Star!",
//            "Bookworm",
//            "Partyholic",
//            "Workaholic"
//    };
//    private static Integer[] photos = {
//            R.drawable.tasks5,
//            R.drawable.tasks10,
//            R.drawable.tasks30,
//            R.drawable.tasks100,
//            R.drawable.networkingstar,
//            R.drawable.bookworm,
//            R.drawable.partyholic,
//            R.drawable.workaholic
//    };

//    public static MainBadges newInstance() {
//        MainBadges mainBadges = new MainBadges();
//        return mainBadges;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View myView = inflater.inflate(R.layout.activity_badges, container, false);

        String[] names = {"5 Tasks Completed!",
                "10 Tasks Completed!",
                "30 Tasks Completed!",
                "100 Tasks Completed!",
                "Networking Star!",
                "Bookworm",
                "Partyholic",
                "Workaholic"
        };

//        int[] gridViewImage = {
//                R.drawable.tasks5,
//            R.drawable.tasks10,
//            R.drawable.tasks30,
//            R.drawable.tasks100,
//            R.drawable.networkingstar,
//            R.drawable.bookworm,
//            R.drawable.partyholic,
//           R.drawable.workaholic,
//        };

//        GridView gridView = (GridView) myView.findViewById(R.id.gridViewCustom);
//
//        final ArrayAdapter<String> gridViewAdapter = new ArrayAdapter<String>(
//                getActivity(),
//                android.R.layout.simple_list_item_1, names
//        );
//
//        gridView.setAdapter(gridViewAdapter);


        return myView;
    }
}
//        View view = inflater.inflate(R.layout.activity_badges, container, false);
//
////        super.onCreate(savedInstanceState);
////        int iconSize = getResources().getDimensionPixelSize(android.R.dimen.app_icon_size);
//
//        GridView gridView = (GridView) view.findViewById(R.id.gridViewCustom);
//        gridView.setAdapter(new MyAdapter(view.getContext()));
//
//        //gridView.setOnItemClickListener(this);
////        gv = (GridView) rootView.findViewById(R.id.gridViewCustom);
////
////        gv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, names));
////
////        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                Toast.makeText(getActivity(), names[i], Toast.LENGTH_SHORT).show();
////            }
////        });
//
//
//        return view;
//    }
//
//    public String toString() {
//        return "Badges";
//    }
//
//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//        String icon=adapterView.getItemAtPosition(i).toString();
//        Intent result = new Intent(null, Uri.withAppendedPath(CONTENT_URI,icon));
//        setResult(RESULT_OK, result);
//        finish();
//    }
//
//    public void setResult(String resultOK, Intent result){
//
//    }
//    public void finish(){
//
//    }
//
//    private class IconAdapter extends BaseAdapter{
//        private Context mContext;
//        private int mIconSize;
//        public IconAdapter(Context mContext, int iconSize){
//            super();
//            this.mContext = mContext;
//            this.mIconSize = iconSize;
//            loadIcon();
//        }
//
//        @Override
//        public int getCount() {
//            return mThumbs.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return mThumbs.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View v;
//
//            if (convertView == null) {
//                v = LayoutInflater.from(mContext).inflate(R.layout.activity_badges,null);
//                v.setLayoutParams(new GridView.LayoutParams(200,200));
//            }
//            else {
//                v = convertView;
//            }
//
//            ImageView imageview = (ImageView)v.findViewById(R.id.image);
//            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
//            imageview.setPadding(6, 6, 6, 6);
//            imageDownloader.download(URLS[position], imageview);
//
//            return v;
//        }
//    }
//
//
//
//
//    private ArrayList<Integer> mThumbs;
//    ////////////////////////////////////////////////
//    private void loadIcon() {
//        mThumbs = new ArrayList<Integer>();
//
//        final Resources resources = getResources();
//        final String packageName = getActivity().getApplication().getPackageName();
//
//        addIcon(resources, packageName, R.array.random_imgs);
//
//
//    }
//    private void addIcon(Resources resources, String packageName, int list) {
//        final String[] extras = resources.getStringArray(list);
//        for (String extra : extras) {
//            int res = resources.getIdentifier(extra, "drawable", packageName);
//            if (res != 0) {
//                final int thumbRes = resources.getIdentifier(extra,"drawable", packageName);
//                if (thumbRes != 0) {
//                    mThumbs.add(thumbRes);
//                }
//            }
//        }
//    }
//}