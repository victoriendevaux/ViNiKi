package viniki.ccm.insset.viniki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inscription extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText email;
    private EditText adresse;
    private EditText dateNaissance;
    private EditText mdp;
    private EditText reMdp;

    private static Utilisateur newUtilisateur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        nom = (EditText) findViewById(R.id.tb_nom);
        prenom = (EditText) findViewById(R.id.tb_prenom);
        email = (EditText) findViewById(R.id.tb_email);
        adresse = (EditText) findViewById(R.id.tb_adresse);
        dateNaissance = (EditText) findViewById(R.id.tb_dateNaissance);
        mdp = (EditText) findViewById(R.id.tb_passwordLogin);
        reMdp = (EditText) findViewById(R.id.tb_repassword);
    }

    public void onClickLogin(View view) {
        Intent monIntent = new Intent(this, Login.class);
        startActivity(monIntent);
    }

    public void onClickEnregistrerInscription(View view) {
        BDDManager.emailExiste(email.getText().toString(), this);
    }

    public void emailCheck(){

        if(mdp.getText().toString().equals(reMdp.getText().toString())){

            newUtilisateur = new Utilisateur();
            newUtilisateur.setNomUtilisateur((nom.getText()).toString());
            newUtilisateur.setPrenomUtilisateur((prenom.getText()).toString());
            newUtilisateur.setEmailUtilisateur((email.getText()).toString());
            newUtilisateur.setAdresseUtilisateur((adresse.getText()).toString());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try{
                Date dateN = format.parse((dateNaissance.getText()).toString());
                newUtilisateur.setDateNaissanceUtilisateur(dateN);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            BDDManager.addUtilisateur(newUtilisateur, BoiteAOutils.crypteMotDePasse(mdp.getText().toString()), this);
        }else {
            Toast.makeText(this, "Le mot de passe et la vérification doivent être identique.", Toast.LENGTH_SHORT).show();
        }
    }

    public void emailUncheck(){
        Toast.makeText(this, "L'email est déja enregistré.", Toast.LENGTH_SHORT).show();
    }

    public void inscriptionSuccess(String idUtilisateur) {

        newUtilisateur.setIdUtilisateur(idUtilisateur);
        newUtilisateur.setMaLocalisation(new Localisation());

        GlobalVariable.getInstance().setConnectedUtilisateur(newUtilisateur);

        Toast.makeText(this, "Inscription terminée !", Toast.LENGTH_SHORT).show();
        Intent monIntent = new Intent(this, ActivitePrincipale.class);
        startActivity(monIntent);
    }

    public void inscriptionEchec(){
        Toast.makeText(this, "Une erreur est survenue.", Toast.LENGTH_SHORT).show();
    }
}
