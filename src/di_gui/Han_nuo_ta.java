/*
    刚开始左边柱子有n个盘子，中间和右边柱子上没有盘子
    若n=1，则直接将这个盘子移到右边柱子。否则，先将n-1个盘子通过右边柱子移到中间
    柱子（现在中间柱子有n-1个盘子），然后把左边柱子上剩的最后一个盘子（最大）移到
    右边柱子，最后在调用函数将中间的n-1个盘子移动（注意，此时中间柱子相当于刚开始
    的左边柱子）。
 */
package di_gui;
import java.util.Scanner;
public class Han_nuo_ta {

    public static void main(String[] args) {

        String A = "左边柱子";
        String B = "中间柱子";
        String C = "右边柱子";

        Scanner s = new Scanner(System.in);
        System.out.println("请输入盘子个数：");
        int num = s.nextInt();
        hannuota(num,A,B,C);
    }

    public static void hannuota(int n,String A,String B,String C){
        //hannuota(盘子个数，盘子所在柱子，通过的柱子，最后移到的柱子)

        if(1 == n){
            System.out.println("将编号为" + n + "的盘子从" + A + "移到" + C);
        }else{
            hannuota(n-1,A,C,B);  //此时n-1个盘子都在A上，通过C,来将其移到B
            System.out.println("将编号为" + n + "的盘子从" + A + "移到" + C);
            hannuota(n-1,B,A,C); //上一步将n-1个盘子移到了B，现在盘子都在B，将这些盘子通过A移到C
        }
    }
}
