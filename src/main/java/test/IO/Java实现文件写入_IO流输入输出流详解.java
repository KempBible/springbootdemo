package test.IO;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/12 13:32
 */
// https://blog.csdn.net/zch19960629/article/details/77917739?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0.pc_relevant_default&spm=1001.2101.3001.4242.1&utm_relevant_index=3
public class Java实现文件写入_IO流输入输出流详解 {

    @Test
    public void 如何获取文件信息() {
        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").getName()); //获取文件名称

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").getParent()); //获取文件的父路径字符串

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").getPath()); //获取文件的相对路径字符串

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").getAbsolutePath()); //获取文件的绝对路径字符串

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").exists()); //判断文件或者文件夹是否存在

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").isFile()); //判断是不是文件类型

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").isDirectory()); //判断是不是文件夹类型

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").mkdir()); //删除文件或文件夹，如果删除成功返回结果为true

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").setReadOnly()); //设置文件或文件夹的只读属性

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").length()); //获取文件的长度

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").lastModified()); //获取文件的最后修改时间

        System.out.println(new File("Java实现文件写入_IO流输入输出流详解.java").list()); //获取文件夹中的文件和子文件夹的名称，并存放到字符串数组中
    }

    /**
     * 在src根目录下创建FileInfo类，在该类的主方法中创建文件对象，通过File类的相关方法，获取文件的相关信息
     */
    @Test
    public void FileInfo() {
        String filePath = new File("Java实现文件写入_IO流输入输出流详解.java").getAbsolutePath();
        // 根据指定路径创建文件对象
        File file = new File(filePath);
        System.out.println("文件名称:" + file.getName());
        System.out.println("文件是否存在：" + file.exists());
        System.out.println("文件的相对路径：" + file.getPath());
        System.out.println("文件的绝对路径：" + file.getAbsolutePath());
        System.out.println("是否为可执行文件：" + file.canExecute());
        System.out.println("文件可以读取：" + file.canRead());
        System.out.println("文件可以写入：" + file.canWrite());
        System.out.println("文件上级路径：" + file.getParent());
        System.out.println("文件大小：" + file.length() + "B");
        System.out.println("文件最后修改时间：" + new Date(file.lastModified()));
        System.out.println("是否文件类型：" + file.isFile());
        System.out.println("是否为文件夹：" + file.isDirectory());
        // 在使用delete()方法删除File对象时，如果删除的对象是目录，该目录中的内容必须为空。
        System.out.println("删除文件夹：" + file.delete());
    }

    /**
     * 创建InputStream实例inp，并将其赋值为System类的in属性，定义为控制台输入流，从inp输入流中获取字节信息，
     * 用这些字节信息创建字符串，并将其在控制台上输出。
     */
    public static void main1(String[] args) {
        InputStream inputStream = System.in;
        byte[] bytes = new byte[1024];

        try {
            while (inputStream.read() != -1) {
                //根据用户输入的信息创建字符串
                String string = new String(bytes).trim();
                System.out.println(string);
            }
            inputStream.close(); //关闭流
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 创建OutputStream实例out,并将其赋值为System.out标准输出流。通过write()方法向流写入数据。
     *
     * @param args
     */
    public static void main(String[] args) {
        OutputStream outputStream = System.out; //实例化OutputStream对象

        Scanner scanner = new Scanner(System.in);

        byte[] bytes = "使用OutputStream输出流在控制台输出字符串\n".getBytes(); //创建bytes数组

        try {
            outputStream.write(bytes);
            bytes = "输出内容：\n".getBytes();
            outputStream.write(bytes); //向流中写入数据
            boolean flag = true;
            while (scanner.hasNext() && flag) {
                String context = scanner.next();
                if ("exit".equals(context)) {
                    System.exit(0);
                }
                outputStream.write(context.getBytes());
            }
            outputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    String currentFolder = System.getProperty("user.dir") + "\\src\\main\\java\\test\\IO\\";

    /**
     * 创建OutputStream实例out,并将其赋值为System.out标准输出流，通过write方法向流中写入数据
     */
    @Test
    public void FileCreate() {
        File file = new File(currentFolder, "word.txt"); //创建文件对象
        System.out.println(file.getAbsolutePath());

        try {
            if (!file.exists()) {
                file.createNewFile(); //如果文件不存在则新建文件
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bytes = "Java数据交流管道——IO流".getBytes();
            fileOutputStream.write(bytes); //将数组的信息写入文件中
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = fileInputStream.read(bytes);
            System.out.println("文件中的信息是:" + new String(bytes, 0, len));
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FileInAndOut() {
        //定义指定磁盘的文件的File对象
        File file = new File(currentFolder + "Java实现文件写入_IO流输入输出流详解.java");
        System.out.println(file);

        if (!file.exists()) {
            System.out.println("对不起，不包含指定路径的文件");
        } else {
            //根据指定路径的File对象创建FileReader对象
            try {
                FileReader fileReader = new FileReader(file);
                char[] data = new char[1024]; //定义char数组
                int length = 0;

                while ((length = fileReader.read(data)) > 0) { //循环读取文件中的数据
                    String string = new String(data, 0, length); //根据读取文件的内容创建String 对象
                    System.out.println(string); //输出读取内容
                }
                fileReader.close(); //关闭流
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void FileWriterDemo() {
        File file = new File(currentFolder, "text2.txt"); //创建文件对象

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader fileReader = new FileReader(currentFolder + "Java实现文件写入_IO流输入输出流详解.java");
            FileWriter fileWriter = new FileWriter(file);

            int length = 0;
            while ((length = fileReader.read()) != -1) {
                fileWriter.write(length);
            }
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Java IO流实现复制文件夹
     * 通过IO不仅可以复制文件，还可以复制文件夹，但是文件夹内，可能包含其他文件夹，因此需要对他们进行分别复制。
     */
    @Test
    public void CopyFile() {
        File sourceFile = null;
        File desFile = null;

        String sourceFolder = currentFolder + "被复制文件夹";
        String copyFolder = currentFolder + "复制目的文件夹";
        System.out.println(sourceFolder);
        System.out.println(copyFolder);

        sourceFile = new File(sourceFolder);
        if (!sourceFile.isDirectory() || !sourceFile.exists()) {
            System.out.println("源文件夹不存在!");
        } else {
            desFile = new File(copyFolder);
            copy(sourceFile.listFiles(), desFile);
            System.out.println("文件夹复制成功");
        }
    }

    /**
     * 创建copy方法，该方法接收文件数组和目标文件夹两个参数，如果目标文件夹不存在，则调用mkdir（）方法创建文件夹，然后再循环中将文件数组
     * 中的每个文件对象写到目标文件夹内。
     *
     * @param listFiles
     * @param desFile
     */
    private void copy(File[] listFiles, File desFile) {
        if (!desFile.exists()) { // 如果文件夹不存在
            desFile.mkdir(); // 建立新的文件夹
        }

        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) { // 如果是文件类型，则复制文件
                try {
                    FileInputStream fileInputStream = new FileInputStream(listFiles[i]);
                    FileOutputStream fileOutputStream = new FileOutputStream(new File(desFile.getPath() + File.separator + listFiles[i].getName()));

                    int count = fileInputStream.available();
                    byte[] data = new byte[count];

                    if ((fileInputStream.read(data)) != -1) {
                        fileOutputStream.write(data);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (listFiles[i].isDirectory()) { // 如果是文件夹类型
                    File des = new File(desFile.getPath() + File.separator + listFiles[i].getName());
                    des.mkdir(); // 在目标文件夹中创建相同的文件夹
                    copy(listFiles[i].listFiles(), des); // 递归调用方法本身
                }
            }
        }
    }

    /**
     * Java IO流实现分行向文件中写入数据
     * FileWriter类可以向文件写入字符数据，如果将FileWriter类封装到BufferWriter类的缓冲字符流中，能够实现缓冲字符输出流，并且可以通过读输出流的newLine()方法，来实现数据的分行写入。
     */
    @Test
    public void BranchWriter() {

        String filePath = currentFolder + "text3.txt";
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file); // 创建文件输出流

            BufferedWriter bw = new BufferedWriter(fw); // 使用缓冲区数据流封装输出流
            for (int i = 0; i < 100; i++) {
                bw.write("Java交互管道——IO流".toCharArray());
                bw.newLine();
                bw.flush();
            }
            System.out.println("成功写入数据");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定文件
     * File类的delete()方法可以实现删除指定的文件，首先使用目标文件路径创建File类的实例对象，然后再调用File类的delete()方法。
     */
    @Test
    public void FileDelete() {
        String filePath = currentFolder + "text3.txt";

        File file = new File(filePath);
        delFile(file);
    }

    private static void delFile(File file) {
        if (!file.exists()) {
            System.out.println("文件不存在！");
            return;
        }
        boolean rs = file.delete();
        if (rs) {
            System.out.println("文件删除成功！");
        } else {
            System.out.println("文件删除失败!");
        }
    }

}