package test.缓存;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author bkp
 * @since 2020/10/20
 */
public class GuavaTest {
    public static void main(String[] args) {
        LoadingCache<String, Integer> cache = CacheBuilder.newBuilder()
                //最多存放十个数据
                .maximumSize(10)
                //缓存10秒，10秒之后进行回收
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .recordStats()//开启，记录状态数据功能
                .build(new CacheLoader<String, Integer>() {
                    //数据加载，默认返回-1，也可以是查询操作，如从DB查询
                    @Override
                    public Integer load(String key) throws Exception {
                        // TODO Auto-generated method stub
                        return -1;
                    }
                });
        //只查询缓存，没有命中，即返回null
        System.out.println(cache.getIfPresent("key1"));
        //put数据，放在缓存中
        cache.put("key1", 1);
        //再次查询，已经存在缓存中
        System.out.println(cache.getIfPresent("key1"));
        try {
            //查询缓存，未命中，调用load方法，返回-1
            System.out.println(cache.get("key2"));
            //put数据，更新缓存
            cache.put("key2", 2);
            //查询得到最新的数据
            System.out.println(cache.get("key2"));
            System.out.println("size:" + cache.size());
            //插入十个数据
            for (int i = 3; i < 13; i++) {
                cache.put("key" + i, i);
            }
            //超过最大容量，删除最早插入的数据
            System.out.println("size:" + cache.size());
            System.out.println(cache.getIfPresent("key2"));
            //等待5秒
            Thread.sleep(5000);
            cache.put("key1", 1);
            cache.put("key2", 2);
            //key5没失效，key3、key4已经失效
            System.out.println(cache.getIfPresent("key5"));
            //等待5秒
            Thread.sleep(5000);
            //此时key5-key12已经失效，但是size没有更新
            System.out.println("size :" + cache.size());
            System.out.println(cache.getIfPresent("key1"));
            System.out.println("size :" + cache.size());
            //获取key5，发现已经失效，然后刷新缓存，遍历数据，去掉失效的所有数据
            System.out.println(cache.getIfPresent("key5"));
            //此时只有key1，key2没有失效
            System.out.println("size :" + cache.size());
            System.out.println("status, hitCount:" + cache.stats().hitCount()
                    + ", missCount:" + cache.stats().missCount());

            //等待5秒
            Thread.sleep(10000);
            System.out.println("size :" + cache.size());
            System.out.println(cache.getIfPresent("key1"));

        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
