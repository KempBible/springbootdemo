package test.ZooKeeper;

/**
 * @ClassName ZK
 * @Description TODO
 * @Author biankunpeng
 * @Date 2022/1/10 17:59
 */
public class ZK {

    public static void main(String[] args) {
        System.out.println(initializeNextSession(1L));
    }

    public static long initializeNextSession(long id) {
        long nextSid = 0;

        nextSid = (System.currentTimeMillis() << 24) >>> 8;
        nextSid = nextSid | (id << 56);
        return nextSid;
    }
}
