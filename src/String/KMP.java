package String;

/**
 * @author Aaron
 * @date 2020/3/27 - 11:58
 */
public class KMP {

    public static void main(String[] args) {

        String s1 = "goodgoogle";
        String s2 = "google";
        int[] next = get_next(s2); //next={-1,0,0,0,1,0}
        System.out.println(find(s1,s2,next));
    }

    public static int[] get_next(String s2){
    //这里的next[0]等同于书上的next[1]，-1等同于0，0等同于1
        int i = 0; //i指向后缀
        int j = -1; //j指向前缀
        int len = s2.length();
        int[] next = new int[len];  //next数组长度和s2字符串长度一样，且索引都从0开始
        next[0] = -1;
        while (i < len - 1){
            if(j == -1 || s2.charAt(i) == s2.charAt(j)){
                ++i;
                ++j;
                next[i] = j;
            }else {
                j = next[j];
            }
        }
        return next;
    }

    public static int find(String s1,String s2,int[] next){
        int i = 0;
        int j = 0;

        while (i < s1.length() && j < s2.length()){

            if(j == -1 || s2.charAt(j) == s1.charAt(i)){
            /*0-2元素都相同，s2.3=g,s1.3=d，此时不相等，i为3不变，j=next[3]=0,
              s2.0=g继续不相等，j=next[0]=-1，此时满足j=-1条件，i++=4,j++0，
              再继续比较。
             */
                i++;   //i为s1的指针
                j++;  //j为s2的指针
                if(j == s2.length()){  //此时匹配完全，返回值
                    return i - j;
                }
            }else {
               j = next[j];
            }
        }
        return -1; //执行到这一步意味着没有匹配
    }
}
