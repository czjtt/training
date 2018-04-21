package test.Thread.volatilePackage.features;

import test.Date.DateUtils;
import java.util.Date;

/**
 * Created by tcc on 2018/2/13.
 */
public class Game {

    public static void main(String[] args) throws InterruptedException {
        // Game begun! Init goalNotifier thread
        GoalNotifier goalNotifier = new GoalNotifier();
        Thread goalNotifierThread = new Thread(goalNotifier);
        goalNotifierThread.start();
        System.out.println(DateUtils.formatDate(new Date(), "Y-m-d HH:dd:ss") + " starting ... ");

        // After 3s
        Thread.sleep(3000);
        // Goal !!!
        goalNotifier.setGoal(true);

        Thread.sleep(2000);

//        goalNotifier.setVolatileGoal(2);
    }

}