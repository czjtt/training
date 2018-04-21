package test.sql.mysql;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by tcc on 2017/10/23.
 */
public class Connect {

    public static void main(String[] args) {
        try {
            Connect.conn(null,null,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void conn(Method m, Object clazz, Object[] args) throws Exception{
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/springboot";
        String user="root";
        String password="123456";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            m.invoke(clazz, args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }
}
