package myproject1.src;

import java.util.Locale;

public class zifuchuan {
    public static void main(String[] args) {
        /**
         * 拼接字符串
         */
        String s = 1 + "abv" +2;
        System.out.println(s.hashCode());
        s.concat("abs");
        String a = "a";
        String b = "A";
        String s1 = "Hello world";
        s1.substring(0,3);
        String[] s2 = s1.split("o");
        for(String s3 : s2){
            System.out.println(s3);
        }
        String classname = "user";
        String a1 = classname.substring(0,1);
        String a2 = classname.substring(1);
        String newclassname = a1.toUpperCase() + a2;
        System.out.println(newclassname);
        System.out.println(s1.indexOf("Hello"));
    }
}
