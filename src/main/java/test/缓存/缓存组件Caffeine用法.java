package test.缓存;

import com.github.benmanes.caffeine.cache.*;
import lombok.SneakyThrows;
import org.checkerframework.checker.index.qual.NonNegative;
import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/11 10:08
 */
public class 缓存组件Caffeine用法 {

    @Test
    public void manualLoad() {
        Cache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10_000)
                .build();
        //查找一个缓存元素，没有查找到的时候返回null
        String name = cache.getIfPresent("name");
        System.out.println("name:" + name);
        //查找缓存，如果缓存不存在则生成缓存元素,如果无法生成则返回null
        name = cache.get("name", k -> "小明");
        System.out.println("name:" + name);
        //添加或者更新一个缓存元素
        cache.put("address", "深圳");
        String address = cache.getIfPresent("address");
        System.out.println("address:" + address);
    }

    @Test
    public void manualAsynLoad() {
        AsyncCache<String, String> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10_000)
                //可以用指定的线程池
                .executor(Executors.newSingleThreadExecutor())
                .buildAsync();
        //查找缓存元素，如果不存在，则异步生成
        CompletableFuture<String> graph = cache.get("name", new Function<String, String>() {
            @SneakyThrows
            @Override
            public String apply(String key) {
                System.out.println("key:" + key + ",当前线程:" + Thread.currentThread().getName());
                //模仿从数据库获取值
                Thread.sleep(1000);
                return "小明";
            }
        });
        System.out.println("获取name之前_time:" + System.currentTimeMillis() / 1000);
        String name = null;
        try {
            name = graph.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("获取name:" + name + ",time:" + System.currentTimeMillis() / 1000);
    }

    @Test
    public void autoAsynLoad() {
        AsyncLoadingCache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(10_000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                //你可以选择:去异步的封装一段同步操作来生成缓存元素
                .buildAsync(new AsyncCacheLoader<String, String>() {
                    @Override
                    public @NonNull
                    CompletableFuture<String> asyncLoad(@NonNull String key, @NonNull Executor executor) {
                        System.out.println("自动异步加载_key:" + key + ",当前线程:" + Thread.currentThread().getName());
                        return CompletableFuture.completedFuture("小明");
                    }
                });
        //也可以选择:构建一个异步缓存元素操作并返回一个future
//        .buildAsync((key, executor) -> createExpensiveGraphAsync(key, executor));
        //查找缓存元素，如果其不存在，将会异步进行生成
        cache.get("name").thenAccept(name -> {
            System.out.println("name:" + name);
        });
    }

    private CompletableFuture<String> createExpensiveGraphAsync(String key, Executor executor) {
        return CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println(executor);
                System.out.println("key:" + key + ",当前线程:" + Thread.currentThread().getName());
                return "小明";
            }
        }, executor);
    }

    @Test
    public void writeFixedTime() throws InterruptedException {
        //在最后一次访问或者写入后开始计时，在指定的时间后过期。
        LoadingCache<String, String> graphs = Caffeine.newBuilder()
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .removalListener((String key, Object value, RemovalCause cause) ->
                        System.out.printf("Key %s was removed (%s)%n", key, cause))
                .build(key -> createExpensiveGraph(key));
        String name = graphs.get("name");
        System.out.println("第一次获取name:" + name);
        name = graphs.get("name");
        System.out.println("第二次获取name:" + name);
        Thread.sleep(2000);
        name = graphs.get("name");
        System.out.println("第三次延迟2秒后获取name:" + name);
    }

    private static String createExpensiveGraph(String key) {
        System.out.println("重新自动加载数据");
        return "小明";
    }

    @Test
    public void accessFixedTime() throws InterruptedException {
        //在最后一次访问或者写入后开始计时，在指定的时间后过期。
        LoadingCache<String, String> graphs = Caffeine.newBuilder()
                .expireAfterAccess(1, TimeUnit.SECONDS)
                .removalListener((String key, Object value, RemovalCause cause) ->
                        System.out.printf("Key %s was removed (%s)%n", key, cause))
                .build(key -> createExpensiveGraph(key));
        String name = graphs.get("name");
        System.out.println("第一次获取name:" + name);
        name = graphs.get("name");
        System.out.println("第二次获取name:" + name);
        Thread.sleep(2000);
        name = graphs.get("name");
        System.out.println("第三次延迟2秒后获取name:" + name);
    }

    @Test
    public void customTime() throws InterruptedException {
        LoadingCache<String, String> graphs = Caffeine.newBuilder()
                .removalListener((String key, Object value, RemovalCause cause) ->
                        System.out.printf("Key %s was removed (%s)%n", key, cause))
                .expireAfter(new Expiry<String, String>() {
                    @Override
                    public long expireAfterCreate(@NonNull String key, @NonNull String value, long currentTime) {
                        //这里的currentTime由Ticker提供，默认情况下与系统时间无关，单位为纳秒
                        System.out.println(String.format("expireAfterCreate----key:%s,value:%s,currentTime:%d", key, value, currentTime));
                        return TimeUnit.SECONDS.toNanos(10);
                    }

                    @Override
                    public long expireAfterUpdate(@NonNull String key, @NonNull String value, long currentTime, @NonNegative long currentDuration) {
                        //这里的currentTime由Ticker提供，默认情况下与系统时间无关，单位为纳秒
                        System.out.println(String.format("expireAfterUpdate----key:%s,value:%s,currentTime:%d,currentDuration:%d", key, value, currentTime, currentDuration));
                        return TimeUnit.SECONDS.toNanos(3);
                    }

                    @Override
                    public long expireAfterRead(@NonNull String key, @NonNull String value, long currentTime, @NonNegative long currentDuration) {
                        //这里的currentTime由Ticker提供，默认情况下与系统时间无关，单位为纳秒
                        System.out.println(String.format("expireAfterRead----key:%s,value:%s,currentTime:%d,currentDuration:%d", key, value, currentTime, currentDuration));
                        return currentDuration;
                    }
                })

                .build(key -> createExpensiveGraph(key));
        String name = graphs.get("name");
        System.out.println("第一次获取name:" + name);
        name = graphs.get("name");
        System.out.println("第二次获取name:" + name);
        Thread.sleep(5000);
        name = graphs.get("name");
        System.out.println("第三次延迟5秒后获取name:" + name);
        Thread.sleep(5000);
        name = graphs.get("name");
        System.out.println("第五次延迟5秒后获取name:" + name);
    }

    @Test
    public void softValues() throws InterruptedException {
        //当进行GC的时候进行驱逐
        LoadingCache<String, byte[]> cache = Caffeine.newBuilder()
                .softValues()
                .removalListener((String key, Object value, RemovalCause cause) ->
                        System.out.printf("Key %s was removed (%s)%n", key, cause))
                .build(key -> loadDB(key));
        System.out.println("1");
        cache.put("name1", new byte[1024 * 1024 * 50]);
        System.gc();
        System.out.println("2");
        Thread.sleep(5000);
        cache.put("name2", new byte[1024 * 1024 * 50]);
        System.gc();
        System.out.println("3");
        Thread.sleep(5000);
        cache.put("name3", new byte[1024 * 1024 * 50]);
        System.gc();
        System.out.println("4");
        Thread.sleep(5000);
        cache.put("name4", new byte[1024 * 1024 * 50]);
        System.gc();
        Thread.sleep(5000);
    }

    private static byte[] loadDB(String key) {
        System.out.println("重新自动加载数据");
        return new byte[1024 * 1024];
    }

    @Test
    public void estimatedSize1() throws InterruptedException {
        //初始化缓存，设置最大权重为20
        Cache<Integer, Integer> cache = Caffeine.newBuilder()
                .maximumWeight(20)
                .weigher(new Weigher<Integer, Integer>() {
                    @Override
                    public @NonNegative int weigh(@NonNull Integer key, @NonNull Integer value) {
                        System.out.println("weigh:" + value);
                        return value;
                    }
                })
                .removalListener((Integer key, Object value, RemovalCause cause) ->
                        System.out.printf("Key %s was removed (%s)%n", key, cause))
                .build();

        cache.put(100, 10);
        //打印缓存个数，结果为1
        System.out.println(cache.estimatedSize());
        cache.put(200, 20);
        //稍微休眠一秒
        Thread.sleep(1000);
        //打印缓存个数，结果为1
        System.out.println(cache.estimatedSize());
    }

    @Test
    public void estimatedSize2() throws InterruptedException {
        Cache<String, String> cache = Caffeine.newBuilder()
                .maximumSize(1)
                .removalListener((String key, Object value, RemovalCause cause) ->
                        System.out.printf("Key %s was removed (%s)%n", key, cause))
                .build();
        cache.put("name", "小明");
        System.out.println("name:" + cache.getIfPresent("name") + ",缓存容量:" + cache.estimatedSize());
        cache.put("address", "中国");
        Thread.sleep(2000);
        System.out.println("name:" + cache.getIfPresent("name") + ",缓存容量:" + cache.estimatedSize());
    }
}