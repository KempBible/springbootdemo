package test.hutool.工具类;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

public class 字符串工具StrUtil {

    @Test
    public void removePrefixRemoveSuffix方法(){
        String fileName = StrUtil.removeSuffix("pretty_girl.jpg", ".jpg");
        //pretty_girl
        System.out.println(fileName);

        String fileName1 = StrUtil.removePrefixIgnoreCase("pretty_girl.jpg", "pretty");
        //_girl.jpg
        System.out.println(fileName1);
    }

    @Test
    public void sub方法(){
        String str = "abcdefgh";
        String strSub1 = StrUtil.sub(str, 2,3); //strSub1 -> c
        System.out.println(strSub1);
        String strSub2 = StrUtil.sub(str, 2,-3);
        //cde
        System.out.println(strSub2);
        String strSub3 = StrUtil.sub(str,3,2);
        //c
        System.out.println(strSub3);
    }

    @Test
    public void format方法(){
        String template = "{}爱{},就像老鼠爱大米";
        String str = StrUtil.format(template, "我","你");
        //我爱你,就像老鼠爱大米
        System.out.println(str);
    }
}
