package tu.lin_jie_jv_zhen;

import java.util.Scanner;

/**
 * @author Aaron
 * @date 2020/3/28 - 16:03
 */
public class CreateMGraph {
/*无向图*/
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("请输入顶点个数：");
        int num = s.nextInt();
        int[] arr = ding_dian(num);
        System.out.println("请输入边数：");
        int num1 = s.nextInt();
        int arr1[][] = lin_jie_jv_zhen(num1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < num1 - 1; i++) {
            for (int j = 0 ;j < num1 - 1; j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] ding_dian(int num){

        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[][] lin_jie_jv_zhen(int num1){

        Scanner s = new Scanner(System.in);
        int[][] arr1 = new int[num1][num1];
        for (int i = 0; i < num1 - 1; i++) {
            for (int j = 0;j < num1 - 1; j++) {
                arr1[i][j] = 65535;
            }
        }

        int p = 1;
        while (p < num1) {
            System.out.println("输入边（vi,vj）上的下标i，下标j和权w(按顺序按回车键结束一次输入):");
            int i = s.nextInt();
            int j = s.nextInt();
            int quan = s.nextInt();
            arr1[i][j] = quan;
            arr1[j][i] = arr1[i][j]; //无向为对称矩阵
            p++;
        }
        return arr1;
    }
}
