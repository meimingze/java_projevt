package java_多线程.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * //创建线程的方式三：实现Callable接口 ---JDK5.0新增
 * @auther XMZ
 * @create 2023--07-23:42
 *
 * 如何理解Callable接口的方式创建多线程的方式比Runnable强大
 * 1.call()是有返回值的
 * 2.call()可以抛出并捕获异常信息
 * 3.callable支持泛型
 */
//1.创建一个实现Callable的实现类
class NumThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作返回在call()中
    @Override
    public Object call() throws Exception {
        int sum  =0 ;
        for(int i  =0; i<=100; i++){
            if(i %2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将此Callable接口实现类的对象作为参数传递到FutureTask构造器中，创建FutureTask对象
        FutureTask futureTask = new FutureTask<>(numThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();
        try {
            //(获取Callable中call方法的返回值)
            //get方法的返回值即为FutureTask构造器参数Callable实现重写的call()的返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
