package com.leospiritlee.thread;

import java.util.Arrays;

/**
 * @Project: CodeSegment
 * @ClassName DemoState
 * @description: thread state
 * @see Thread.State
 * @author: leospiritlee
 * @create: 2020-06-20 10:08
 *
 *    NEW 初始化线程
 *    RUNNABLE  包含ready 和running 两个动作
 *    BLOCKED 阻塞状态， 处理BLOCKED状态的线程正等待锁的释放进入同步区
 *    WAITING 等待状态， 处理WAITING状态的线程 需要其它线程唤醒。
 *       以下3个方法会使线程进入等待状态
 *              Object.wait()   使当前线程处于等待状态，直到另外一个线程唤醒它
 *              Thread.join()   等待线程执行完毕，底层调用的是Object实例的wait方法
 *              LockSupport.park()  除非获得调用许可，否则禁用当前线程进行线程调度
 *
 *              你等了好几分钟现在终于轮到你了，突然你们有一个“不懂事”的经理突然来了。你看到他你就有一种不祥的预感，果然，他是来找你的。
 *              他把你拉到一旁叫你待会儿再吃饭，说他下午要去作报告，赶紧来找你了解一下项目的情况。你心里虽然有一万个不愿意但是你还是从食堂窗口走开了。
 *              此时，假设你还是线程t2，你的经理是线程t1。虽然你此时都占有锁（窗口）了，“不速之客”来了你还是得释放掉锁。
 *                      此时你t2的状态就是WAITING。然后经理t1获得锁，进入RUNNABLE状态。
 *                      要是经理t1不主动唤醒你t2（notify、notifyAll..），可以说你t2只能一直等待了。
 *   TIMED_WAITING 超时等待状态  线程等待一个具体时间，时间到了会被唤醒。
 *      以下方法会使线程进入超时等待状态
 *              Thread.sleep(long millis) 使当前线程休眠指定时间
 *              Object.wait(long timeout) 线程休眠指定时间 milliseconds，等待时间可以通过 notify() 或者 notifyAll()唤醒
 *              Thread.join(long millis)  等待当前线程最多执行millis， 如果millis = 0  会一直执行
 *              LockSupport.parkNanos(long nanos)  除非获得调用许可，否则禁用当前线程进行线程调度指定时间；
 *              LockSupport.parkUntil(long deadline)：同上，也是禁止线程进行调度指定时间；
 *
 *              到了第二天中午，又到了饭点，你还是到了窗口前。
 *              突然间想起你的同事叫你等他一起，他说让你等他十分钟他改个bug。
 *              好吧，你说那你就等等吧，你就离开了窗口。很快十分钟过去了，你见他还没来，你想都等了这么久了还不来，那你还是先去吃饭好了。
 *              这时你还是线程t1，你改bug的同事是线程t2。t2让t1等待了指定时间，此时t1等待期间就属于TIMED_WAITING状态。
 *              t1等待10分钟后，就自动唤醒，拥有了去争夺锁的资格。
 *
 *  TERMINATED 终止状态，此时线程已经执行完毕。
 *
 **/
public class DemoState {

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
        });
        System.out.println("current state :" +thread.getState());
        System.out.println("current stackTrace :" + Arrays.toString(thread.getStackTrace()));
    }
}
