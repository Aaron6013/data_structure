package Stack.biao_da_shi_zhuan_huan;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Aaron
 * @date 2020/3/26 - 13:29
 */
public class Computer {
/*输入一个后缀表达式，计算（数与数，数与符号，符号与符号之间用,隔开）*/
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Stack t = new Stack();
        System.out.println("请输入后缀表达式：");
        String str = s.next();
        char[] c = str.toCharArray();

        for (int i = 0; i < c.length; i++) {

            if(c[i] == ','){
                continue;
            }else if(c[i] >= '0' && c[i] <= '9'){
                /*同Transfer的方法，判断一个数字为几位，并入栈*/
                String c1 = String.valueOf(c[i]);
                int result = Integer.parseInt(c1);
                while(i < c.length - 1 && c[i+1] >= '0' && c[i+1] <= '9') {
                    String c2 = String.valueOf(c[i + 1]);
                    int c3 = Integer.parseInt(c2);
                    result = result * 10 + c3;
                    i = i + 1;
                }
                t.push(result);
            /*加减乘除均将栈顶的两个元素出栈并进行相应计算*/
            }else if('+' == c[i] ){
                int a1 = (int)t.pop();
                int a2 = (int)t.pop();
                int a3 = a2 + a1;
                t.push(a3);
            }else if('-' == c[i] ){
                int a1 = (int)t.pop();
                int a2 = (int)t.pop();
                int a3 = a2 - a1;
                t.push(a3);
            }else if('*' == c[i] ){
                int a1 = (int)t.pop();
                int a2 = (int)t.pop();
                int a3 = a2 * a1;
                t.push(a3);
            }else if('/' == c[i] ){
                int a1 = (int)t.pop();
                int a2 = (int)t.pop();
                int a3 = a2 / a1;
                t.push(a3);
            }else{
                System.out.println("输入错误");
            }
        }
        System.out.println(t.pop());
    }
}
