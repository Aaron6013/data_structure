package String;
/**
 * @author Aaron
 * @date 2020/3/27 - 9:56
 */
public class Pu_shu {

    public static void main(String[] args) {
        String s1 = "goodgoogle";
        String s2 = "le";  //字符串的索引开始为0
        System.out.println(find(s1,s2));
    }

    public static int find(String s1,String s2){
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()){

            if(s2.charAt(j) == s1.charAt(i)){
                i++;   //i为s1的指针
                j++;  //j为s2的指针
                if(j == s2.length()){  //此时匹配完全，返回值
                    return i - j;
                }
            }else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1; //执行到这一步意味着没有匹配
    }
}
