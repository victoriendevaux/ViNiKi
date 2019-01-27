package viniki.ccm.insset.viniki;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class Login extends AppCompatActivity {

    TextView textTargetUri;
    ImageView targetImage;

    private EditText login;
    private EditText mdp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (EditText) findViewById(R.id.tb_login);
        mdp = (EditText) findViewById(R.id.tb_passwordLogin);
        BoiteAOutils.verifperm(this);
    }

    public void onClickInscription(View view) {
        Intent monIntent = new Intent(this, Inscription.class);
        startActivity(monIntent);
    }

    public void onClickTest(View view) {
//        Intent intent = new Intent(Intent.ACTION_PICK,
//                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivityForResult(intent, 0);
        Log.i("LPK_BATTERY_LVL", BoiteAOutils.getBattery(new Login()).toString());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            Uri targetUri = data.getData();
            textTargetUri.setText(targetUri.toString());
            Bitmap bitmap;
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                targetImage.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void onClickConnexion(View view) {
        BDDManager.loginUtilisateur(login.getText().toString(), BoiteAOutils.crypteMotDePasse(mdp.getText().toString()), this);
    }

    public void loginSuccess(){
        Toast.makeText(this, "Login succès !", Toast.LENGTH_SHORT).show();
        Intent monIntent = new Intent(this, ActivitePrincipale.class);
        startActivity(monIntent);
    }

    public void loginEchec(){
        Toast.makeText(this, "Vérifier les informations entrées.", Toast.LENGTH_SHORT).show();
    }
}
