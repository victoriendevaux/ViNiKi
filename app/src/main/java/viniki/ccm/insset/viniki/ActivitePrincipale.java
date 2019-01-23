package viniki.ccm.insset.viniki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivitePrincipale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activite_principale);
        Log.i("LPK_LOK_Listener", "AvantStart");
        startService(new Intent(this, GPSLocalisationService.class));
        Log.i("LPK_LOK_Listener", "ApresStart");
//        GPSLocalisationService.setActiviteMap(null);

    }

    public void onClickDeconnexion(View view) {
        // Stop Service
        stopService(new Intent(this, GPSLocalisationService.class));
        // Clear GV
        BDDManager.logoutUtilisateur();
        GlobalVariable.getInstance().setConnectedUtilisateur(new Utilisateur());

        Intent monIntent = new Intent(this, Login.class);
        startActivity(monIntent);
    }
}
