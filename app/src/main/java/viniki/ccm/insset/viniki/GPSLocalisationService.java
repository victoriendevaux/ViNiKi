package viniki.ccm.insset.viniki;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.util.logging.ConsoleHandler;

public class GPSLocalisationService extends Service {

    private LocationListener listener;
    private LocationManager locationManager;
//    private static ActiviteMap activiteMap = null;

    public GPSLocalisationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("LPK_LOK_Listener", "onCreate");
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                Log.i("LPK_LOK_Listener", "" + location.getLongitude() + " / " + location.getLatitude());
                GlobalVariable.getInstance().getConnectedUtilisateur().getMaLocalisation().setLongitude(location.getLongitude());
                GlobalVariable.getInstance().getConnectedUtilisateur().getMaLocalisation().setLatitude(location.getLatitude());
                // TODO
//                if(activiteMap != null){
//                    LatLng positionActuel = new LatLng(getLatitude(), getLongitude());
//                    googleMap.getmMap().animateCamera(CameraUpdateFactory.newLatLngZoom(positionActuel, 15f));
//                    googleMap.actualisationMarker();
//                }

                BDDManager.changeLocalisationUtilisateur();
                //Log.i("LPK_LOK_Listener", "" + location.getLongitude() + " / " + location.getLatitude());
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent monIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                monIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(monIntent);
            }
        };

        locationManager = (LocationManager) getApplicationContext().getSystemService(Context.LOCATION_SERVICE);

        // Actualisation des données GPS faite toutes les 0.1 secondes si un changement est survenue.

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Si pas les permissions
            return;
        }
        //GlobalVariable.getInstance().getConnectedUtilisateur().getFrequenceDeplacement()*1000
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, listener);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(locationManager != null){
            locationManager.removeUpdates(listener);
        }
    }

//    public static ActiviteMap getActiviteMap() {
//        return activiteMap;
//    }
//
//    public static void setActiviteMap(ActiviteMap activiteMap) {
//        GPSLocalisationService.activiteMap = activiteMap;
//    }
}
