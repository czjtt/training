package test.Thread.Timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by tcc on 2017/6/15.
 */
public class timerTaskTest {

    public static void main(String[] args) {
        timerTaskTest t1 = new timerTaskTest();
        t1.childtimetask();
    }

    public void childtimetask(){
        Timer timer = new Timer();
        timer.schedule(new MyTask(),1000,2000);
    }
}


class MyTask extends TimerTask{

    static int a = 0;
    @Override
    public void run() {
        a++;
        System.out.println("mytask run.a:" + a);
    }
}