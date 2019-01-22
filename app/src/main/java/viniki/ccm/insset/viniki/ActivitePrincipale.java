package viniki.ccm.insset.viniki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import viniki.ccm.insset.viniki.parametre.ActiviteParametre;

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

    public void onClickParametre(View view)
    {
        //on recupere intent
        Intent intentEmail = getIntent();
        String email = intentEmail.getStringExtra("email");

        Intent monIntent = new Intent(this, ActiviteParametre.class);
        monIntent.putExtra("email", email);
        startActivity(monIntent);
    }

    /**
     * @return adresse email de la connexion
     */
    private String sessionEmail() {
        Intent intentEmail = getIntent();

        return intentEmail.toString();
    }
}
