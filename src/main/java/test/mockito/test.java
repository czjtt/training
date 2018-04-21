package test.mockito;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by tcc on 2017/11/3.
 */
public class test {

    @Test
    public void simpleTest(){

        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(0)).thenReturn("helloworld");

        String result = list.get(0);

        Mockito.verify(list).get(0);

        System.out.println(result);

        Assert.assertEquals("helloworld", result);
    }

    public static void main(String[] args){

    }
}
