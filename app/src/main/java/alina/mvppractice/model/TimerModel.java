package alina.countdownmvp;

/**
 * Created by Alina on 9/1/2018.
 */

public class TimerModel {

    private int secs;
    private int mins;
    private int hours;

    public TimerModel(){
        this.secs = 0;
        this.mins = 0;
        this.hours = 0;
    }


    public void setTimer(int hours, int mins, int secs){
        this.secs = secs;
        this.mins = mins;
        this.hours = hours;
    }

    public String getTimer(){
        return String.format ("%d:%d:%d", hours, mins, secs);
    }

    public void tickDown(){
        while (hours+mins+secs != 0){
            if (secs > 0){
                this.secs -= 1;
            }
            else{
                if (mins > 0){
                    this.mins -= 1;
                    this.secs = 59;
                }
                else{
                    this.hours -= 1;
                    this.mins = 59;
                    this.secs = 59;
                }
            }
        }
    }

    public Boolean timerDone(){
        if (hours+mins+secs == 0){
            return true;
        }
        return false;
    }
}
