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

    public TimerModel timer = new TimerModel();

    public TimerManager(){
        timer = new TimerModel();
    }

    public void setCountdown(int secs){
        timer.setTimer(secs);
    }

    public String getTimeLeft(){
        return String.format("%d", timer.getTimer());
    }

    public void countdown(TimerModel timer){
        while (!timer.timerDone()){
            timer.setTimer(timer.getTimer()-1);
        }
    }






}
