package alina.mvppractice.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import alina.mvppractice.R;
import alina.mvppractice.presenter.TimerManager;

public class MainActivity extends AppCompatActivity {

    public Button startTimer;
    public EditText textTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TimerManager timerManager = new TimerManager();

        /* Initialise Views */
        startTimer = (Button) findViewById(R.id.startTimer);
        textTimer = (EditText) findViewById(R.id.textTimer);

        startTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Hardcoded First
                //timerManager.setCountdown(100);
                timerManager.setText();
            }
        });
    }


}
