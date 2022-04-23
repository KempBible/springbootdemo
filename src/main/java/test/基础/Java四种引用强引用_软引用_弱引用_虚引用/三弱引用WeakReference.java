package test.基础.Java四种引用强引用_软引用_弱引用_虚引用;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class 三弱引用WeakReference {
    private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

    public static void checkQueue(){
        Reference<? extends VeryBig> ref = null;
        while((ref = rq.poll()) != null){
            if (ref != null){
                System.out.println("In queue: " + ((VeryBigWeakReference)(ref)).id);
            }
        }
    }

    public static void main(String[] args) {
        int size = 3;
        LinkedList<WeakReference<VeryBig>> weakReferenceLinkedList = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            weakReferenceLinkedList.add(new VeryBigWeakReference(new VeryBig("Weak " + i), rq));
            System.out.println("Just created weak: " + weakReferenceLinkedList.getLast());
        }

        System.gc();
        try {
            Thread.currentThread().sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkQueue();
    }

}

class VeryBig{

    public String id;

    // 占用空间,让线程进行回收
    byte[] b = new byte[2*1024];

    public VeryBig(String id) {
        this.id = id;
    }

    protected void finalize(){
        System.out.println("Finalizing VeryBig " + id);
    }
}

class VeryBigWeakReference extends WeakReference<VeryBig>{
    public String id;

    public VeryBigWeakReference(VeryBig big, ReferenceQueue<VeryBig> rq) {
        super(big, rq);
        this.id = big.id;
    }

    protected void finalize() {
        System.out.println("Finalizing VeryBigWeakReference " + id);
    }
}