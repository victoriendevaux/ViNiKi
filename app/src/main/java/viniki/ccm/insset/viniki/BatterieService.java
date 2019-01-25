package viniki.ccm.insset.viniki;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.IBinder;

public class BatterieService extends Service {
    public BatterieService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public float batteryLevel()
    {
        Intent batteryIntent = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale =  batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        if(level == -1 || scale == -1)
            return 50.0f;

        return ((float) level / (float) scale) * 100f;
    }

    public  int changementRafraichissement(long temps_actuelle)
    {
        float batterie = batteryLevel();
        if(batterie <= 75 && batterie > 50)
        {
            temps_actuelle = temps_actuelle + 5 ;
        }

        if(batterie <= 50 && batterie > 25)
        {
            temps_actuelle = temps_actuelle +10 ;
        }

        if(batterie <= 25 && batterie > 1)
        {
            temps_actuelle =  temps_actuelle + 15;
        }

        return (int) temps_actuelle;
    }
}
