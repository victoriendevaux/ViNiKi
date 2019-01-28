package viniki.ccm.insset.viniki;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        BoiteAOutils.verifperm(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        GPSLocalisationService.setActiviteMap(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapManager.setLaMap(googleMap);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Si pas permission
            return;
        }
        MapManager.getLaMap().setMyLocationEnabled(true);
        LatLng positionActuel = new LatLng(GlobalVariable.getInstance().getConnectedUtilisateur().getMaLocalisation().getLatitude(), GlobalVariable.getInstance().getConnectedUtilisateur().getMaLocalisation().getLongitude());
        MapManager.getLaMap().animateCamera(CameraUpdateFactory.newLatLngZoom(positionActuel, 15f));
    }

    @Override
    public void onBackPressed() {
        GPSLocalisationService.setActiviteMap(null);
        MapManager.clearLaMap();
        super.onBackPressed();
    }

    public void rafraichirPositionUtilisateurs(List<Utilisateur> localisationUtilisateurs){
        MapManager.ActualiseMap(GlobalVariable.getInstance().getConnectedUtilisateur().getMaLocalisation().localisationsProcheDeMoi(localisationUtilisateurs));
    }
}
