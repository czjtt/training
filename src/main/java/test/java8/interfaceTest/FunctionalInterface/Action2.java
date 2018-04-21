package test.java8.interfaceTest.FunctionalInterface;

/**
 * Created by tcc on 2017/5/3.
 */
@FunctionalInterface
public interface Action2<T,F> {

    public T run(F f);
}
