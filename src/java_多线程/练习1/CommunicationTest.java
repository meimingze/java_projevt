package java_多线程.练习1;

/**
 * 线程通信的例子：使用两个线程打印1-100，线程1、2交替打印
 *
 * 设计到的三个方法：
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器（其他的线程可以拿到同步监视器，并进入到代码中）
 * notify()：一旦执行此方法，就会唤醒被wait的一个线程（若有多个，则为优先级高的）
 * notifyAll()：一旦执行此方法，唤醒所有线程
 *
 * 说明：1.三个方法都必须使用在同步代码块，或者同步方法中
 * 2.三个方法的调用者必须是同步代码块或同步方法中的同步监视器，否则会出现ILLegaLMonitorStateException异常
 * 3.三个方法是定义在java.lang.Object类中的
 *
 * 面试题 ：sleep()和wait()的异同：
 * 1.相同点：一旦执行方法，都可以使当前线程进入阻塞状态
 *  * 2，不同点:1)两个方法声明位置不同，Thread类中声明sleep(),Object类中声明wait()
 *  *         2)调用的要求不同：sleep()可以在任何需要的场景下使用，wait()必须在同步代码块中调用
 *            3）关于是否释放同步监视器的问题，如果两个方法都使用在同步代码块或同步方法中，sleep()不会会释放同步监视器wait()会释放同步监视器
 *
 * @auther XMZ
 * @create 2023--07-18:54
 */
class number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                //notify为唤醒一个线程，notifyAll为全部唤醒
                //此处为一个线程唤醒另一个线程，实现线程交替
                notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                    number++;
                    try {
                        //使得调用如下wait()方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    break;
                }
            }
        }
    }
}
public class CommunicationTest {
    public static void main(String[] args) {
        number n1 = new number();
        Thread t1 = new Thread(n1);
        Thread t2 = new Thread(n1);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
    }
}
