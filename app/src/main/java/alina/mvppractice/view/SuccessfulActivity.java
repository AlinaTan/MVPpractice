package alina.mvppractice.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import alina.mvppractice.R;
import alina.mvppractice.presenter.TimerManager;

public class SuccessfulActivity extends AppCompatActivity {

    public TextView timeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);

        final TimerManager timerManager = new TimerManager();

        timeLeft = (TextView) findViewById(R.id.successful);

        timeLeft.setText(timerManager.getTimeLeft());

    }

}
