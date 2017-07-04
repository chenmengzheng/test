package com.feidee.test.zk;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;

/**
 * //Chapter: 5.3.1 Java API -> 创建连接 -> 创建一个最基本的ZooKeeper对象实例
 * @author Administrator
 *
 */
/**
 * 
 * 
 * @author <a href="https://github.com/chenmengzheng">陈梦争</a>
 * @date
 */
public class ZooKeeperConstructor implements Watcher {
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);
    
    private final static String host = "172.22.23.180:2181";
    
    public static void main(String[] args) throws Exception{
        
        ZooKeeper zookeeper = new ZooKeeper(host, 
        									5000, //
        									new ZooKeeperConstructor());
        System.out.println(zookeeper.getState());
        //Receive watched event：WatchedEvent state:SyncConnected type:None path:null
        //ZooKeeper session established.
        try {
            connectedSemaphore.await();
        } catch (InterruptedException e) {}
        System.out.println("ZooKeeper session established.");
    }
    
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event：" + event);
        if (KeeperState.SyncConnected == event.getState()) {
            connectedSemaphore.countDown();
        }
    }
}