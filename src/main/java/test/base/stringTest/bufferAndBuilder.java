package test.base.stringTest;

/**
 * String,StringBuffer,StringBuilder三者的使用情况以及速度比较
 * Created by tcc on 2017/7/31.
 */
public class bufferAndBuilder {
    public static void main(String[] args) {
        bothTest();
    }

    /**
     * n:1000000,a:167904,b:12,c:26
     * 这种string拼接方式
     * stringBuilder是线程不安全，速度最快的。stringBuffer是线程安全的，速度第二的。string是最慢的。
     * 所以字符量比较少拼接的可以用string,量比较多的在单线程下尽量用stringBuilder,多线程就只能用stringBuffer了。
     */
    public static void bothTest(){
        String a = "a";
        StringBuilder b = new StringBuilder("b");
        StringBuffer c = new StringBuffer("c");
        int n = 1000000;
        long aTime = System.currentTimeMillis();
        for(int i =0;i<n;i++){
            a = a + "d";
        }
        aTime = System.currentTimeMillis() - aTime;
        long bTime = System.currentTimeMillis();
        for(int i =0;i<n;i++){
            b.append("e");
        }
        bTime = System.currentTimeMillis() - bTime;
        long cTime = System.currentTimeMillis();
        for(int i =0;i<n;i++){
            c.append("f");
        }
        cTime = System.currentTimeMillis() - cTime;

        System.out.println("circle count:" + n + "String:" + aTime + ",StringBuilder:" + bTime + ",StringBuffer:" + cTime);

    }

}
