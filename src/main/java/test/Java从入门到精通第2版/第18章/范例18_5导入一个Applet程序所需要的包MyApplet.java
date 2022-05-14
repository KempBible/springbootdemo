package test.Java从入门到精通第2版.第18章;

//https://weread.qq.com/web/reader/34332dd05b1f6e3431a8f7ck3c5327902153c59dc0488e1

import java.applet.Applet;
import java.awt.*;

public class 范例18_5导入一个Applet程序所需要的包MyApplet extends Applet {
    @Override
    public void paint(Graphics g) {
        g.drawString("hi，world", 30, 30); //输出一行字
        g.drawLine(50,50,100,100); //画一条线
    }
}
