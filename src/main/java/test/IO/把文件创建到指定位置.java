package test.IO;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 创建OutputStream实例out,并将其赋值为System.out标准输出流，通过write方法向流中写入数据
 *
 * @author zch
 */
public class 把文件创建到指定位置 {

    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\test\\IO\\", "word.txt");  //创建文件对象

        try {
            if (!file.exists()) {                //如果文件不存在则新建文件
                file.createNewFile();
            }
            FileOutputStream output = new FileOutputStream(file);
            byte[] bytes = "Java数据交流管道——IO流".getBytes();
            output.write(bytes);                //将数组的信息写入文件中
            output.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            FileInputStream input = new FileInputStream(file);
            byte[] bytes2 = new byte[1024];
            int len = input.read(bytes2);
            System.out.println("文件中的信息是：" + new String(bytes2, 0, len));
            input.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


