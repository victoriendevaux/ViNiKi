package viniki.ccm.insset.viniki;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ActivitePrincipale extends AppCompatActivity {

    private TextView loginTextView, passwordTextView;
    private Button btn_connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activite_principale);
        /*loginTextView = findViewById(R.id.txt_login);
        passwordTextView = findViewById(R.id.txt_password);

        Log.i("victorien", "login :" + loginTextView + "mot de passe :" + passwordTextView);*/

        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        firebaseFirestore.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });

    }

    public void onClickDeconnexion(View view) {
        BDDManager.logoutUtilisateur();
        Intent monIntent = new Intent(this, Login.class);
        startActivity(monIntent);
    }
}
