package Stack.biao_da_shi_zhuan_huan;
import java.util.Scanner;
import java.util.Stack;

public class Transfer {
/*中缀表达式转后缀表达式*/

    public static void main(String[] args) {

        Stack t = new Stack();
        Scanner s = new Scanner(System.in);

        System.out.println("请输入表达式：");
        String str = s.next();
        char[] c = str.toCharArray();  //可以不用转成字符数组，在字符串str基础上使用charAt(第几个字符)


        for(int i = 0;i < c.length;i++){

            if(c[i] >= '0' && c[i] <= '9'){  //判断是否为数字字符
                String c1 = String.valueOf(c[i]);  //将c[i]转成字符串类型
                int result = Integer.parseInt(c1);  //再将字符串类型的数字转成整型
                while(i < c.length - 1 && c[i+1] >= '0' && c[i+1] <= '9') {
                    /*判断数字是否为两位或多位数字，若是则按照上面方法将其转为整型，
                      并依次乘10转成真正的数字，并直接输出。例如：23。c[i]=2,c[i+1]=3,
                      将其都转为数字后，2*10+3=23。*/
                        String c2 = String.valueOf(c[i + 1]);
                        int c3 = Integer.parseInt(c2);
                        result = result * 10 + c3;
                        i = i + 1;
                }
                System.out.println(result);
            }else if(c[i] == ')'){  //若为），则出栈，出到（出来为止
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
                            System.out.println(p);  //+-的优先级低于*/，若栈顶为*/，则出栈
                        }
                    }while (!t.empty() && '(' != (char)t.peek()); //栈非空且栈顶元素不是（
                    t.push(c[i]);
                }
            }else if('*' == c[i] || '/' == c[i] || '(' == c[i]){  //*/(优先级高于任何，进栈
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
