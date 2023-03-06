package java_多线程.src.多线程1;

/**
 *创建多线程的方式二：
 * 1.创建一个实现runnable接口的类
 * 2.实现类去实现runnable中的抽象方法：run（）
 * 3.创建实现类的对象
 * 4，将此对象作为参数传递到Thread类的构造器中，创建Thread对象
 * 5.通过Thread类的对象调用start（）
 *
 *
 * 比较创建线程的两种方式：
 * 开发中：有限选择：实现Runnable接口的方式
 * 原因：1.实现的方式没有类的单继承性的局限性
 *      2.实现的方式更适合来处理多个线程有共享数据的情况
 *
 * 联系：public class Thread implements Runnable
 * 相同点：两种方法都要重写run(),将线程要执行的逻辑声明在run()中
 *
 * @auther XMZ
 * @create 2023--04-16:19
 */
class Mthread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i< 100;i++){
             if(i % 2== 0){
                 System.out.println(Thread.currentThread().getName()+i);
             }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        //3，创建实现类的对象
        Mthread mthread = new Mthread();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mthread);
        Thread t2 = new Thread(mthread);
        //5，通过Thread类的对象调用start():1,启动线程 2. 调用当前线程的run()
        t1.start();
        t2.start();

    }
}
