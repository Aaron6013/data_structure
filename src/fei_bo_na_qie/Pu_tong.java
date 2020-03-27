package fei_bo_na_qie;
import java.util.Scanner;
public class Pu_tong {

    public static void main(String[] args) {

        int sum  = 0;
        int num1 = 1;
        int num2 = 1;
        Scanner s = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = s.nextInt();

        if (month == 1 || month == 2){
            System.out.println(num1);
        }else{
            for(int i = 3;i <= month;i++){
                sum = num1 + num2;
                num1 = num2;
                num2 = sum;
            }
            System.out.println(sum);
        }
    }
}
