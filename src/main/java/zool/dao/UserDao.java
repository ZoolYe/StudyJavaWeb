package zool.dao;

import java.io.FileInputStream;
import java.util.Properties;

/*如果读取资源文件的程序不是servlet的话，就只能通过类装载器去读取了*/
public class UserDao {

    private static Properties dbConfig = new Properties();

    static{
        try {

            /*InputStream inputStream = UserDao.class.getClassLoader().getResourceAsStream("db.properties");
            dbConfig.load(inputStream);*/
        }catch (Exception e){
            /*中断异常*/
            throw new ExceptionInInitializerError(e);
        }
    }

    public void update(){

        try {

            String path = UserDao.class.getClassLoader().getResource("db.properties").getPath();
            FileInputStream fis = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fis);
            System.out.println(properties.getProperty("url"));

        }catch (Exception e){
            throw  new ExceptionInInitializerError(e);
        }

    }

}
