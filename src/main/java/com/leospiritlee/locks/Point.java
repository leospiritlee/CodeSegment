package com.leospiritlee.locks;

import java.util.concurrent.locks.StampedLock;

/**
 * @Project: CodeSegment
 * @ClassName Point
 * @description: StampedLock 的用法
 *  支持读写锁
 *  支持乐观读锁
 *  支持悲观读锁
 *  在读的时候如果发生了写，应该通过重试的方式来获取新的值，而不应该阻塞写操作。
 *  这种模式也就是典型的无锁编程思想，和CAS自旋的思想一样
 *  这种操作方式决定了StampedLock在读线程非常多而写线程非常少的场景下非常适用，
 *  同时还避免了写饥饿情况的发生。
 *
 * @author: leospiritlee
 * @create: 2020-06-21 17:07
 **/
public class Point {

    private double x,y;
    private final StampedLock stampedLock = new StampedLock();

    /**
     *  写锁的运用
     * @param deltaX
     * @param deltaY
     */
    void move(double deltaX, double deltaY){
        //获取写锁
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;

        }finally {
            //释放写锁
            stampedLock.unlockWrite(stamp);
        }

    }

    /**
     * 乐观读锁的运用
     * 乐观读锁的意思就是先假定在这个锁获取期间，共享变量不会被改变，既然假定不会被改变，那就不需要上锁。
     *      在获取乐观读锁之后进行了一些操作，然后又调用了validate方法，这个方法就是用来验证tryOptimisticRead之后，是否有写操作执行过，
     *          如果有，则获取一个悲观读锁，这里的悲观读锁和ReentrantReadWriteLock中的读锁类似，也是个共享锁。
     *
     */
    double distanceFromOrigin(){
        //获取乐观读锁
        long stamp = stampedLock.tryOptimisticRead();
        double currentX = x, currentY = y;
        //检查乐观读锁后是否有其它写锁发生，有则返回false
        if(!stampedLock.validate(stamp)){
            //获取一个悲观读锁
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            }finally {
                //释放悲观读锁
                stampedLock.unlockRead(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY * currentY);
    }


    /**
     * 悲观读锁以及读锁升级写锁的使用
     * @param newX
     * @param newY
     */
    void moveIfAtOrigin(double newX, double newY){
        //获取一个悲观读锁
        long stamp = stampedLock.readLock();
        try {
            while (x == 0.0 && y == 0.0){
                //读锁尝试转为写锁，转换成功后，相当于获取了写锁，转化失败相当于写锁被占用
                long ws = stampedLock.tryConvertToWriteLock(stamp);
                //获取写锁成功
                if(ws != 0L){
                    //读锁票据更新为写锁
                    stamp = ws;

                    x = newX;
                    y = newY;
                    break;
                }else {
                    //如果转化失败

                    //释放读锁
                    stampedLock.unlockRead(stamp);
                    //强制获取写锁
                    stamp = stampedLock.writeLock();
                }

            }



        }finally {
            //释放所有锁
            stampedLock.unlock(stamp);
        }


    }

}
