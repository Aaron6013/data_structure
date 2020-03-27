package zhan.biao_da_shi_zhuan_huan;
import java.util.Scanner;
import java.util.Stack;

public class Change {

    public static void main(String[] args) {

        Stack t = new Stack();
        Scanner s = new Scanner(System.in);

        System.out.println("请输入表达式：");
        String str = s.next();
        char[] c = str.toCharArray();  //可以不用转成字符数组，在字符串str基础上使用charAt(第几个字符)


        for(int i = 0;i < c.length;i++){

            if(c[i] >= '0' && c[i] <= '9'){
                String c1 = String.valueOf(c[i]);
                int result = Integer.parseInt(c1);
                while(i < c.length - 1 && c[i+1] >= '0' && c[i+1] <= '9') {
                        String c2 = String.valueOf(c[i + 1]);
                        int c3 = Integer.parseInt(c2);
                        result = result * 10 + c3;
                        i = i + 1;
                }
                System.out.println(result);
            }else if(c[i] == ')'){
                char a = (char) t.pop();
                while (a != '('){  //输入为右括号，出栈，直到左括号出现
                    System.out.println(a);
                    a = (char)t.pop();
                }
            }else if(c[i] == '+' || c[i] == '-'){  //输入为+-
                if(t.empty()){ // 栈若为空，则直接进栈
                    t.push(c[i]);
                }else {
                    do{
                        char p = (char)t.pop();  //先取出栈顶元素
                        if(p == '('){
                            t.push(p);   //如果栈顶元素是（，则再把它放进去
                        }else{
                            System.out.println(p);
                        }
                    }while (!t.empty() && '(' != (char)t.peek()); //栈非空且栈顶元素不是（
                    t.push(c[i]);
                }
            }else if('*' == c[i] || '/' == c[i] || '(' == c[i]){
                t.push(c[i]);
            }else{
                System.out.println("输入错误");
            }
        }
        while (!t.empty()){
            System.out.println(t.pop());  //最后将所有元素弹出
        }
    }
}
