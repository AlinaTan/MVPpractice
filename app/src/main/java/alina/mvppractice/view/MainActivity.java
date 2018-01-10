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
    public Button setTimer;
    public EditText textTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TimerManager timerManager = new TimerManager();

        /* Initialise Views */
        startTimer = (Button) findViewById(R.id.startTimer);
        setTimer = (Button) findViewById(R.id.setTimer);
        textTimer = (EditText) findViewById(R.id.textTimer);

        setTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                timerManager.setCountdown(Integer.parseInt(textTimer.getText().toString()));
                textTimer.setText("Set Time!");
            }
        });

        startTimer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                timerManager.countdown(timerManager.timer);
                textTimer.setText(timerManager.getTimeLeft());
            }
        });
    }


}
