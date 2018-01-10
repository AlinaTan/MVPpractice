package alina.countdownmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TimerView extends AppCompatActivity {

    /* Initialise Views */
    private Button setTimer;
    public EditText editTextTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_view);

        final TimerManager timerManager = new TimerManager();

        /* Initialise Views */
        setTimer = (Button) findViewById(R.id.setTimer);
        editTextTimer = (EditText) findViewById(R.id.timer);


        editTextTimer.setText(timerManager.timer.getTimer());

        setTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Hardcoded First
                timerManager.setCountdown(100, 0, 0);
            }
        });

    }


}
