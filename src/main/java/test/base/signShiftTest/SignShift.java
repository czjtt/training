package test.base.signShiftTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tcc on 2017/9/6.
 */
public class SignShift {

    private static final Logger log = LoggerFactory.getLogger("SignShift");

    public static void test(){
        Integer i = -14;
        int in = 1;
        System.out.printf("int i value:%s, i binary value:%s",i,Integer.toBinaryString(i));
        System.out.println();
        i = i >> in;
        System.out.printf("int i value:%s, i >> %s was :%s",i, in, Integer.toBinaryString(i));
        System.out.println();

        byte b = -127;
        int bn = 1;
        System.out.printf("byte b value : %s,byte b Integer.toBinaryString(Byte.toUnsignedInt(b)) value :%s", b, Integer.toBinaryString(Byte.toUnsignedInt(b)));
        System.out.println();
        int bi = Byte.toUnsignedInt(b) >> bn;
        System.out.printf("int bi value : %s,Byte.toUnsignedInt(%s) >> %s binary value : %s ", bi, b, bn, Integer.toBinaryString(bi));
        System.out.println();

        byte c = -100;
        int cn = 1;
        System.out.printf("byte c value : %s , byte c Integer.toBinaryString(Byte.toUnsignedInt(c)) value : %s ", c, Integer.toBinaryString(Byte.toUnsignedInt(c)));
        System.out.println();
        int ci = Byte.toUnsignedInt(c) >>> cn;
        System.out.printf("int ci value : %s, %s >>> %s binary value : %s",ci, c, cn, Integer.toBinaryString(ci));
        System.out.println();


    }

    public static void main(String[] args) {
        SignShift.test();
    }
}
