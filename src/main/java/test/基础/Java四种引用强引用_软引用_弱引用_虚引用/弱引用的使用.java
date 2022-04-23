package test.基础.Java四种引用强引用_软引用_弱引用_虚引用;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class 弱引用的使用 {
    private static ReferenceQueue<NiuhBig> rq = new ReferenceQueue<NiuhBig>();

    public static void checkQueue() {
        Reference<? extends NiuhBig> ref = null;
        while ((ref = rq.poll()) != null) {
            if (ref != null) {
                System.out.println("In queue: " + ((NiuhBigWeakReference) (ref)).id);
            }
        }
    }

    public static void main(String args[]) {
        int size = 3;
        LinkedList<WeakReference<NiuhBig>> weakList = new LinkedList<WeakReference<NiuhBig>>();
        for (int i = 0; i < size; i++) {
            weakList.add(new NiuhBigWeakReference(new NiuhBig("Weak " + i), rq));
            System.out.println("Just created weak: " + weakList.getLast());
        }

        System.gc();
        try { // 下面休息几分钟，让上面的垃圾回收线程运行完成
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
    }
}

class NiuhBig {
    public String id;
    // 占用空间,让线程进行回收
    byte[] b = new byte[2 * 1024];

    public NiuhBig(String id) {
        this.id = id;
    }

    protected void finalize() {
        System.out.println("Finalizing NiuhBig " + id);
    }
}

class NiuhBigWeakReference extends WeakReference<NiuhBig> {
    public String id;

    public NiuhBigWeakReference(NiuhBig big, ReferenceQueue<NiuhBig> rq) {
        super(big, rq);
        this.id = big.id;
    }

    protected void finalize() {
        System.out.println("Finalizing NiuhBigWeakReference " + id);
    }
}
