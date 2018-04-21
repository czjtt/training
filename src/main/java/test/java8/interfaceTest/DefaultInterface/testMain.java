package test.java8.interfaceTest.DefaultInterface;

/**
 * Created by tcc on 2017/4/28.
 */
public class testMain {

    public static void main(String[] args){
        testMain m = new testMain();
        m.defaultInterface();

    }

    public void defaultInterface(){
        testDefaultInterface t = new testDefaultInterface() {
            @Override
            public double calculate(int a) {
                return sqrt(a*100);
            }
        };
        t.calculate(100);
        t.sqrt(16);
    }

}
