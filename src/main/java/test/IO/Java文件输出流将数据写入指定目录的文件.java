package test.IO;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 18:58
 */
// https://blog.csdn.net/Mr_DouDo/article/details/80323685?spm=1001.2101.3001.6650.6&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-6.pc_relevant_default&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7ERate-6.pc_relevant_default&utm_relevant_index=13
public class Java文件输出流将数据写入指定目录的文件 {

    // 方法一：自己写个输出流方法
    @Test
    public void writeToFile() {
        byte[] sourceByte = "可以把我写成方法的形参啊,然后就可以随意玩耍了".getBytes();
//        String path = "D:";
        String path = System.getProperty("user.dir");
        String fileName = "IO测试.txt";
        if (null != sourceByte) {
            try {
                File file = new File(path + fileName); //文件路径（路径+文件名）
                if (!file.exists()) {  //文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outputStream = new FileOutputStream(file); //文件输出流将数据写入文件
                outputStream.write(sourceByte);
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                // do something
            } finally {
                // do something
            }
        }
    }

    // 方法二：使用现成的库
    @Test
    public void writeToFileWithCommonsIO() {
//        String path = "D:";
        String path = System.getProperty("user.dir");
        String filename = "使用common-io库测试.txt";
        try {
            byte[] spurceBytes = "可以把我写成方法的形参啊,然后就可以随意玩耍了".getBytes();
            if (null != spurceBytes) {
                // 这里的false代表写入的文件是从头开始重新写入，或者理解为清空文件内容后重新写；若为true, 则是接着原本文件内容的结尾开始写
//                FileUtils.writeByteArrayToFile(new File(path + filename), spurceBytes, true);
                FileUtils.writeByteArrayToFile(new File(path + filename), spurceBytes, false);
            }

        } catch (UnsupportedEncodingException e) {
            // do something
        } catch (IOException e) {
            // do something
        } catch (Exception e) {
            // do something
        }
    }
}