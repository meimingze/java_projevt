package java_多线程.src.多线程1;

/**
 * @auther XMZ
 * @create 2023--04-14:48
 *
 * 测试Thread中的常用方法:
 * 1. start():启动当前线程，调用当前线程的run()
 * 2. run(): 通常需要重写Thread类的方法，将创建的线程要执行的操作生命在此方法中
 * 3. currentThread():静态方法，返回执行当前代码的线程
 * 4. getName():获取当前线程的名字
 * 5. setName():设置当前线程的名字
 * 6. yidle():释放当前cpu的执行权
 * 7. join():在线程a中调用线程b的join(),此时线程a就进入阻塞状态，知道线程b完全执行完以后，线程a才结束阻塞状态
 * 8. stop():已过时，当执行此方法时，强制结束当前线程(已过时)
 * 9.sleep(long millitime):让当前线程“睡眠”指定的millitime毫秒，在指定的millitime毫秒时间内，线程a才结束阻塞
 * 10.isAlive():判断线程是否存活
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY:10
 * MIN_PRIORITY:1
 * NORM_PRIORITY:5 -->默认优先级
 *2.如何获取和设置当前线程的优先级
 *  getPriority():获取线程的优先级
 *  setPriority(int p):设置线程的优先级
 *
 *  说明：高优先级的线程要抢占低优先级线程cpu的执行权，但是只是从概率上讲，高优先级的线程高概率的
 *  情况下被执行。并不意味着只有当高优先级的线程执行完之后才能执行低优先级
 */
class HelloThread extends Thread {
    @Override
    public void run() {
        for(int i = 0; i< 100; i++){
            if(i % 2  == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread();
        //分线程
        h1.setName("线程一");
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();
        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for(int i = 0; i< 100; i++){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
