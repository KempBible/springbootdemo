package test.基础.transient关键字;

import lombok.Data;

import java.io.*;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/12 19:08
 */
//https://blog.csdn.net/u012723673/article/details/80699029
public class Java中transient关键字的详细总结1 {
    static String currentFolder = System.getProperty("user.dir") + "\\src\\main\\java\\test\\基础\\transient关键字\\";

    public static void main(String[] args) {
        User1 user1 = new User1();
        user1.setUsername("Alexia");
        user1.setPasswd("123456");

        System.out.println("read before Serializable");
        System.out.println("username:" + user1.getUsername());
        System.out.println("passwd:" + user1.getPasswd());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(currentFolder + "user1.txt"));
            os.writeObject(user1); // 将User1对象写进文件
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(currentFolder + "user1.txt"));
            user1 = (User1) is.readObject(); // 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable");
            System.out.println("username:" + user1.getUsername());
            System.out.println("passwd:" + user1.getPasswd());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class User1 implements Serializable {

    private static final long serialVersionUID = 4310736271350407327L;

    private String username;
    private transient String passwd;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}