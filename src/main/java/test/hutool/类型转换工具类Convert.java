package test.hutool;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//https://www.hutool.cn/docs/#/core/%E7%B1%BB%E5%9E%8B%E8%BD%AC%E6%8D%A2/%E7%B1%BB%E5%9E%8B%E8%BD%AC%E6%8D%A2%E5%B7%A5%E5%85%B7%E7%B1%BB-Convert?id=%e7%b1%bb%e5%9e%8b%e8%bd%ac%e6%8d%a2%e5%b7%a5%e5%85%b7%e7%b1%bb-convert
public class 类型转换工具类Convert {

    public static void main(String[] args) {
        // 转换为字符串
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);
        System.out.println(aStr);

        long[] b = {1,2,3,4,5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);
        System.out.println(bStr);
    }

    @Test
    public void 转换为指定类型数组(){
        String[] b = {"1", "2", "3", "4"};
        //结果为Integer数组
        Integer[] intArr = Convert.toIntArray(b);
        System.out.println(Arrays.toString(intArr));

        long[] c = {1,2,3,4,5};
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(c);
        System.out.println(Arrays.toString(intArray));

        System.out.println(Convert.toCollection(List.class, String.class, b));;
    }

    @Test
    public void 转换为日期对象(){
        String a = "2017-05-06";
        Date date = Convert.toDate(a);
        System.out.println(date);
    }

    @Test
    public void 转换为集合(){
        Object[] a = {"a", "你", "好", "1"};

        List<?> list = Convert.convert(List.class, a);
        System.out.println(list);

        System.out.println(Convert.toList(a));
    }

    @Test
    public void 泛型类型(){
        Object[] a = {"a", "你", "好", "1"};
        List<String> list = Convert.convert(new TypeReference<List<String>>() {
        }, a);
        System.out.println(list);
    }

    @Test
    public void 半角转全角(){
        String a = "123456789";
        //１２３４５６７８９
        System.out.println(Convert.toSBC(a));
    }

    @Test
    public void 全角转半角(){
        String a = "１２３４５６７８９";
        //123456789
        System.out.println(Convert.toDBC(a));
    }

    @Test
    public void 转为16进制Hex字符串(){
        String a = "我是一个小小的可爱的字符串";

        //结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
        String hex = Convert.toHex(a, CharsetUtil.CHARSET_UTF_8);
        System.out.println(hex);
    }

    @Test
    public void 将16进制Hex字符串转为普通字符串(){
        String b = "e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2";

        //结果："我是一个小小的可爱的字符串"
        String hex = Convert.hexToStr(b, CharsetUtil.CHARSET_UTF_8);
        System.out.println(hex);
    }

    @Test
    public void Unicode和字符串转换(){
        String a = "我是一个小小的可爱的字符串";

        //结果："\u6211\u662f\u4e00\u4e2a\u5c0f\u5c0f\u7684\u53ef\u7231\u7684\u5b57\u7b26\u4e32"
        String unicode = Convert.strToUnicode(a);
        System.out.println(unicode);
        //我是一个小小的可爱的字符串
        System.out.println(Convert.unicodeToStr(unicode));
    }

    @Test
    public void 编码转换(){
        String a = "我不是乱码";

        //结果："æä¸æ¯ä¹±ç "
        String result = Convert.convertCharset(a, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        System.out.println(result);

        String raw = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, CharsetUtil.UTF_8);
        //我不是乱码
        System.out.println(raw);
    }

    @Test
    public void 时间单位转换(){
        long a = 4535345;

        //结果：75
        long minutes = Convert.convertTime(a, TimeUnit.MILLISECONDS, TimeUnit.MINUTES);
        System.out.println(minutes);
    }

    @Test
    public void 金额大小写转换(){
        double a = 67556.3211;

        String digitUppercase = Convert.digitToChinese(a);
        System.out.println(digitUppercase);
    }

    @Test
    public void 数字转换(){
        //TWELVE THOUSAND THREE HUNDRED AND FORTY FIVE ONLY
        String format = Convert.numberToWord(123.45);
        System.out.println(format);

        //数字简化
        String numberToSimple = Convert.numberToSimple(123.45);
        //123
        System.out.println(numberToSimple);

        String numberToChinese = Convert.numberToChinese(123.45, true);
        //壹佰贰拾叁点肆伍
        System.out.println(numberToChinese);


        String numberToChineseFalse = Convert.numberToChinese(123.45, false);
        //数字转中文
        //一百二十三点四五
        System.out.println(numberToChineseFalse);

        int f1 = Convert.chineseToNumber("壹佰贰拾叁");
        //数字中文表示转换为数字
        //123
        System.out.println(f1);
    }

    @Test
    public void 原始类和包装类转换(){
        //去包装
        Class<?> wrapClass = Integer.class;

        Class<?> unWraped = Convert.unWrap(wrapClass);
        //结果为：int
        System.out.println(unWraped);

        //包装
        Class<?> primitiveClass = long.class;

        Class<?> wraped = Convert.wrap(primitiveClass);
        //结果为：class java.lang.Long
        System.out.println(wraped);
    }
}
