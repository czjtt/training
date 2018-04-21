package test.jvm;

import org.yiyi.AchievaLogAnalysis.AnalysisLog;
import org.yiyi.AchievaLogAnalysis.AnalyzeLog;

/**
 * Created by czj on 2017/1/25.
 */
public class thread1 {

    public static void main(String[] args){
        thread1 t = new thread1();
        t.thread();
    }

    public void thread(){

        Thread t = new Thread();
        long s = 0l;
        long end = 0l;
        for(;;) {
            try {
                System.out.println("start sunday");
                AnalysisLog analysisLog = new AnalysisLog();
                s = System.currentTimeMillis();
                analysisLog.init();
                end = System.currentTimeMillis();
                System.out.println("sunday used time:" + (end-s) + "ms, sleep 10s");

                System.out.println("start string.indexof");
                AnalyzeLog analyzeLog = new AnalyzeLog();
                s = System.currentTimeMillis();
                analyzeLog.init();
                end = System.currentTimeMillis();
                System.out.println("string.index used time:" + (end-s) + "ms, sleep 10s");


                t.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
