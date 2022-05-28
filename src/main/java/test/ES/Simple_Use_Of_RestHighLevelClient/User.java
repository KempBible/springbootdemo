package test.ES.Simple_Use_Of_RestHighLevelClient;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String name;
    private String sex;
    private int age;
}