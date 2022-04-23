package test.基础.transient关键字;

import lombok.ToString;
import org.apache.commons.io.IOUtils;
//import org.apache.poi.util.IOUtils;

import java.io.*;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/12 19:08
 */
//https://blog.csdn.net/u012723673/article/details/80699029
public class Java中transient关键字的详细总结2 {
    static String currentFolder = System.getProperty("user.dir") + "\\src\\main\\java\\test\\基础\\transient关键字\\";

    /**
     * 判断文件的编码格式
     *
     * @param fileName :file
     * @return 文件编码格式
     * @throws Exception
     */
    public static String codeString(File fileName) throws Exception {
        BufferedInputStream bin = new BufferedInputStream(
                new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        IOUtils.closeQuietly(bin);
        return code;
    }

    public static void main(String[] args) throws Exception {

        System.out.println(codeString(new File(currentFolder + "user2.txt")));

        User2 user2 = new User2();
        user2.setUsername("Alexia");
        user2.setPasswd("123456");

        System.out.println("read before Serializable");
        System.out.println("username:" + user2.getUsername());
        System.out.println("passwd:" + user2.getPasswd());

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(currentFolder + "user2.txt"));
            os.writeObject(user2); // 将User1对象写进文件
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 在反序列化之前改变username的值
            User2.username = "test";
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(currentFolder + "user2.txt"));
            user2 = (User2) is.readObject(); // 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable");
            System.out.println("username:" + user2.getUsername());
            System.out.println("passwd:" + user2.getPasswd());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

@ToString
class User2 implements Serializable {

    private static final long serialVersionUID = 5836939730322298392L;

    public static String username;
    private transient String passwd;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User2.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}