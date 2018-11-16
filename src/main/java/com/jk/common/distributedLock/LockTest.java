package com.jk.common.distributedLock;

import org.springframework.beans.factory.annotation.Autowired;

public class LockTest {

    @Autowired
    DistributedLockHandler distributedLockHandler;

    public void test(){
        //全局分布式锁 redis setnx
        Lock lock=new Lock("lockk","ssssssss");
        if(distributedLockHandler.tryLock(lock)){
            distributedLockHandler.releaseLock(lock);
        }
    }

}
