package pptik.id.gpstrackertester.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;

import org.osmdroid.views.overlay.Marker;

import pptik.id.gpstrackertester.R;
import pptik.id.gpstrackertester.models.Tracker;


public class MarkerClick {
    private Context context;
    private View frameView;
    private FragmentTransUtility fragmentTransUtility;
    private Animation fromRight;
    private AnimationView animationView;

    public MarkerClick(Context context, View frameView){
        this.context = context;
        this.frameView = frameView;
        fragmentTransUtility = new FragmentTransUtility(context);
        animationView = new AnimationView(context);
        fromRight = animationView.getAnimation(R.anim.slide_up, null);
    }

    public void checkMarker(Marker marker){
        if(marker.getRelatedObject() instanceof Tracker){
            MapTrackerFragment mapTrackerFragment = new MapTrackerFragment();
            mapTrackerFragment.setData((Tracker) marker.getRelatedObject());
            fragmentTransUtility.setTrackerMapFragment(mapTrackerFragment, frameView.getId());
            frameView.setVisibility(View.VISIBLE);
            frameView.startAnimation(fromRight);
        }
    }
}