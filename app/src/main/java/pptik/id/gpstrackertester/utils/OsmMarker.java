package pptik.id.gpstrackertester.utils;

import com.google.gson.Gson;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import pptik.id.gpstrackertester.R;
import pptik.id.gpstrackertester.models.Tracker;


public class OsmMarker {

    private MapView mapView;

    public OsmMarker(MapView mapView){
        this.mapView = mapView;
    }

    public Marker add(Object objectMap){
        Marker marker = null;
        if(objectMap instanceof Tracker){
            GeoPoint point = new GeoPoint(((Tracker) objectMap).getData().get(0), ((Tracker) objectMap).getData().get(1));
            marker = new Marker(mapView);
            marker.setPosition(point);
            marker.setIcon(mapView.getContext().getResources().getDrawable(R.mipmap.ic_launcher));
            marker.setRelatedObject(objectMap);
            mapView.getOverlays().add(marker);
        }

        return marker;
    }
}