package test.base.weakReference;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 通过WeakHashMap来理解弱引用会被jvm回收
 * WeakHashMap key(key不存在被引用的时候)随时会被回收.当没有任何引用指向key时，这条记录就会被回收掉。
 * 我们简单的设置key对象为null然后调用System.GC().让jvm来回收掉弱引用的值。
 *  String str = "abc" 跟 String Str = new String("abc") 的区别
 *  第一种属于编译时生成的字面量,会放入运行时常量池,这个区域的收回条件非常苛刻,所以一般不会被回收,所以哪怕不存在引用,WeakHashMap的这个key也不容易被回收
 *  第二种情况会放入堆内存,GC着重处理这个区
 * Created by tcc on 2017/7/7.
 */
public class WeakHashMapTest {

    static WeakHashMap<String,String> map = new WeakHashMap<>();

    static{
        map.put(new String("a"),new String("abc"));
        map.put(new String("b"),new String("abc"));
        map.put(new String("c"),new String("abc"));
        map.put(new String("d"),new String("abc"));
    }
    static WeakHashMap<String,String> map2 = new WeakHashMap<>();

    static{
        String a = new String("a");
        String b = new String("b");
        String c = new String("c");
        String d = new String("d");
        map2.put(a,new String("abc"));
        map2.put(b,new String("abc"));
        map2.put(c,new String("abc"));
        map2.put(d,new String("abc"));
    }

    static Map<String,String> whmap = new WeakHashMap<>();

    static{

        whmap.put("a","1");
        whmap.put("b","2");
        whmap.put("c","3");
    }

    public void MapTest() throws InterruptedException{
        WeakHashMap<String,String> map3 = new WeakHashMap<>();
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        map3.put(a,new String("abc"));
        map3.put(b,new String("abc"));
        map3.put(c,new String("abc"));
        map3.put(d,new String("abc"));
        WeakHashMap<Person,String> map4 = new WeakHashMap<>();
        Person p1 = new Person(1,"张三");
        Person p2 = new Person(2,"李四");
        map4.put(p1,"a");
        map4.put(p2,"b");
        WeakHashMap<String,String> map5 = new WeakHashMap<>();
        String aa = new String("a");
        String ba = new String("b");
        String ca = new String("c");
        String da = new String("d");
        map5.put(aa,new String("abc"));
        map5.put(ba,new String("abc"));
        map5.put(ca,new String("abc"));
        map5.put(da,new String("abc"));
        new Thread(()->{
            System.out.println("before gc map.size:" + map.size() + ",whmap.size:" + whmap.size() + ",map2.size:" + map2.size() + ",map3.size:" + map3.size() + ",map4.size:" + map4.size() + ",map5.size:" + map5.size());
            System.out.println("-------------------");
        }).start();
        TimeUnit.SECONDS.sleep(3);
        a = null;
        b = null;
        p1 = null;
        aa = null;
        System.gc();
        new Thread(() -> {
            System.out.println("after gc map.size:" + map.size() + ",whmap.size:" + whmap.size() + ",map2.size:" + map2.size() + ",map3.size:" + map3.size() + ",map4.size:" + map4.size() + ",map5.size:" + map5.size());
            System.out.println("-------------------");
        }).start();
    }

    public static void main(String[] args) {
        WeakHashMapTest weakHashMapTest = new WeakHashMapTest();
        try {
            weakHashMapTest.MapTest();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
