package test.somethingtest;

import java.time.Instant;
import java.util.Random;

/**
 * Created by tcc on 2017/5/27.
 */
public class keywordTest {

    public static void main(String[] args) {
//        Map<String,Integer> map = new HashMap<>();
//        map.put("a",1);
//        map.put("b",1);
//        map.put("c",1);
//        map.put("d",1);
//        map.remove("e");
//        MathTest();
        instantTest();
    }

    public static void MathTest(){
        double ma = Math.random();

        Random random = new Random();
        int ra = random.nextInt();
        long rb = random.nextLong();

        System.out.println(ma);
        System.out.println(ra);
        System.out.println(rb);

    }

    public static void instantTest(){
        System.out.println(Instant.now());
    }
}
