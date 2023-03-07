package java_设计模式;

import java.time.Instant;

/**
 * 单例模式的懒汉式实现
 *
 * @auther XMZ
 * @create 2023--06-16:58
 */
public class SingletonTest2 {
    public static void main(String[] args) {

    }
}
class Order{
    //1.私有化类的构造器
    private Order(){

    }
    //2.声明当前类的对象，没有初始化
    private static Order instance = null;

    //3.声明public、static的返回当前类的对象的方法
    public static Order getInstance(){
        if(instance == null){
            new Order();
        }
        return instance;
    }
}