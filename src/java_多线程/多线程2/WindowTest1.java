package java_多线程.多线程2;

/**
 * @auther XMZ
 * @create 2023--04-16:34
 *方式一：同步代码块
 * synchronized(同步监视器){
 *     //需要被同步的代码
 * }
 * 说明：1.操作共享数据的代码
 * 2.共享数据（ticket）
 * 3.同步监视器（锁），任何一个类的对象，都可以充当锁
    要求：多个线程必须要共用同一把锁
 （在实现Runnable接口创建多线程的方式中，我们可以考虑使用this充当监视器）

 方式二：同步方法
    若操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法生命同步的

 5.好处：同步的方式，解决了线程安全问题
  操作同步代码是，只能有一个线程参与，相当于单线程，效率低
 */
class window1 implements Runnable{
    private int ticket =100;
    Object obj = new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class    WindowTest1 {
    public static void main(String[] args) {
        window1 w = new window1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }

}
