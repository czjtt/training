package test.Thread.threadLocal;

/**
 * ThreadLocal设计的初衷：提供线程内部的局部变量，在本线程内随时随地可取，隔离其他线程。
 * Created by tcc on 2017/7/6.
 */
public class IntegerThreadLocalUtil {

    private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
    private static Integer initConn = null;
    private static int a;
    static {
        initConn = a;
    }

    public Integer getConn(){
        Integer c = tl.get();
        if(null == c ){
            tl.set(initConn ++);
        }
        return tl.get();
    }

    public static void main(String[] args) {
        IntegerThreadLocalUtil integerThreadLocalUtil = new IntegerThreadLocalUtil();
        Integer con = integerThreadLocalUtil.getConn();
        Integer con2 = integerThreadLocalUtil.getConn();
        if(con == con2){
            System.out.println("eq true");
        }
        System.out.println("con:" + con +  ",con2:" + con2);
    }

}
