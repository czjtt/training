package test.java8.interfaceTest.DefaultInterface;

/**
 * Created by tcc on 2017/4/28.
 */
public interface testDefaultInterface {

    double calculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
