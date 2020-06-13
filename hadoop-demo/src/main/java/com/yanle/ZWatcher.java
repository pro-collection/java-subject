package com.yanle;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class ZWatcher implements Watcher {
    public void process(WatchedEvent event) {
        // TODO Auto-generated method stub
        if(event.getType() == Event.EventType.NodeCreated){
            System.out.println("创建节点");
        }
        if(event.getType() == Event.EventType.NodeDataChanged){
            System.out.println("节点改变");
        }
        if(event.getType() == Event.EventType.NodeChildrenChanged){
            System.out.println("子节点改变");
        }
        if(event.getType() == Event.EventType.NodeDeleted){
            System.out.println("节点删除");
        }
    }
}