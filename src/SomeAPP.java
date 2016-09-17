import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Matthew on 17/09/2016.
 */
public class SomeAPP {

    private boolean flag = false;
    private TimerTask task;
    private Timer timer;

    private static int TIMEOUT = 2000;


    public static void  main(String[] args){
        SomeAPP app = new SomeAPP();
    }

    public SomeAPP(){
        resetTimer();
        loop();
    }

    private void loop(){
        while(true){
            if(!isFlag()){
                continue;
            }
            dosomething();
            setFlag(false);

        }
    }

    private void dosomething(){
        System.out.println("Timer timed out!");
        resetTimer();
    }

    private void resetTimer(){
        if(timer == null){
            timer = new Timer();
        }
        try{
            task.cancel();
        }catch (NullPointerException e){

        }

        task = new TimerTask() {
            int count = TIMEOUT;
            @Override
            public void run() {
                count --;
                if(count == 0){
                    setFlag(true);
                }
            }
        };
        timer.schedule(task,0,1); //delay 0 , run every 1 second
    }

    public synchronized boolean isFlag() { //HAS TO BE SYNCHRONIZED, OR NOTHING WORKs
        return flag;
    }

    public synchronized void setFlag(boolean flag){
        this.flag = flag;
    }
}
