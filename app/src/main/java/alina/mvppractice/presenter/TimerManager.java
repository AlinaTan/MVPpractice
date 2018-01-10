package alina.countdownmvp;

/**
 * Created by Epistulis on 9/1/2018.
 */

public class TimerManager {

    TimerModel timer;
    TimerView view;

    public TimerManager(){
        timer = new TimerModel();
    }

    public void setCountdown(int hours, int mins, int secs){
        timer.setTimer(hours, mins, secs);
        timer.tickDown();
        if (timer.timerDone()){
            view.editTextTimer.setText("Timer Done!");
        }
    }



}
