package test.Tools.RadixConversion;

/**
 * 进制转换
 * 二进制是Binary，简写为B
 * 八进制是Octal，简写为O
 * 十进制为Decimal，简写为D
 * 十六进制为Hexadecimal，简写为H
 * Created by tcc on 2017/7/11.
 */
public class RadixConversion {

    public static final int BINARY = 2;
    public static final int OCTAL = 8;
    public static final int DECIMAL = 10;
    public static final int HEXADECIMAL = 16;

    public static int DecConvByBinary(String bin){
        return Integer.parseInt(bin, BINARY);
    }

    public static int DecConvByOctal(String oct){
        return Integer.parseInt(oct, OCTAL);
    }

    public static int DecConvByHex(String hex){
        return Integer.parseInt(hex, HEXADECIMAL);
    }

    public static void main(String[] args) {
        RadixConversion nbc = new RadixConversion();
        System.out.println(nbc.DecConvByBinary("10011000"));
        System.out.println(nbc.DecConvByHex("cc"));
        System.out.println(nbc.DecConvByOctal("3470"));
    }
}
