package java_多线程.多线程2;

/**
 * @auther XMZ
 * @create 2023--06-16:20
 */
public class BankTest {
}
class Bank{
    private Bank(){}
    private static  Bank instance = null;
    //此处为懒汉式单例设计，使用”synchronized“关键字，使线程不能同时创建对象，只能是第一个线程进去并创建对象返回对象后，其他线程再逐个进去，同时instance
    //在经历第一个线程之后，已经被创建出来，不再是null，故其他线程直接返回instance
    public static Bank getInstance(){
        // 方式一：效率稍差
        /*synchronized (Bank.class) {
            if(instance == null){
                instance = new Bank();
            }
            return instance;
        }*/

        //方式二：效率更高
        if(instance == null){
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}