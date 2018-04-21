package test.jdk;

/**
 * hashCode是jdk根据对象的地址或者字符串或者数字算出来的int类型的数值 详细了解请 参考 [哈希码] public int hashCode()返回该对象的哈希码值。
 * 支持此方法是为了提高哈希表（例如 java.util.Hashtable 提供的哈希表）的性能。
 *
 * 一致性
 *      在 Java 应用程序执行期间，在对同一对象多次调用 hashCode 方法时，必须一致地返回相同的整数，前提是将对象进行hashcode比较时所用的信息没有被修改。
 * equals
 *      如果根据 equals(Object) 方法，两个对象是相等的，那么对这两个对象中的每个对象调用 hashCode 方法都必须生成相同的整数结果，注：这里说的equals(Object) 方法是指Object类中未被子类重写过的equals方法。
 *      如果两个hashCode()返回的结果相等，则两个对象的equals方法不一定相等。
 * 附加
 *      如果根据equals(java.lang.Object)方法，两个对象不相等，那么对这两个对象中的任一对象上调用 hashCode 方法不一定生成不同的整数结果。
 *      但是，程序员应该意识到，为不相等的对象生成不同整数结果可以提高哈希表的性能。
 *
 *
 * Created by tcc on 2017/12/4.
 */
public class hashcode {

    public static void main(String[] args) {
        simpleHashCodeTest();
//        equalTest();
    }

    /**
     * simple hashcode
     *
     * String   ASCII   a:97,b:98
     * Integer  值    i1:1,i2:2
     * Long  值    l1:1,l2:2
     * Short    值   s1:1,s2:2
     * Float  IEEE 754(IEEE二进位浮点数算术标准) 单精确度   f1:1065353216,f2:1073741824
     * Double  IEEE 754(IEEE二进位浮点数算术标准) 双精确度   d1:1072693248,d2:1073741824
     * Boolean  定值  true/Boolean.TRUE:1231,false/Boolean.FALSE:1237
     * Byte     值   byte1:1,byte2:2
     *
     * String "true":3569038,"false":97196323
     *
     */
    public static void simpleHashCodeTest(){
        String a = "a";
        String b = "b";
        Integer i1 = 1;
        Integer i2 = 2;
        Long l1 = 1L;
        Long l2 = 2L;
        Short s1 = 1;
        Short s2 = 2;
        Float f1 = 1F;
        Float f2 = 2F;
        Double d1 = 1.0;
        Double d2 = 2.0;
        Boolean bt1 = true;
        Boolean bt2 = Boolean.TRUE;
        Boolean bf1 = false;
        Boolean bf2 = Boolean.FALSE;
        String sb1 = "true";
        String sb2 = "false";
        Byte byte1 = -128;
        Byte byte2 = 127;



        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(i1.hashCode());
        System.out.println(i2.hashCode());
        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(f1.hashCode());
        System.out.println(f2.hashCode());
        System.out.println(d1.hashCode());
        System.out.println(d2.hashCode());

        System.out.println(bt1.hashCode());
        System.out.println(bt2.hashCode());
        System.out.println(bf1.hashCode());
        System.out.println(bf2.hashCode());
        System.out.println(sb1.hashCode());
        System.out.println(sb2.hashCode());

        System.out.println(byte1.hashCode());
        System.out.println(byte2.hashCode());
    }

    public static void equalTest(){
        Boolean b1 = true;
        Integer i1 = 1231;
        if(b1.hashCode() == i1.hashCode()){
            System.out.println("b1.hashCode == i1.hashCode");
        }
        Long l1 = 1065353216L;
        Float f1 = 1F;
        if(f1.hashCode() == l1.hashCode()){
            System.out.println("f1.hashCode == l1.hashCode");
        }
        if(f1.equals(l1)){
            System.out.println("equal");
        }
    }
}
