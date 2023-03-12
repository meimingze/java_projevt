package java_常用类.src.com.atguigu.一些算法题目;

/**
 * @auther XMZ
 * @create 2023--11-11:11
 */
public class StringDemo {
    public static void main(String[] args) {
        StringDemo sd = new StringDemo();
        String tset = "abcdefg";
        System.out.println(sd.reverse(tset,2,3));
    }
    //将一个字符串进行反转

    //法一
    public String reverse(String str,int start,int end){
        if(str == null){
            return null;
        }
        char[] s1 = str.toCharArray();
        while (start < end){
            char temp = s1[start];
            s1[start] = s1[end];
            s1[end] = temp;
            start++;
            end--;
        }
        return new String(s1);
    }
    public String reverse1(String str, int start,int end){
        if(str == null){
            return null;
        }
        String s2 = str.substring(0,start);
        for (int i = end; i >= start; i--){
            s2 += str.charAt(i);
        }
        //从当前位置到str的最后
        s2 += str.substring(end+ +1);
    return s2;
    }
    public String reverse2(String str, int start,int end) {
        if(str != null){
            StringBuilder sb = new StringBuilder(str.length());
            // 第一部分
            sb.append(str.substring(0,start));
            for(int i =end; i >= start; i -- ){
                sb.append(str.charAt(i));
            }
            sb.append(str.substring(end + 1));
            return sb.toString();
        }
        return null;
    }

}
