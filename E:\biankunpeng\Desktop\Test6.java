package test.java方法工具.spring包方法;

import org.springframework.aop.support.AopUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.*;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.*;

import static org.junit.platform.commons.util.StringUtils.nullSafeToString;
import static org.springframework.util.Assert.*;
import static org.springframework.util.ObjectUtils.*;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/1 20:19
 */

/**
 * 别瞎写工具类了，Spring自带的不香吗？
 * https://mp.weixin.qq.com/s/6O0XlwqxaZxuTrSKGRxsNQ?st=B4FB84275A6F530FB881205AC9CFF48BE07738CDD0196A2BB5208EECF0F7D6D324C40AFCEB336C25751532CABD3719A2249CE3E0C42BF7528CA352EF9CE18315238F1DAA0FB2B98F8BDD71F953705FB8EF10F864920E09A663E8AC353F3C89ABBC62E12D77BBE617D650F344867269E3683DDDFE26B51FD08D0D374D76B6C459B6C2FA00384771B01F0FF716D927AA07D5544D2ABC7FFDFAB1B3146863322C5A762B1EA60D575E5847CA1EE0804AED9C14649E574EDA9161901795654ACF47EB965AF42A1595BCCEE4411C312C0CECE4&vid=1688850455067540&cst=CB86ED5D59A7FEEDC86090421FBA06BE99B8ACACABEF5EB87B81DD6417AA53BD50E50CEEB9455F0F413EF702222C8BD8&deviceid=5ce1062d-1166-43dd-8f89-73f2632c28f2&version=4.0.0.6007&platform=win
 */
@ComponentScan("test.test")
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class 别瞎写工具类了Spring自带的不香吗 extends FatherClass {

    public static void main(String[] args) throws IOException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        // *************************断 言*************************
        //// 要求参数 object 必须为非空（Not Null），否则抛出异常，不予放行
        //// 参数 message 参数用于定制异常信息。
//        notNull(null, "怎么是空的");
        notNull("", "空字符居然不是空的，让我想想为什么？");

        // 要求参数必须空（Null），否则抛出异常，不予『放行』。
        // 和 notNull() 方法断言规则相反
//        isNull("", "不空就会抛异常");
        isNull(null, "空的就正常");

        // 要求参数必须为真（True），否则抛出异常，不予『放行』。
//        isTrue(false, "必须为真,否则抛出异常");
        isTrue(true, "我常常用在判断真假中");

        // 要求参数（List/Set）必须非空（Not Empty），否则抛出异常，不予放行
        List<String> list1 = new ArrayList<>();
//        notEmpty(list1, "要是空就会抛出异常");
        list1.add("1");
        notEmpty(list1, "要是不空就正常运行");

        // 要求参数（String）必须有长度（即，Not Empty），否则抛出异常，不予放行
//        hasLength("", "第一个参数要是长度为0，就会抛出异常");
        hasLength("1", "第一个参数要是长度为0，就会抛出异常");

        // 要求参数（String）必须有内容（即，Not Blank），否则抛出异常，不予放行
//        hasText("", "第一个参数不能为Blank");
//        hasText(" ", "第一个参数不能为Blank");
        hasText(" 1", "第一个参数不能为Blank");

        // 要求参数是指定类型的实例，否则抛出异常，不予放行
//        isInstanceOf(String.class, 1, "类型指定错误");
//        isInstanceOf(null, "a", "类型指定错误");
        isInstanceOf(String.class, "a", "类型指定错误");
//        isInstanceOf(String.class, 100, "满意一百");
        isInstanceOf(String.class, "", "小样还制不了你");

        // 要求参数 `subType` 必须是参数 superType 的子类或实现类，否则抛出异常，不予放行
//        isAssignable(String.class, Integer.class, "你不是我的子类");
        isAssignable(Object.class, String.class, "你不是我的子类");
        isAssignable(Collection.class, ArrayList.class, "你不是我的子类");

        // *************************对象、数组、集合*************************
        System.out.println("------ObjectUtils------");
        // 获取对象的类名。参数为 null 时，返回字符串："null"
        System.out.println(nullSafeClassName("null"));
        System.out.println(nullSafeClassName(null));

        // 参数为 null 时，返回 0
        System.out.println(nullSafeHashCode(""));
        // ASII码
        System.out.println(nullSafeHashCode("a"));
        String str1 = null;
        System.out.println(nullSafeHashCode(str1));

        // 参数为 null 时，返回字符串："null"
        boolean[] bool = null;
        System.out.println(Arrays.toString(bool));
        System.out.println(nullSafeToString(bool));
        bool = new boolean[10];
        bool[0] = true;
        System.out.println(Arrays.toString(bool));
        System.out.println(nullSafeToString(bool));


        // 获取对象 HashCode（十六进制形式字符串）。参数为 null 时，返回 0
        System.out.println(getIdentityHexString(null));
        System.out.println(getIdentityHexString("a"));
        System.out.println(getIdentityHexString('a'));

        // 获取对象的类名和 HashCode。 参数为 null 时，返回字符串：""
        // null
        System.out.println(identityToString(null));
        // java.lang.Integer@97e1986
        System.out.println(identityToString(1));
        // java.lang.String@54a097cc
        System.out.println(identityToString("a"));

        // 相当于 toString()方法，但参数为 null 时，返回字符串：""
        System.out.println(getDisplayString(null));
        System.out.println(getDisplayString("null"));

        System.out.println("------判断工具------");
        // 判断数组是否为空
        String[] strArr1 = null;
        System.out.println(isEmpty(strArr1));
        strArr1 = new String[2];
        strArr1[0] = "a";
        System.out.println(isEmpty(strArr1));

        // 判断参数对象是否是数组
        System.out.println(isArray(1));
        String[] strArr2 = new String[2];
        System.out.println(isArray(strArr2));

        // 判断数组中是否包含指定元素
        String[] strArr3 = {"a", "b", "c"};
        System.out.println(containsElement(strArr3, "d"));
        System.out.println(containsElement(strArr3, "a"));

        // 相等，或同为 null时，返回 true
        String str2 = new String("a");
        String str3 = new String("b");
        String str4 = new String("a");
        System.out.println(nullSafeEquals(str2, str3));
        System.out.println(nullSafeEquals(str2, str4));
        // equals()与nullSafeEquals()的源码对比
        System.out.println(str2.equals(str4));

        /*
            判断参数对象是否为空，判断标准为：
                Optional: Optional.empty()
                   Array: length == 0
            CharSequence: length == 0
              Collection: Collection.isEmpty()
                 Map: Map.isEmpty()
         */
        System.out.println(isEmpty(""));
        System.out.println(isEmpty(null));
        System.out.println(isEmpty(new String[2]));
        System.out.println(isEmpty(new ArrayList<>()));
        System.out.println(isEmpty(new HashMap<>()));

        System.out.println("------其他工具方法------");
        // 向参数数组的末尾追加新元素，并返回一个新数组
        String[] strArr4 = {"a", "b", "c"};
        System.out.println(Arrays.toString(strArr4));
        System.out.println(Arrays.toString(addObjectToArray(strArr4, "d")));

        // 原生基础类型数组 --> 包装类数组
        int[] intArr1 = {1, 2, 3};
        System.out.println(Arrays.toString(intArr1));
        // 比较:intArr1和toObjectArray(intArr1)的方法，即可看出是否转换成包装型
        System.out.println(Arrays.toString(toObjectArray(intArr1)));


        System.out.println("------StringUtils------");
        // 判断字符串是否为 null，或 ""。注意，包含空白符的字符串为非空
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty("a"));

        // 判断字符串是否是以指定内容结束。忽略大小写
        String str5 = "abc";
        System.out.println(StringUtils.endsWithIgnoreCase(str5, "d"));
        System.out.println(StringUtils.endsWithIgnoreCase(str5, "c"));
        System.out.println(StringUtils.endsWithIgnoreCase(str5, "C"));

        // 判断字符串是否已指定内容开头。忽略大小写
        String str6 = "abc";
        System.out.println(StringUtils.startsWithIgnoreCase(str6, "d"));
        System.out.println(StringUtils.startsWithIgnoreCase(str6, "a"));
        System.out.println(StringUtils.startsWithIgnoreCase(str6, "A"));

        // 是否包含空白符
        String str7 = "abc";
        System.out.println(StringUtils.containsWhitespace(str7));
        str7 = "a b c";
        System.out.println(StringUtils.containsWhitespace(str7));

        // 判断字符串非空且长度不为 0，即，Not Empty
        String str8 = null;
        System.out.println(StringUtils.hasLength(str8));
        str8 = "";
        System.out.println(StringUtils.hasLength(str8));
        str8 = " ";
        System.out.println(StringUtils.hasLength(str8));
        str8 = "abc";
        System.out.println(StringUtils.hasLength(str8));

        // 判断字符串是否包含实际内容，即非仅包含空白符，也就是 Not Blank
        String str9 = null;
        System.out.println(StringUtils.hasText(str9));
        str9 = "";
        System.out.println(StringUtils.hasText(str9));
        str9 = " ";
        System.out.println(StringUtils.hasText(str9));
        str9 = "abc";
        System.out.println(StringUtils.hasText(str9));
        str9 = " abc";
        System.out.println(StringUtils.hasText(str9));

        // 判断字符串指定索引处是否包含一个子串。
        String str10 = "abc";
        String str11 = "ab";
        System.out.println(StringUtils.substringMatch(str10, 1, str11));
        System.out.println(StringUtils.substringMatch(str10, 0, str11));

        // 计算一个字符串中指定子串的出现次数
        String str12 = "abcabcac";
        String str13 = "ab";
        System.out.println(StringUtils.countOccurrencesOf(str12, str13));

        System.out.println("------字符串操作工具------");
        // 查找并替换指定子串
        System.out.println(StringUtils.replace("abc", "b", "123"));

        // 去除尾部的特定字符
        System.out.println(StringUtils.trimTrailingCharacter("abc", 'd'));
        System.out.println(StringUtils.trimTrailingCharacter("abc", 'c'));

        // 去除头部的特定字符
        System.out.println(StringUtils.trimLeadingCharacter("abc", 'd'));
        System.out.println(StringUtils.trimLeadingCharacter("abc", 'a'));

        // 去除头部的空白符
        System.out.println(StringUtils.trimLeadingWhitespace(" abc "));

        // 去除尾部的空白符
        System.out.println(StringUtils.trimTrailingWhitespace(" abc "));

        // 删除开头、结尾和中间的空白符
        System.out.println(StringUtils.trimAllWhitespace(" a b c "));

        // 删除指定子串
        System.out.println(StringUtils.delete("abc", "b"));

        // 删除指定字符（可以是多个）
        System.out.println(StringUtils.deleteAny("abc", "b"));
        System.out.println(StringUtils.deleteAny("abbbc", "b"));

        // 对数组的每一项执行 trim() 方法
        String[] strArr5 = {"a ", " b ", "c ", "d"};
        System.out.println(Arrays.toString(StringUtils.trimArrayElements(strArr5)));

        String source = "https://mp.weixin.qq.com/s/6O0XlwqxaZxuTrSKGRxsNQ?st=B4FB84275A6F530FB881205AC9CFF48BE07738CDD0196A2BB5208EECF0F7D6D324C40AFCEB336C25751532CABD3719A2249CE3E0C42BF7528CA352EF9CE18315238F1DAA0FB2B98F8BDD71F953705FB8EF10F864920E09A663E8AC353F3C89ABBC62E12D77BBE617D650F344867269E3683DDDFE26B51FD08D0D374D76B6C459B6C2FA00384771B01F0FF716D927AA07D5544D2ABC7FFDFAB1B3146863322C5A762B1EA60D575E5847CA1EE0804AED9C14649E574EDA9161901795654ACF47EB965AF42A1595BCCEE4411C312C0CECE4&vid=1688850455067540&cst=CB86ED5D59A7FEEDC86090421FBA06BE99B8ACACABEF5EB87B81DD6417AA53BD50E50CEEB9455F0F413EF702222C8BD8&deviceid=5ce1062d-1166-43dd-8f89-73f2632c28f2&version=4.0.0.6007&platform=win";
        // 将 URL 字符串进行解码
        System.out.println(StringUtils.uriDecode(source, Charset.defaultCharset()));

        System.out.println("------路径相关工具方法------");
        // 解析路径字符串，优化其中的 “..”
        System.out.println(StringUtils.cleanPath("D:\\workspace\\springbootdemo\\..\\java\\test\\test"));

        // 解析路径字符串，解析出文件名部分
        System.out.println(StringUtils.getFilename("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\多线程Thread.java"));

        // 解析路径字符串，解析出文件后缀名
        System.out.println(StringUtils.getFilenameExtension("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\多线程Thread.java"));

        // 比较两个两个字符串，判断是否是同一个路径。会自动处理路径中的 “..”
        System.out.println(StringUtils.pathEquals("D:\\workspace\\..\\Test.txt", "D:\\workspace\\Test.txt"));
        System.out.println(StringUtils.pathEquals("D:\\workspace\\..\\Test.txt", "D:\\workspace\\..\\Test.txt"));

        // 删除文件路径名中的后缀部分
        System.out.println(StringUtils.stripFilenameExtension("D:\\workspace\\Test.txt"));

        // 以 “. 作为分隔符，获取其最后一部分
        System.out.println(StringUtils.unqualify("D:\\workspace\\Test.txt"));

        // 以指定字符作为分隔符，获取其最后一部分
        System.out.println(StringUtils.unqualify("D:\\workspace\\Test.txt", '\\'));


        System.out.println("------CollectionUtils------");
        // 判断 List/Set 是否为空
        List<String> list2 = null;
        System.out.println(StringUtils.isEmpty(list2));
        list2 = new ArrayList<>();
        list2.add("a");
        System.out.println(StringUtils.isEmpty(list2));

        // 判断 Map 是否为空
        Map map1 = null;
        System.out.println(CollectionUtils.isEmpty(map1));
        map1 = new HashMap();
        map1.put("a", 1);
        System.out.println(CollectionUtils.isEmpty(map1));

        // 判断 List/Set 中是否包含某个对象
        ArrayList<Object> list = new ArrayList<>();
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1", 456);
        list.add(objectObjectHashMap);
        System.out.println(CollectionUtils.containsInstance(list, objectObjectHashMap));

        // 以迭代器的方式，判断 List/Set 中是否包含某个对象
        List<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        Iterator iterator1 = list3.iterator();
        System.out.println(CollectionUtils.contains(iterator1, "d"));
        Iterator iterator2 = list3.iterator(); // 注意这里为什么不用iterator1在判断一次
        System.out.println(CollectionUtils.contains(iterator2, "a"));

        // 判断 List/Set 是否包含某些对象中的任意一个
        List<String> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("b");
        list4.add("c");
        List<String> list5 = new ArrayList<>();
        list5.add("b");
        list5.add("c");
        System.out.println(CollectionUtils.containsAny(list4, list5));
        List<String> list6 = new ArrayList<>();
        list6.add("a");
        list6.add("d");
        System.out.println(CollectionUtils.containsAny(list4, list6));
        List<String> list7 = new ArrayList<>();
        list7.add("d");
        list7.add("e");
        System.out.println(CollectionUtils.containsAny(list4, list7));

        // 判断 List/Set 中的每个元素是否唯一。即 List/Set 中不存在重复元素
        List<String> list8 = new ArrayList<>();
        list8.add("a");
        list8.add("b");
        System.out.println(list8);
        System.out.println(CollectionUtils.hasUniqueObject(list8));
        list8.remove("b");
        list8.add("a");
        System.out.println(list8);
        System.out.println(CollectionUtils.hasUniqueObject(list8));

        // 将 Array 中的元素都添加到 List/Set 中
        ArrayList<Object> list9 = new ArrayList<>();
        list9.add("1");
        list9.add("2");
        list9.add("1");
        String[] arr = {"5", "4"};
        CollectionUtils.mergeArrayIntoCollection(arr, list9);
        System.out.println(list9);

        // 将 Properties 中的键值对都添加到 Map 中
        Properties properties = new Properties();
        properties.put("1", "2");
        properties.put("2", "3");
        System.out.println(properties);
        Map map2 = new HashMap();
        System.out.println(map2);
        CollectionUtils.mergePropertiesIntoMap(properties, map2);
        System.out.println(map2);

        // 返回 List 中最后一个元素
        List<String> list10 = new ArrayList<>();
        System.out.println(CollectionUtils.lastElement(list10));
        list10.add("a");
        list10.add("b");
        System.out.println(CollectionUtils.lastElement(list10));

        Set set = new HashSet();
        System.out.println(set);
        set.add("1");
        set.add("2");
        System.out.println(set);
        System.out.println(CollectionUtils.lastElement(set));

        // 返回参数 candidates 中第一个存在于参数 source 中的元素
        ArrayList<Object> arrayList1 = new ArrayList<>();
        arrayList1.add("1");
        arrayList1.add("a");
        ArrayList<Object> arrayList2 = new ArrayList<>();
        arrayList2.add("2");
        arrayList2.add("a");
        System.out.println(CollectionUtils.findFirstMatch(arrayList1, arrayList2));

        // 返回 List/Set 中指定类型的元素。
        List<Object> list11 = new ArrayList<>();
        System.out.println(CollectionUtils.findValueOfType(list11, String.class));
        list11.add("a");
        list11.add(1);
        System.out.println(CollectionUtils.findValueOfType(list11, String.class));

        // 返回 List/Set 中指定类型的元素。如果第一种类型未找到，则查找第二种类型，以此类推
        List<Object> list12 = new ArrayList<>();
        Class[] claArr1 = {Integer.class, Long.class};
        System.out.println(CollectionUtils.findValueOfType(list12, claArr1));
        list12.add("a");
        list12.add(1);
        System.out.println(CollectionUtils.findValueOfType(list12, claArr1));

        // 返回 List/Set 中元素的类型,判断list是不是一样的类型
        List<Object> list13 = new ArrayList<>();
        System.out.println(CollectionUtils.findCommonElementType(list13));
        list13.add("a");
        list13.add(1);
        System.out.println(CollectionUtils.findCommonElementType(list13));
        List<Object> list14 = new ArrayList<>();
        list14.add("a");
        list14.add("b");
        list14.add("c");
        System.out.println(CollectionUtils.findCommonElementType(list14));

        //*************************文件、资源、IO流*************************
        System.out.println("------FileCopyUtils------");
        // 从文件中读入到字节数组中
        File file = new File(System.getProperty("user.dir") + "/src/main/java/test/java方法工具/spring包方法", "别瞎写工具类了Spring自带的不香吗.java");  //创建文件对象

        System.out.println(Arrays.toString(FileCopyUtils.copyToByteArray(file)));

        // 从输入流中读入到字节数组中
        InputStream inputStream1 = new FileInputStream(file);
        System.out.println(Arrays.toString(FileCopyUtils.copyToByteArray(inputStream1)));

        // 从输入流中读入到字符串中
        Reader reader = new FileReader(file);
        System.out.println(FileCopyUtils.copyToString(reader));

        // 从字节数组到文件
        File outFile1 = new File("E:\\biankunpeng\\Desktop\\Thread共享变量的使用.java");
        FileCopyUtils.copy(FileCopyUtils.copyToByteArray(file), outFile1);

        // 从文件到文件
        File outFile2 = new File("E:\\biankunpeng\\Desktop\\Test2.java");
        FileCopyUtils.copy(file, outFile2);

        // 从字节数组到输出流
        File outFile3 = new File("E:\\biankunpeng\\Desktop\\Test3.java");
        OutputStream outputStream3 = new FileOutputStream(outFile3);
        FileCopyUtils.copy(FileCopyUtils.copyToByteArray(file), outputStream3);

        // 从输入流到输出流
        InputStream inputStream4 = new FileInputStream(file);
        File outFile4 = new File("E:\\biankunpeng\\Desktop\\Test4.java");
        OutputStream outputStream4 = new FileOutputStream(outFile4);
        FileCopyUtils.copy(inputStream4, outputStream4);

        // 从输入流到输出流
        Reader reader5 = new FileReader(file);
        File outFile5 = new File("E:\\biankunpeng\\Desktop\\Test5.java");
        Writer writer5 = new FileWriter(outFile5);
        FileCopyUtils.copy(reader5, writer5);

        // 从字符串到输出流
        Reader reader6 = new FileReader(System.getProperty("user.dir") + "/src/main/java/test/java方法工具/spring包方法/别瞎写工具类了Spring自带的不香吗.java");

        File outFile6 = new File("E:\\biankunpeng\\Desktop\\Test6.java");
        Writer writer6 = new FileWriter(outFile6);
        FileCopyUtils.copy(FileCopyUtils.copyToString(reader6), writer6);

        System.out.println("------ResourceUtils------");
        // 判断字符串是否是一个合法的 URL 字符串。
        System.out.println(ResourceUtils.isUrl("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\test\\多线程Thread.java"));
        System.out.println(ResourceUtils.isUrl("https://mp.weixin.qq.com/s/6O0XlwqxaZxuTrSKGRxsNQ?st=B4FB84275A6F530FB881205AC9CFF48BE07738CDD0196" +
                "A2BB5208EECF0F7D6D324C40AFCEB336C25751532CABD3719A2249CE3E0C42BF7528CA352EF9CE18315238F1DAA0FB2B98F8BDD71F953705FB8EF10F864920E09A663E8AC353F3C8" +
                "9ABBC62E12D77BBE617D650F344867269E3683DDDFE26B51FD08D0D374D76B6C459B6C2FA00384771B01F0FF716D927AA07D5544D2ABC7FFDFAB1B3146863322C5A762B1EA60D575" +
                "E5847CA1EE0804AED9C14649E574EDA9161901795654ACF47EB965AF42A1595BCCEE4411C312C0CECE4&vid=1688850455067540&cst=CB86ED5D59A7FEEDC86090421FBA06BE99B" +
                "8ACACABEF5EB87B81DD6417AA53BD50E50CEEB9455F0F413EF702222C8BD8&deviceid=5ce1062d-1166-43dd-8f89-73f2632c28f2&version=4.0.0.6007&platform=win"));

        // 获取 URL
        System.out.println(ResourceUtils.getURL("https://mp.weixin.qq.com/s/6O0XlwqxaZxuTrSKGRxsNQ?st=B4FB84275A6F530FB881205AC9CFF48BE07738CDD0196" +
                "A2BB5208EECF0F7D6D324C40AFCEB336C25751532CABD3719A2249CE3E0C42BF7528CA352EF9CE18315238F1DAA0FB2B98F8BDD71F953705FB8EF10F864920E09A663E8AC353F3C8" +
                "9ABBC62E12D77BBE617D650F344867269E3683DDDFE26B51FD08D0D374D76B6C459B6C2FA00384771B01F0FF716D927AA07D5544D2ABC7FFDFAB1B3146863322C5A762B1EA60D575" +
                "E5847CA1EE0804AED9C14649E574EDA9161901795654ACF47EB965AF42A1595BCCEE4411C312C0CECE4&vid=1688850455067540&cst=CB86ED5D59A7FEEDC86090421FBA06BE99B" +
                "8ACACABEF5EB87B81DD6417AA53BD50E50CEEB9455F0F413EF702222C8BD8&deviceid=5ce1062d-1166-43dd-8f89-73f2632c28f2&version=4.0.0.6007&platform=win"));

        // 文件系统资源 D:\...
        Resource resource1 = new FileSystemResource(new File("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\test\\别瞎写工具类了Spring自带的不香吗.java"));
        // 判断资源是否存在
        System.out.println(resource1.exists());
        // 从资源中获得 File 对象
        System.out.println(resource1.getFile());
        // 从资源中获得 URI 对象
        System.out.println(resource1.getURI());
        // 获得资源的 InputStream
        System.out.println(resource1.getInputStream());
        // 获得资源的描述信息
        System.out.println(resource1.getDescription());

        // URL 资源，如 file://... http://...
        Resource resource2 = new UrlResource(resource1.getURI());
        // 判断资源是否存在
        System.out.println(resource2.exists());
        // 从资源中获得 File 对象
        System.out.println(resource2.getFile());
        // 从资源中获得 URI 对象
        System.out.println(resource2.getURL());
        // 获得资源的 InputStream
        System.out.println(resource2.getInputStream());
        // 获得资源的描述信息
        System.out.println(resource2.getDescription());

        // 类路径下的资源，classpth:...
        Resource resource3 = new ClassPathResource("application.properties");
        // 判断资源是否存在
        System.out.println(resource3.exists());
        // 从资源中获得 File 对象
        System.out.println(resource3.getFile());
        // 从资源中获得 URI 对象
        System.out.println(resource3.getURL());
        // 获得资源的 InputStream
        System.out.println(resource3.getInputStream());
        // 获得资源的描述信息
        System.out.println(resource3.getDescription());

        // Web 容器上下文中的资源（jar 包、war 包） 从Servlet 上下文环境中加载
//        Resource resource4 = new ServletContextResource(null, "resources/application.properties");

        //定义指定磁盘的文件的File对象
        FileReader fr = new FileReader(ResourceUtils.getFile("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\test\\别瞎写工具类了Spring自带的不香吗.java"));
        char[] data = new char[23];            //定义char数组
        int length = 0;

        FileOutputStream output = new FileOutputStream(new File("D:\\text.java"));
        String result = null;
        while ((length = fr.read(data)) > 0) {            //循环读取文件中的数据
            String str = new String(data, 0, length);            //根据读取文件的内容创建String 对象
            System.out.println(str);                //输出读取内容
            result += str;
        }
        fr.close();                                //关闭流
        output.write(result.getBytes());


        System.out.println("----------------------------------StreamUtils----------------------------------");
        System.out.println("------StreamUtils-输入------");
        // 你猜默认编码是什么
        StreamUtils.copy(("测试下").getBytes(), new FileOutputStream(new File("E:\\biankunpeng\\Desktop\\Test7.java")));

        int result8 = StreamUtils.copy(new FileInputStream(new File("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\test\\别瞎写工具类了Spring自带的不香吗.java")),
                new FileOutputStream(new File("E:\\biankunpeng\\Desktop\\Test8.java")));
        System.out.println(result8);

        // 试试gbk，看看是不是一样
        StreamUtils.copy("哇哇", Charset.forName("UTF-8"), new FileOutputStream(new File("E:\\biankunpeng\\Desktop\\Test9.java")));

        long result10 = StreamUtils.copyRange(new FileInputStream(new File("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\test\\别瞎写工具类了Spring自带的不香吗.java")),
                new FileOutputStream(new File("E:\\biankunpeng\\Desktop\\Test10.java")), 0, 100);
        System.out.println(result10);

        System.out.println("------StreamUtils-输出------");
        System.out.println(Arrays.toString(StreamUtils.copyToByteArray(new FileInputStream("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\test\\别瞎写工具类了Spring自带的不香吗.java"))));

        // 试试utf-8
        System.out.println(StreamUtils.copyToString(new FileInputStream("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\test\\别瞎写工具类了Spring自带的不香吗.java"), Charset.forName("gbk")));

        // 舍弃输入流中的内容
        System.out.println(StreamUtils.drain(new FileInputStream(new File("D:\\workspace\\springbootdemo\\src\\main\\java\\test\\test\\别瞎写工具类了Spring自带的不香吗.java"))));

        //*************************反射、AOP*************************"
        System.out.println("------ReflectionUtils-获取方法------");
        // 在类中查找指定方法 无参
        System.out.println(ReflectionUtils.findMethod(String.class, "toString"));

        // 同上，额外提供方法参数类型作查找条件
        System.out.println(ReflectionUtils.findMethod(String.class, "valueOf", boolean.class));
        // 想想这个
//        System.out.println(ReflectionUtils.findMethod(ReflectionUtils.class, "findMethod"));
        System.out.println(ReflectionUtils.findMethod(ReflectionUtils.class, "findMethod", Class.class, String.class));

        // 获得类中所有方法，包括继承而来的
        System.out.println(Arrays.toString(ReflectionUtils.getAllDeclaredMethods(String.class)));

        // 在类中查找指定构造方法
        System.out.println(ReflectionUtils.accessibleConstructor(String.class));
        // 对比无参和有参，想想Class<?>... parameterTypes使用挺有意思的啊
        System.out.println(ReflectionUtils.accessibleConstructor(String.class, byte[].class));

        // 是否是 equals() 方法
        System.out.println(ReflectionUtils.isEqualsMethod(ReflectionUtils.findMethod(String.class, "toString")));
        System.out.println(ReflectionUtils.isEqualsMethod(ReflectionUtils.findMethod(String.class, "equals", Object.class)));

        // 是否是 hashCode() 方法
        System.out.println(ReflectionUtils.isHashCodeMethod(ReflectionUtils.findMethod(String.class, "hashCode")));
        System.out.println(ReflectionUtils.isHashCodeMethod(ReflectionUtils.findMethod(String.class, "hashCode", Object.class)));

        // 是否是 toString() 方法
        System.out.println(ReflectionUtils.isToStringMethod(ReflectionUtils.findMethod(String.class, "toString")));
        System.out.println(ReflectionUtils.isToStringMethod(ReflectionUtils.findMethod(String.class, "toString", Object.class)));

        // 是否是从 Object 类继承而来的方法
        System.out.println(ReflectionUtils.isObjectMethod(ReflectionUtils.findMethod(String.class, "toString")));
        System.out.println(ReflectionUtils.isObjectMethod(ReflectionUtils.findMethod(String.class, "split", String.class)));

        // 检查一个方法是否声明抛出指定异常
        System.out.println(ReflectionUtils.declaresException(ReflectionUtils.findMethod(String.class, "toString"), Exception.class));
        System.out.println(ReflectionUtils.declaresException(ReflectionUtils.findMethod(Thread.class, "sleep", long.class), InterruptedException.class));

        System.out.println("------ReflectionUtils-执行方法------");
        // 执行方法
        System.out.println(ReflectionUtils.invokeMethod(ReflectionUtils.findMethod(String.class, "toString"), "123"));

        // 同上，提供方法参数
        Object[] objects = (Object[]) ReflectionUtils.invokeMethod(ReflectionUtils.findMethod(String.class, "split", String.class), "a,b", ",");
        System.out.println(Arrays.toString(objects));

        // 取消 Java 权限检查。以便后续执行该私有方法
        ReflectionUtils.makeAccessible(ReflectionUtils.findMethod(String.class, "indexOfSupplementary", int.class, int.class));

        // 取消 Java 权限检查。以便后续执行私有构造方法
        ReflectionUtils.makeAccessible(String.class.getConstructor());

        System.out.println("------ReflectionUtils-获取字段------");
        // 在类中查找指定属性
        System.out.println(ReflectionUtils.findField(String.class, "hash"));
        System.out.println(ReflectionUtils.findField(Boolean.class, "FALSE"));

        // 同上，多提供了属性的类型
        System.out.println(ReflectionUtils.findField(String.class, "hash", String.class));
        System.out.println(ReflectionUtils.findField(String.class, "hash", int.class));

        // 是否为一个 "public static final" 属性
        System.out.println(ReflectionUtils.isPublicStaticFinal(ReflectionUtils.findField(String.class, "hash")));
        System.out.println(ReflectionUtils.isPublicStaticFinal(ReflectionUtils.findField(Boolean.class, "FALSE")));

        System.out.println("------ReflectionUtils-设置字段------");
        // 获取 target 对象的 field 属性值
        Field field1 = Integer.class.getField("MIN_VALUE");
//        field1.set("MIN_VALUE", 123); // Can not set static final int field java.lang.Integer.MIN_VALUE to java.lang.Integer
        System.out.println(ReflectionUtils.getField(field1, "MIN_VALUE"));
        Field field2 = 别瞎写工具类了Spring自带的不香吗.class.getField("name");
        field2.set("name", "def");
        System.out.println(ReflectionUtils.getField(field2, "name"));

        // 设置 target 对象的 field 属性值，值为 value
        Field field3 = 别瞎写工具类了Spring自带的不香吗.class.getField("name");
        ReflectionUtils.setField(field3, "name", "ghi");
        System.out.println(ReflectionUtils.getField(field3, "name"));

        // 同类对象属性对等赋值
        别瞎写工具类了Spring自带的不香吗 src = new 别瞎写工具类了Spring自带的不香吗();
        src.test = "test1";
        别瞎写工具类了Spring自带的不香吗 dest = new 别瞎写工具类了Spring自带的不香吗();
        dest.test = "test2";
        System.out.println(dest.test);
        ReflectionUtils.shallowCopyFieldState(src, dest);
        System.out.println(dest.test);

        // 取消 Java 的权限控制检查。以便后续读写该私有属性
        ReflectionUtils.makeAccessible(String.class.getDeclaredField("hash"));

        // 对类的每个属性执行 callback 没整明白
        ReflectionUtils.doWithFields(String.class, new FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field.getName() + "啥意思啊");
            }
        });

        // 同上，多了个属性过滤功能。
        ReflectionUtils.doWithFields(String.class, new FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field.getName() + "啥意思啊");
                System.out.println("有点感觉了");
            }
        }, new FieldFilter() {

            @Override
            public boolean matches(Field field) {
                return true;
            }

            @Override
            public FieldFilter and(FieldFilter next) {
                notNull(next, "Next FieldFilter must not be null");
                return field -> matches(field) && next.matches(field);
            }
        });

        ReflectionUtils.doWithFields(别瞎写工具类了Spring自带的不香吗.class, new FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field.getName() + "包括继承而来的属性");
            }
        });
        System.out.println("doWithFields-end");
        // 同上，但不包括继承而来的属性
        ReflectionUtils.doWithLocalFields(别瞎写工具类了Spring自带的不香吗.class, new FieldCallback() {
            @Override
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                System.out.println(field.getName() + "不包括继承而来的属性");
            }
        });


        System.out.println("------AopUtils-判断代理类型------");
        // 判断是不是 Spring 代理对象
        //boolean isAopProxy()
        // 判断是不是 jdk 动态代理对象
        //isJdkDynamicProxy()
        // 判断是不是 CGLIB 代理对象
        //boolean isCglibProxy ()

        System.out.println("------AopUtils-获取被代理对象的 class------");
        System.out.println(AopUtils.getTargetClass(String.class));

    }

    public static String name = "abc";
    public String test;
    private String private_permission_test = null;
}

class FatherClass {
    public static String id;
}

