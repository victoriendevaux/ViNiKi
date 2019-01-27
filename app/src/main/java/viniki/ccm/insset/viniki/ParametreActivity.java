package viniki.ccm.insset.viniki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ParametreActivity extends AppCompatActivity {

    // TODO : récupérer le globalVariable (Utilisateur) en Deplacement et frequence et les mettre dans les zone en valeur.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);
    }

    // TODO : onClickUpdate => récupérer frequence + distance :: cast en Long puis utilise BDDManager.updateParametresUtilisateur(frequence, distance);

}
