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
                i = i - j + 1;  //没有匹配成功，i返回到i上一次开始位置的下一个位置
                j = 0;
            }
        }
        /*匹配成功也可写成
        if(j > s2.length())  成功匹配后，j的值一定大于s2的长度
            return i - s2.length();
        else  
            return -1;
         */
        return -1; //执行到这一步意味着没有匹配
    }
}
