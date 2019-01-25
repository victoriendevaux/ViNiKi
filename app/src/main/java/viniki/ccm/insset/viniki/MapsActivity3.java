package viniki.ccm.insset.viniki;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.List;

public class MapsActivity3 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        GPSLocalisationService.setActiviteMap(this);
        //BDDManager.getUtilisateursOnline(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.id_mapViews);
        mapFragment.getMapAsync(this);
    }

    public void rafraichirPositionUtilisateurs(List<Localisation> localisationUtilisateurs){
        Log.i("LPK_GetLoK", "Rafraichir");
        MapManager.ActualiseMap(GlobalVariable.getInstance().getConnectedUtilisateur().getMaLocalisation().localisationsProcheDeMoi(localisationUtilisateurs));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.i("LPK_GetLoK", "Map ready");
        MapManager.setLaMap(googleMap);
    }

    @Override
    public void onBackPressed() {
        Log.i("LPK_GetLoK", "back");
        GPSLocalisationService.setActiviteMap(null);
        MapManager.clearLaMap();
        super.onBackPressed();
    }

}
