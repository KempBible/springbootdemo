package test.基础;

import com.alibaba.druid.support.json.JSONUtils;

// http://c.biancheng.net/view/892.html
public class Float类的构造方法 {
    public static void main(String[] args) {
        Float float1 = new Float(3.14145);
        Float float2 = new Float(6.5);
        Float float3 = new Float("3.14145");
        System.out.println(float1);
        System.out.println(float2);
        System.out.println(float3);

        System.out.println(float1.byteValue());
        System.out.println(float1.isNaN());

        String str = "456.7";
        float num = Float.parseFloat(str); // 将字符串转换为 float 类型的数值
        System.out.println(num);

        float f = 123.4f;
        String s = Float.toString(f);
        System.out.println(s);

        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.SIZE);

        float max_value = Float.MAX_VALUE; // 获取 float 类型可取的最大值
        float min_value = Float.MIN_VALUE; // 获取 float 类型可取的最小值
        float min_normal = Float.MIN_NORMAL; // 获取 float 类型可取的最小标准值
        System.out.println(max_value);
        System.out.println(min_value);
        System.out.println(min_normal);
    }
}
