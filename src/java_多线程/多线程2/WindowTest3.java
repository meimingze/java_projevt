package java_多线程.多线程2;

/**
 * @auther XMZ
 * @create 2023--06-12:08
 */
class window3 implements Runnable{
    private int ticket =100;
    private boolean flag = true;
    @Override
    public  void run() {
        while(flag) {
            show();
            }
    }
    private static synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": " + ticket);
            ticket--;
        } else{
            flag = false;
        }
    }
}
public class WindowTest3 {
    public static void main(String[] args) {
        window3 w = new window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        t1.start();
        t2.start();
        t3.start();
    }

}
