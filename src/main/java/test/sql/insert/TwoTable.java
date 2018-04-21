package test.sql.insert;

import test.sql.mysql.Connect;

/**
 * insert into table_a (a_id,value1) VALUES();
 * insert into table_b (a_id,value2) VALUES();
 * 实现批量生成以上两句sql语句 a_id自增，value1随机100~200，value2随机200~300
 *
 * 比较union 和union all 两者的速度 union会做一个去重，union all相对会更快些
 * SELECT t.id, t.a_id, sum(t.value1) AS value1, SUM(t.value2) AS value2
 * FROM (SELECT a.id,a.a_id,a.value1,0 AS value2 FROM table_a AS a
 * UNION
 * SELECT b.id,b.a_id,0 AS value1,b.value2 FROM table_b AS b) AS t
 * GROUP BY t.id, t.a_id
 *
 * Created by tcc on 2017/8/16.
 */
public class TwoTable {

    public static void main(String[] args) {
        try {
            Connect.conn(TwoTable.class.getDeclaredMethod("twoTableInsertSql",null), TwoTable.class,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TwoTable.twoTableInsertSql();
    }

    public static void twoTableInsertSql(){
//        int n = 100000;
        int n = 100;
        int as = 7;
        int bs = 90000;
        StringBuilder a = new StringBuilder("");
        StringBuilder b = new StringBuilder("");
        for(int i = as;i < n;i++){
            a.append("insert into table_a (a_id,value1) VALUES(");
            a.append(i);
            a.append(",");
            a.append(Math.random()*100 + 100);
            a.append(");");
        }
        for(int i = bs;i < n;i++){
            a.append("insert into table_b (a_id,value2) VALUES(");
            a.append(i);
            a.append(",");
            a.append(Math.random()*100 + 200);
            a.append(");");
        }
            System.out.println(a.toString());

    }
}
