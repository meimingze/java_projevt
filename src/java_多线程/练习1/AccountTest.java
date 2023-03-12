package java_多线程.练习1;

/**
 * @auther XMZ
 * @create 2023--07-18:09
 */
class Account{
    private double balance;
    public Account() {
        this.balance = balance;
    }
    public synchronized void deposit(double amt){
        if(amt > 0){
            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("存钱成功，金额为： "+balance);
        }
    }
}
class Customer extends  Thread{
    private Account account;
    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i = 0; i < 3; i ++){
            account.deposit(1000);
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);
        c1.setName("线程一");
        c2.setName("线程二");
        c1.start();
        c2.start();

    }
}
