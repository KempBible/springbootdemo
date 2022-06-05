package com.example.springbootdemo.controller.redis;

//Redis操作list
//https://blog.csdn.net/qq_46550964/article/details/124388670

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * explain:public interface ListOperations<K,V>
 * Redis列表是简单的字符串列表，按照插入顺序排序。你可以添加一个元素导列表的头部（左边）或者尾部（右边）
 * ListOperations专门操作list列表
 */

@RestController
@RequestMapping(value = "redisList", produces = "application/json;charset=UTF-8")
public class RedisOperateListController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * RedisTemplate操作list
     */
    @GetMapping("/operateList")
    private String operateList() {
        ListOperations<String, Object> opsForList = redisTemplate.opsForList();
        deleteAllKey();

        //Long leftPush(K key, V value)
        //将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从左边插入）
        opsForList.leftPush("product:list", "iphone xs max");
        opsForList.leftPush("product:list", "thinkpad x1 carbon");

        //List<V> range(K key, long start, long end)
        //返回存储在键中的列表的指定元素。偏移开始和停止是基于零的索引，其中0是列表的第一个元素（列表的头部），1是下一个元素
        List<Object> opsList = opsForList.range("product:list", 0, -1);
        //[thinkpad x1 carbon, iphone xs max]
        System.out.println(opsList);

        // Long leftPushAll(K key, V... values);批量把一个数组插入到列表中
        Object[] stringArr = new String[]{"1", "2", "3"};
        opsForList.leftPushAll("product:list", stringArr);
        //[3, 2, 1, thinkpad x1 carbon, iphone xs max]
        System.out.println(opsForList.range("product:list", 0, -1));

        // Long size(K key);
        // 返回存储在键中的列表的长度。如果键不存在，则将其解释为空列表，并返回0。当key存储的值不是列表时返回错误。
        Long size = opsForList.size("product:list");
        //5
        System.out.println(size);

        //Long leftPushAll(K key, Collection<V> values);批量把一个集合插入到列表中
        ArrayList<Object> list = new ArrayList<>();
        list.add("4");
        list.add("5");
        list.add("6");
        opsForList.leftPushAll("product:list", list);
        //[6, 5, 4, 3, 2, 1, thinkpad x1 carbon, iphone xs max]
        System.out.println(opsForList.range("product:list1", 0, -1));

        //Long leftPushIfPresent(K key, V value);只有存在key对应的列表才能将这个value值插入到key所对应的列表中
        opsForList.leftPushIfPresent("product:list", "7");
        //[7, 6, 5, 4, 3, 2, 1, thinkpad x1 carbon, iphone xs max]
        System.out.println(opsForList.range("product:list1", 0, -1));

        // Long leftPush(K key, V pivot, V value);把value值放到key对应列表中pivot值的左面，(如果pivot值存在的话)
        opsForList.leftPush("product:list1","4","8");
        //[7, 6, 5, 8, 4, 3, 2, 1, thinkpad x1 carbon, iphone xs max]
        System.out.println(opsForList.range("product:list1",0,-1));

        // Long rightPush(K key, V value);
        // 将所有指定的值插入存储在键的列表的头部。如果键不存在，则在执行推送操作之前将其创建为空列表。（从右边插入）
        opsForList.rightPush("product:list1","java");
        //[7, 6, 5, 8, 4, 3, 2, 1, thinkpad x1 carbon, iphone xs max, java]
        System.out.println(opsForList.range("product:list1",0,-1));

        // Long rightPushAll(K key, V... values);
        opsForList.rightPushAll("product:list1",stringArr);
        opsForList.rightPushAll("product:list1",list);
        //[7, 6, 5, 8, 4, 3, 2, 1, thinkpad x1 carbon, iphone xs max, java, 1, 2, 3, 4, 5, 6]
        System.out.println(opsForList.range("product:list1",0,-1));

        // Long rightPushIfPresent(K key, V value);
        // 只有存在key对应的列表才能将这个value值插入到key所对应的列表中
        opsForList.rightPushIfPresent("product:list1","7");
        //[7, 6, 5, 8, 4, 3, 2, 1, thinkpad x1 carbon, iphone xs max, java, 1, 2, 3, 4, 5, 6, 7]
        System.out.println(opsForList.range("product:list1",0,-1));

        // Long rightPush(K key, V pivot, V value);
        // 把value值放到key对应列表中pivot值的右面，如果pivot值存在的话
        opsForList.rightPush("product:list1","8");
        //[7, 6, 5, 8, 4, 3, 2, 1, thinkpad x1 carbon, iphone xs max, java, 1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(opsForList.range("product:list1",0,-1));

        // void set(K key, long index, V value);在列表中index的位置设置value值
        opsForList.set("product:list1",5,"java1");
        //[7, 6, 5, 8, 4, java1, 2, 1]
        System.out.println(opsForList.range("product:list1",0,7));

        // Long remove(K key, long count, Object value);
        // 从存储在键中的列表中删除等于值的元素的第一个计数事件。
        // 计数参数以下列方式影响操作：
        // count> 0：删除等于从头到尾移动的值的元素。
        // count <0：删除等于从尾到头移动的值的元素。
        // count = 0：删除等于value的所有元素。
        opsForList.remove("product:list1",1,"java1");
        //[7, 6, 5, 8, 4, 2, 1, thinkpad x1 carbon, iphone xs max, java, 1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(opsForList.range("product:list1",0,-1));

        // V index(K key, long index);根据下表获取列表中的值，下标是从0开始的
        Object index = opsForList.index("product:list1",0);
        //7
        System.out.println(index);

        // V leftPop(K key);弹出最左边的元素，弹出之后该值在列表中将不复存在
        Object leftPop = opsForList.leftPop("product:list1");
        //7
        System.out.println(leftPop);

        // V leftPop(K key, long timeout, TimeUnit unit);
        // 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        Object leftPop1 = opsForList.leftPop("product:list1",10,TimeUnit.SECONDS);
        //6
        System.out.println(leftPop1);

        // V rightPop(K key);弹出最右边的元素，弹出之后该值在列表中将不复存在
        //8
        System.out.println(opsForList.rightPop("product:list1"));

        // V rightPopAndLeftPush(K sourceKey, K destinationKey);
        // 用于移除列表的最后一个元素，并将该元素添加到另一个列表并返回。
        Object object = opsForList.rightPopAndLeftPush("product:list1", "product:list2");
        //7
        System.out.println(object);
        // V rightPopAndLeftPush(K sourceKey, K destinationKey, long timeout, TimeUnit unit);
        // 用于移除列表的最后一个元素，并将该元素添加到另一个列表并返回，如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
        // 使用：用法与rightPopAndLeftPush(K sourceKey, K destinationKey)一样


        return "method completed ok";
    }

    /**
     * 删除redis中所有的key
     */
    private void deleteAllKey(){
        //获取所有key
        Set<String> keys = redisTemplate.keys("*");
        //[product:list]
        System.out.println(keys);
        Long delete = redisTemplate.delete(keys);
        //1
        System.out.println(delete);
    }
}

