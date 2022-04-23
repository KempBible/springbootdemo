package test.ZooKeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.jupiter.api.Test;

import java.util.List;

//https://blog.csdn.net/liuhenghui5201/article/details/107811607
/**
 * @description:
 * @author: biankunpeng
 * @date: 2022/3/1 14:47
 */
public class 我的ZooKeeperTest {

    @Test
    public void test() throws Exception {
        //1, 创建zk连接
        ZooKeeper zooKeeper = new ZooKeeper("43.129.217.212:2182", 2000, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                System.out.println("收到监听：type:" + watchedEvent.getType() + ", Path:" + watchedEvent.getPath() + ", State:" + watchedEvent.getState());
            }
        });

        //2.创建父节点
//        String path = zooKeeper.create("/huizi",
//                "nodeValue".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE,  //
//                CreateMode.PERSISTENT);//四种模式
//        System.out.println("路径：" + path);

        //3.创建字节点
//        String childenPath = zooKeeper.create("/huizi/childenNode",
//                "childenNodeValue".getBytes(),
//                ZooDefs.Ids.OPEN_ACL_UNSAFE,  //
//                CreateMode.PERSISTENT);//四种模式
//        System.out.println("childenPath路径：" + childenPath);

        // 4，获取节点中的值（父节点和子节点）
        byte[] value = zooKeeper.getData("/huizi",false,null);
        System.out.println("p:"+new String(value));

        List<String> children = zooKeeper.getChildren("/huizi",false);
        for (String child : children) {
            System.out.println("c:" + child);
        }

        // 5.修改节点的值
//        zooKeeper.setData("/huizi","newValue".getBytes(),-1);
//        byte[] value5 = zooKeeper.getData("/huizi",false,null);
//        System.out.println("data:" + new String(value));

        // 6.判断某个节点是否存在
        Stat exits = zooKeeper.exists("/huizi/childenNode",false);
        System.out.println(exits);

        // 7.删除节点
        zooKeeper.delete("/huizi/childenNode",-1);
        Stat exists1 = zooKeeper.exists("/huizi/childenNode",false);
        System.out.println(exists1);
    }
}