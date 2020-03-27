package fei_bo_na_qie;
import java.util.Scanner;

public class Di_gui {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("请输入月份：");
        int month = s.nextInt();
        int i = Fbi(month);
        System.out.println(i);
    }

    public static int Fbi(int month){

        if (month < 2)
            return month == 0? 0:1;
        return  Fbi(month - 1) + Fbi(month - 2);
    }
}
