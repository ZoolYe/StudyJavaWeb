package zool.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

    //属性名和数据库表的字段对应
    private int id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private String country;
    private String province;
    private String city;
    private String area;
    private String street;
    private String address;
    private String provincialcertificate;
}
