package pptik.id.gpstrackertester.utils;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;


public class FragmentTransUtility {
    private Context context;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    public FragmentTransUtility(Context context){
        this.context = context;
        fragmentManager = ((Activity)context).getFragmentManager();

    }


    public void setTrackerMapFragment(MapTrackerFragment fragment, int id){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(id, fragment);
        fragmentTransaction.commit();
    }
}