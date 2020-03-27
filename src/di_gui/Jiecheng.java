package di_gui;

public class Jiecheng {

    public static void main(String[] args) {

        int val = f(5); //实际应用用应考虑int的范围，超出范围可使用如long接收
        System.out.println(val);
    }

    public static int f(int i ){

        if (i == 1)
            return 1;
        else
            return i * f(i-1);
    }
}
