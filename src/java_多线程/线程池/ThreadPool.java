package java_多线程.线程池;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程池的方式四：使用线程池
 *
 * @auther XMZ
 * @create 2023--08-0:11
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<= 100; i++ ){
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for(int i =0;i<= 100; i++ ){
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //2.执行指定的线程的操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service.execute(new NumberThread());//适用于Runnable
        //3.关闭线程池
        service.shutdown();
    }
}