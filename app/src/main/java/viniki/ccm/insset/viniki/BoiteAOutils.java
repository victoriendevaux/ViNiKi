package viniki.ccm.insset.viniki;

import android.content.Context;
import android.os.BatteryManager;
import android.util.Log;

import static android.content.Context.BATTERY_SERVICE;

public class BoiteAOutils {
    public static String crypteMotDePasse(String mdp){
        return mdp;
    }

    public static Integer getBattery(Context context){
        Integer lvlBattery = -1;
        BatteryManager bm = (BatteryManager)context.getSystemService(BATTERY_SERVICE);
        lvlBattery = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        Log.i("LPK_Battery", lvlBattery.toString());
        return lvlBattery;
    }
    // Récupére le temps en ms de raffraichissement en fonction de l'Utilisateur et du niveau de battery.
    public static Long getTempsRafraichissement(Context context){
        // Temps Min Utilisateur et 10s (temps max utiliseur + modificateur quand la battery et tres faible)
        Long tempsRafraichissement = GlobalVariable.getInstance().getConnectedUtilisateur().getFrequenceDeplacement()*1000;
        // Récupére le poucentage de battery actuellement possédé.
        Integer lvlBattery = getBattery(context) / 100;

        tempsRafraichissement = 2*tempsRafraichissement - (5000 * lvlBattery);
        Log.i("LPK_Temps", tempsRafraichissement.toString());
        return tempsRafraichissement;
    }
}
