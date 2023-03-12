package java_常用类.src.com.atguigu.一些算法题目;

/**
 * @auther XMZ
 * @create 2023--12-18:43
 */
public class StringDemo1 {
    public int count(String mainstr,String substr ) {
        int mainLength = mainstr.length();
        int sublength = substr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= sublength) {
            while((index = mainstr.indexOf(substr)) != -1) {
                count++;
                mainstr = mainstr.substring(index + substr.length());
            }
            return count;
        } else {
            return 0;
        }

    }
}

