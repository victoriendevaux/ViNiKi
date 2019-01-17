package viniki.ccm.insset.viniki;

import android.app.FragmentManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Date;

public class ActiviteMap extends AppCompatActivity implements LocationListener {

    LocationManager monLM;
    private GoogleMap gmap;
    private MapFragment mapFragment;
    private Location location;
    double latitude;
    double longitude;
    Date date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activite_map);

        FragmentManager mFM = getFragmentManager();
        mapFragment = (MapFragment) mFM.findFragmentById(R.id.gmap);
        chargerMap();
    }


    public Date getDate() {
        return date;
    }

    //mapFragment
    private void chargerMap(){
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                gmap = googleMap;
                gmap.clear();
                LatLng maposition = new LatLng(latitude,longitude);
               // CameraUpdate animation = CameraUpdateFactory.newLatLng(maposition);
                gmap.addMarker(new MarkerOptions().position(maposition));
               // gmap.animateCamera(animation);
            }
        });

    }

    @Override
    public void onLocationChanged(Location location) {

        latitude = location.getLatitude();
        longitude = location.getLongitude();
        Toast.makeText(this, "Latitude : " +latitude+" - Longitude : "+longitude, Toast.LENGTH_SHORT).show();

        chargerMap();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (monLM != null) {
            monLM.removeUpdates(this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

    }
}
