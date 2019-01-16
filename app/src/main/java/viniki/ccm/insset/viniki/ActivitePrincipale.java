package viniki.ccm.insset.viniki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivitePrincipale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activite_principale);
    }

    public void onClickDeconnexion(View view) {
        BDDManager.logoutUtilisateur();
        Intent monIntent = new Intent(this, Login.class);
        startActivity(monIntent);
    }
}
