package test.redis.分布式锁.基于Redis实现分布式锁的7种方案;

import cn.hutool.core.collection.ListUtil;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://blog.csdn.net/weixin_46228112/article/details/124331083?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_title~default-0-124331083-blog-121318281.pc_relevant_default&spm=1001.2101.3001.4242.1&utm_relevant_index=3
public class _3_使用Lua脚本包含SETNXEXPIRE两条指令 {

    private static Jedis jedis = new Jedis("127.0.0.1", 6379, 100000); //redis客户端

    public static void main(String[] args) {

        String key_resource_id_3 = "key_resource_id_3";
        List list = ListUtil.toLinkedList(1,2,3);

        String lua_scripts = "if redis.call('setnx',KEYS[1],ARGV[1]) == 1 then" +
                " redis.call('expire',KEYS[1],ARGV[2]) return 1 else return 0 end";
        Object result = jedis.eval(lua_scripts, Collections.singletonList(key_resource_id_3), Collections.singletonList("list"));
        System.out.println(result.equals(1L));
    }

}
