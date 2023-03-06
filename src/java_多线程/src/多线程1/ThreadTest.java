package java_多线程.src.多线程1;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread的run() -->将此线程的操作写在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 *
 * 例子：遍历100以内的所有偶数
 * @auther XMZ=
 * @create 2023--02-20:36
 */
//1.创建一个继承于Thread类的子类
class MyThread extends Thread{
    //2.重写
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i % 2 == 0){
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                 System.out.println(i);
            }
        }
    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
        MyThread t1 = new MyThread();

        //通过此对象调用start()：1.启动当前线程 2.调用当前线程的run()
        t1.start();
        //注意：
        // 1.不能调用run方法启动线程
        // 2.

        //如下方法仍然是在main线程中运行的
        for(int i = 0; i< 100; i++){
            if(i % 2 == 0){
                System.out.println(i +"***main***");
            }
        }
    }
}
