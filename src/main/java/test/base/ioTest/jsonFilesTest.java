package test.base.ioTest;

import net.sf.json.JSONArray;
import org.apache.commons.io.FileUtils;
//import org.json.JSONException;
//import org.json.JSONObject;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * lib/commons-io-2.6.jar
 * Created by czj on 2018/3/27.
 */
public class jsonFilesTest {

    public static void main(String[] args) {
        jsonFilesTest jfTest = new jsonFilesTest();
        try {
            jfTest.readJsonTxt();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 读取json格式数据
     * 转化为json对象并输出插入数据库表的sql语句
     * @throws IOException
     */
    public void readJsonTxt() throws IOException{
        File file = new File("D:\\local_workspace\\test\\io\\前端地区数据.txt");
//        String content= FileUtils.readFileToString(file,"gbk");
        String content= FileUtils.readFileToString(file,"utf-8");

        JSONObject jsonObject = JSONObject.fromObject(content);

        JSONArray jsonArray = (JSONArray) jsonObject.get("CityInfo");
//        JSONArray result = new JSONArray();
        System.out.println("insert into area (area_code, area_name, level, create_time) value");
        for(int i=0; i< jsonArray.size(); i++){
            pathRead(jsonArray.getJSONObject(i), null, null, 0);
        }
        System.out.println("json txt");

    }

    public void pathRead(JSONObject children, String value, String label, int level){
        if(!StringUtils.isEmpty(value)){
            value = value + "," + children.getString("value");
        }else {
            value = children.getString("value");
        }
        if(!StringUtils.isEmpty(label)){
            label = label + "-" + children.getString("label");
        }else {
            label = children.getString("label");
        }
        System.out.println("('" + value + "','" + label + "','" + level + "', now()),");
        if(children.get("children") != null){
            JSONArray jsonArray = children.getJSONArray("children");
            for(int i=0 ; i < jsonArray.size(); i++) {
                pathRead(jsonArray.getJSONObject(i), value, label, level + 1);
            }
        }
    }


}
