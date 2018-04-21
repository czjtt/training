package test.arithmetic;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;

/**
 * Created by tcc on 2017/8/23.
 */
public class shiroSimpleMd5 {

    private static final String RANDOM_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        shiroSimpleMd5.md5();
    }

    public static void md5(){
        String password = "123456789";
        String salt = getRandomStr(6);
        String pw = new Md5Hash(password, salt).toString();
        System.out.println("pw:" + pw + ",salt:" + salt);
    }

    /**
     *
     * @param length 表示生成字符串的长度
     * @return
     */
    public static String getRandomStr(int length) {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(RANDOM_CHAR.length());
            sb.append(RANDOM_CHAR.charAt(number));
        }
        return sb.toString();
    }
}
