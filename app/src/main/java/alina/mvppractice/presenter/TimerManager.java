package alina.mvppractice.presenter;


import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import alina.mvppractice.R;
import alina.mvppractice.model.TimerModel;
import alina.mvppractice.view.MainActivity;

/**
 * Created by Alina on 9/1/2018.
 */

public class TimerManager {

    TimerModel timer = new TimerModel();

    Context mainActivityContext;
    public TimerManager (Context mainActivityContext){
        this.mainActivityContext = mainActivityContext;
    }

    public TimerManager(){
        timer = new TimerModel();
    }

    public void setCountdown(int secs){
        /* This is a null object reference */
        EditText textTimer =  (EditText)((Activity)mainActivityContext).findViewById(R.id.textTimer);
        timer.setTimer(secs);
        textTimer.setText(timer.getTimer());
    }

    public void setText(){
        EditText textTimer = (EditText)((Activity)mainActivityContext).findViewById(R.id.textTimer);
        textTimer.setText("Hello");
    }

    public void countdown(TimerModel timer){
        EditText textTimer =  (EditText)((Activity)mainActivityContext).findViewById(R.id.textTimer);
        while (!timer.timerDone()){
            timer.setTimer(timer.getTimer()-1);
            textTimer.setText(timer.getTimer());
        }
        textTimer.setText("Timer Done!");
    }




}
