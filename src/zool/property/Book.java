package zool.property;

import lombok.Data;

@Data
public class Book {

    private String bookName;

    public void demoBook(){
        System.out.println("bookName: "+bookName);
    }

}
