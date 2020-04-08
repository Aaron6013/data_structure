package Searching.You_xu_biao;
import java.util.ArrayList;

/**
 * @author Aaron
 * @date 2020/4/5 - 11:02
 */
public class FibonacciSearch {

    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add(16);
        arr.add(24);
        arr.add(35);
        arr.add(47);
        arr.add(59);
        arr.add(62);
        arr.add(73);
        arr.add(88);
        arr.add(99);
        System.out.println(searching(62,arr));
    }

    public static int searching(int value,ArrayList arr) {

        int low = 0;
        int len = arr.size();
        int high = len - 1;
        int k = 0;
        int[] f = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34}; //斐波那契数列

        while (len > f[k]) {  //计算查找数组长度在斐波那契中的位置
            k++;
        }

        for (int i = len; i < f[k]; i++) { //将查找数组的长度补充到f[k]（-1是由于数组下标从0开始）
            arr.add(arr.get(high));
        }

        while (low <= high) {
            int mid = low + f[k - 1];
            if (value < (int)arr.get(mid)) {
                high = mid - 1;
                k = k - 1;
            } else if (value > (int)arr.get(mid)) {
                low = mid + 1;
                k = k - 2;
            } else {
                if (mid <= high)
                    return mid + 1;
                else
                    return high;
            }
        }
        return 0;
    }
}
