package java_多线程.多线程2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 --- JDK5.0新增
 *
 * 1.面试题：synchronized 与 lock的异同
 * 相同：二者都可以解决线程安全的问题
 * 不同：synchronized机制在执行完相应的同步代码以后，自动释放同步监视器
 * Lock需要手动的启动同步(lock()),同时结束同步也需要手动的实现（unlock()）
 *
 * 优先使用顺寻：LOCK -> 同步代码块（已进入方法并分配资源） -> 同步方法（未进入方法）
 * @auther XMZ
 * @create 2023--06-20:22
 */
class window implements Runnable{
    private  int ticket = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try {
                //2.调用锁定方法
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "票号为:" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3.调用解锁方法
                lock.unlock();
            }
        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        window w = new window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.setName("c1");
        t2.setName("c2");
        t3.setName("c3");
        t1.start();
        t2.start();
        t3.start();
    }

}

