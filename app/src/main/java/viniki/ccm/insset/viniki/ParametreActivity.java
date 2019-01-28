package viniki.ccm.insset.viniki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParametreActivity extends AppCompatActivity {

    private EditText distanceET;
    private EditText tempsMaj;
    private TextView tempsMAJPosition;
    private TextView distanceTexte;
    protected long valeurDistance, baseDistance;
    protected  long valeurTempsMaj, baseTemspMaj;

    private static Utilisateur newData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametre);

        tempsMaj= (EditText) findViewById(R.id.majPositions);
        distanceET = (EditText) findViewById(R.id.distanceDeVue);
        tempsMAJPosition = (TextView) findViewById(R.id.textView2);
        distanceTexte = (TextView) findViewById(R.id.textView3);

        baseTemspMaj = GlobalVariable.getInstance().getConnectedUtilisateur().getFrequenceDeplacement();
        baseDistance = GlobalVariable.getInstance().getConnectedUtilisateur().getPorteeVisuel();

        tempsMAJPosition.setText("Temps de mise à jour des postions en seconde (entre 1 et 5) Actuel : "+baseTemspMaj);
        distanceTexte.setText("Distance maximum pour voire les autres (entre 100 et 1000) Actuel : "+baseDistance);

        tempsMaj.setText(String.valueOf(baseTemspMaj));
        distanceET.setText(String.valueOf(baseDistance));

//        Temps de mise à jour des postions en seconde (entre 1 et 5)

    }

    public void onClickUpdate(View view) {
        if(!tempsMaj.getText().toString().equals("") && !distanceET.getText().toString().equals("")){
            valeurTempsMaj = Long.parseLong(tempsMaj.getText().toString());
            valeurDistance = Long.parseLong(distanceET.getText().toString());
            if ((valeurDistance <= 1000 && valeurDistance >= 100) && (valeurTempsMaj <= 5 && valeurTempsMaj >= 1)){
                long frequence = valeurTempsMaj;
                long distance = valeurDistance;
                BDDManager.updateParametresUtilisateur(frequence, distance);
                Toast.makeText(this,  "Modification effectué.", Toast.LENGTH_LONG).show();
                Intent monItent = new Intent(this, ActivitePrincipale.class);
                startActivity(monItent);
            }else {
                Toast.makeText(this,  " L'une des valeurs saisie n'est pas bonne.", Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(this,  " L'une des valeurs saisie n'est pas bonne.", Toast.LENGTH_LONG).show();
        }
    }
}
