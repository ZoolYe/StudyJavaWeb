package zool.property;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Properties;

@Data
public class Person {

    private String pname;

    private String[] arrs;

    private List<String> list;

    private Map<String,String> map;

    private Properties properties;

    public void test1(){
        System.out.println("arrs: "+arrs);
        System.out.println("list: "+list);
        System.out.println("map: "+map);
        System.out.println("properties: "+properties);
    }

}
