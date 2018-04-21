package test.Tools;

/**
 * 杭州税收
 *
 *  全月应纳税所得额	税率	速算扣除数（元）
 *  全月应纳税所得额不超过1500元	3%	0
 *  全月应纳税所得额超过1500元至4500元	10%	105
 *  全月应纳税所得额超过4500元至9000元	20%	555
 *  全月应纳税所得额超过9000元至35000元	25%	1005
 *  全月应纳税所得额超过35000元至55000元	30%	2755
 *  全月应纳税所得额超过55000元至80000元	35%	5505
 *  全月应纳税所得额超过80000元	45%	13505
 *
 * Created by tcc on 2017/9/26.
 */
public class Revenue {

    public static final double MONTH_INCOME_ONE = 1500;
    public static final double MONTH_INCOME_TWO = 4500;
    public static final double MONTH_INCOME_THREE = 9000;
    public static final double MONTH_INCOME_FOUR = 35000;
    public static final double MONTH_INCOME_FIVE = 55000;
    public static final double MONTH_INCOME_SIX = 80000;

    public static double calcRevenue(double salary){
        double revenue =  0;
        if(salary > MONTH_INCOME_SIX){
            revenue =  salary*0.45;
        }else if (salary > MONTH_INCOME_FIVE){
            revenue = salary*0.35;
        }else if(salary > MONTH_INCOME_FOUR){
            revenue = salary * 0.3;
        }else if(salary > MONTH_INCOME_THREE){
            revenue = salary * 0.25;
        }else if(salary > MONTH_INCOME_TWO){
            revenue = salary * 0.2;
        }else if(salary > MONTH_INCOME_ONE){
            revenue = salary * 0.1;
        }else {
            revenue = salary * 0.03;
        }
        return revenue;
    }



}
