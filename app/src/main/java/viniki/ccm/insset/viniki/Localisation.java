package viniki.ccm.insset.viniki;

import android.location.Location;

import java.util.Date;

public class Localisation {

    private Location location;

    private double latitude;
    private double longitude;
    private Date date;

    double prendreLatitude (){
        latitude = location.getLatitude();
        return latitude;
    }

    double prendreLongitude (){
        longitude = location.getLongitude();
        return longitude;
    }

    public Date getDate() {
        return date;
    }
}
