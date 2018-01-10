package alina.mvppractice.model;

/**
 * Created by Alina on 9/1/2018.
 */

public class TimerModel {

    private int secs;

    public TimerModel(){
        this.secs = 0;
    }

    public void setTimer(int secs){
        this.secs = secs;
    }

    public int getTimer(){
        return this.secs;
    }


    public Boolean timerDone(){
        if (secs == 0){
            return true;
        }
        return false;
    }
}
