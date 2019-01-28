package viniki.ccm.insset.viniki;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MapManager {

    private static GoogleMap laMap;

    public static GoogleMap getLaMap() {
        return laMap;
    }

    public static void setLaMap(GoogleMap laMap) {
        MapManager.laMap = laMap;
    }

    public static void clearLaMap() {
        laMap.clear();
    }

    public static void ActualiseMap(List<Utilisateur> localisationUtilisateurs){
        Log.i("LPK_GetLoK", "ActuMap");
        clearLaMap();
        LatLng positionActuel = new LatLng(GlobalVariable.getInstance().getConnectedUtilisateur().getMaLocalisation().getLatitude(), GlobalVariable.getInstance().getConnectedUtilisateur().getMaLocalisation().getLongitude());
        getLaMap().animateCamera(CameraUpdateFactory.newLatLngZoom(positionActuel, 15f));

        for (Utilisateur loc : localisationUtilisateurs) {
            LatLng position = new LatLng(loc.getMaLocalisation().getLatitude(), loc.getMaLocalisation().getLongitude());

            laMap.addMarker(new MarkerOptions().position(position).title(loc.getNomUtilisateur() + " " + loc.getPrenomUtilisateur()));
        }
    }
}


