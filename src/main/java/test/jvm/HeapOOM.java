package test.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HeapOOM
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/12 10:54
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
