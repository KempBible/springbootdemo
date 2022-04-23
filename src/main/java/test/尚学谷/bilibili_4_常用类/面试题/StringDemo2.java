package test.尚学谷.bilibili_4_常用类.面试题;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class StringDemo2 {

    /**
     * 获取两个字符串最大相同子串。比如：
     * str1 = "abcwerthello1yuiodefabcdef"；str2 = "cvhello1bnm"
     * 提示：将短的那个串进行长度依次递减的子串与较长的串比较
     */
    // 前提：两个字符串中只有一个最大相同子串
    public String getMaxSameString(String str1, String str2){
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int length = minStr.length();

        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length - i; y <= length; x++,y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr)){
                    return subStr;
                }
            }
        }
        return null;
    }

    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[],后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer stringBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;
            int length = minString.length();

            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++,y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)){
                        stringBuffer.append(subString + ",");
                    }
                }
//                System.out.println(stringBuffer);
                if (stringBuffer.length() != 0){
                    break;
                }
            }
            String[] split = stringBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }
        return null;
    }

    @Test
    public void testGetMaxSameString(){
        String str1 = "abcwerthelloyuiodefabcdef";
        String str2 = "cvhello1bnm";
        String maxSameString = getMaxSameString(str1, str2);
        System.out.println(maxSameString);
    }

    @Test
    public void testGetMaxSameString1(){
        String str1 = "abcwerthelloyuiodefabcdef";
        String str2 = "cvhello1bnm";
        String[] maxSameString = getMaxSameString1(str1, str2);
        System.out.println(Arrays.toString(maxSameString));
    }
}
