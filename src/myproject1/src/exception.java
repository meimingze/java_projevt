package myproject1.src;

public class exception {
    public static void main(String[] args) throws Exception {

    }
    public static void login(String account,String password){
        if(!"admin".equals(account)){

        }
        if(!"admin".equals(password)){

        }
    }
}
class LoginException extends RuntimeException{
    public LoginException(String message){
        super(message);
    }
}
