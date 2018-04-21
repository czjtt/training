package test.Thread.volatilePackage.features;

import test.Date.DateUtils;

import java.util.Date;

/**
 * Created by tcc on 2018/2/13.
 */
public class GoalNotifier implements Runnable {
    public boolean goal = false;
//    private volatile int volatileGoal = 1;

//    public boolean isVolatileGoal() {
//        return volatileGoal == 2;
//    }
//
//    public void setVolatileGoal(int volatileGoal) {
//        this.volatileGoal = volatileGoal;
//    }

    public boolean isGoal() {
        return goal;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    @Override
    public void run() {
        System.out.println("Running...");
        while (true) {
            if (isGoal()) {
                System.out.println(DateUtils.formatDate(new Date(), "Y-m-d HH:dd:ss") + " Goal !!!!!!");

                // Tell the referee the ball is in.
                // ...

                // reset goal flag
                setGoal(false);
            }
//            if(isVolatileGoal()){
//                System.out.println(DateUtils.formatDate(new Date(), "Y-m-d HH:dd:ss") + " volatile Goal !!!!");
//                setVolatileGoal(1);
//            }
        }
    }
}