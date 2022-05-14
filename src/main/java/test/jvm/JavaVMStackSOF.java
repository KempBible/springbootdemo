package test.jvm;

public class JavaVMStackSOF {
    private int stackLengh = 1;

    public void stackLeak(){
        stackLengh++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + oom.stackLengh);
            e.printStackTrace();
        }
    }
}
