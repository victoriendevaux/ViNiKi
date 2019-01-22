package viniki.ccm.insset.viniki.parametre;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import viniki.ccm.insset.viniki.BDDManager;
import viniki.ccm.insset.viniki.R;

public class ActiviteParametre extends AppCompatActivity {

    private Intent intentEmail = getIntent();
    private EditText parametreNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activite_parametre);

        BDDManager.deplacementParametreUser("test",this);
    }

    public void notificationDeplacement(String deplacement) {
        Integer tempsNotificationDeplacement = Integer.valueOf(deplacement);
        parametreNotification = (EditText) findViewById(R.id.tbParametre);
        parametreNotification.setText("" + tempsNotificationDeplacement);
    }

    public void onClickUpdateDeplacement(View view)
    {
        parametreNotification = (EditText) findViewById(R.id.tbParametre);
        BDDManager.updateNotification(parametreNotification.getText().toString());
    }
}
