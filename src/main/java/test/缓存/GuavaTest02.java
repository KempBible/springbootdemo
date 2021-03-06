package test.缓存;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author xzw
 * @since 2020/10/2020
 */
public class GuavaTest02 {

    public static Cache<String, String> caches = CacheBuilder.newBuilder().
            //设置容量上限
                    maximumSize(128)
            //若3秒内没有读写请求则进行回收
            .expireAfterAccess(3, TimeUnit.SECONDS)
            .removalListener(new RemovalListener<String, String>() {
                //移除监听器
                @Override
                public void onRemoval(RemovalNotification<String, String> notification) {
                    System.out.println(notification.getKey());
                }
            }).build();

    public static String get(final String key) throws Exception {
        String rr = caches.get(key, new Callable<String>() {

            @Override
            public String call() throws Exception {
                if ("1".equalsIgnoreCase(key)) {
                    return "test";
                }
                throw new Exception("This is a test!");
            }
        });
        return rr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(GuavaTest02.get("1"));
        System.out.println("before expire: " + GuavaTest02.caches.asMap().keySet());
        Thread.sleep(5000);
        System.out.println("after expire: " + GuavaTest02.caches.asMap().keySet());
    }
}