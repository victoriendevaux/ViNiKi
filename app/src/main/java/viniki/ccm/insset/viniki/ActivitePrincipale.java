package viniki.ccm.insset.viniki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActivitePrincipale extends AppCompatActivity {

    private TextView loginTextView, passwordTextView;
    private Button btn_connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activite_principale);
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

    public void onClickVoirMap(View view) {
        Intent monItent = new Intent(this, MapsActivity.class);
        startActivity(monItent);
    }
}
