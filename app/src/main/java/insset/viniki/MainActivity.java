package insset.viniki;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tv_battery;
    Runnable runnable;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_battery = (TextView) findViewById(R.id.tv_battery);

        runnable = new Runnable() {
            @Override
            public void run() {
                int level = (int) batteryLevel();
                tv_battery.setText("Battery :" + level + "%");

                if(level > 75)
                {
                    Log.i("batterie","batterie haute");
                }

                if(level <= 75 && level > 50)
                {
                    Log.i("batterie","batterie preque pleine ");
                }

                if(level <= 50 && level > 25)
                {
                    Log.i("batterie","batterie quasi faible");
                }

                if(level <= 25 && level > 1)
                {
                    Log.i("batterie","batterie  faible");
                }

                handler.postDelayed(runnable,5000);

            }
        };

        handler = new Handler();
        handler.postDelayed(runnable,0);
    }

    public float batteryLevel()
    {
        Intent batteryIntent = registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        int level = batteryIntent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale =  batteryIntent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        if(level == -1 || scale == -1)
            return 50.0f;

        return ((float) level / (float) scale) * 100f;
    }
}
