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
    public static Bank getInstance(){
        if(instance == null){
            instance = new Bank();
            return instance;
        }
    }
}