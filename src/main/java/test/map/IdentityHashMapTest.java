package test.map;

import java.util.IdentityHashMap;
import java.util.Set;

/**
 * identityHashMap
 * 改map的key是按照引用来区分是否重复的。
 * Created by tcc on 2017/9/20.
 */
public class IdentityHashMapTest {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        IdentityHashMap map = new IdentityHashMap();
        map.put("126","11");
        map.put("126","12");
        map.put("128","21");
        map.put("128","22");
        map.put("c","31");
        map.put("c","32");
        Set<Object> keySet = map.keySet();
        for(Object key : keySet){
            System.out.println(map.get(key));
        }
    }

    public static void keyHashCodeValueTest(){

    }
}
