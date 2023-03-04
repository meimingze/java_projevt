import org.junit.jupiter.api.Test;

public class String2 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        s.append("abc");
        System.out.println(s.reverse());
        System.out.println(s.insert(1,"d"));
    }
}
