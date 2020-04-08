package Searching.You_xu_biao;

/**
 * @author Aaron
 * @date 2020/4/5 - 9:30
 */
public class BinarySearch {
/*折半查找（二分查找）要求为有序，且采用线性存储（数组）*/
    public static void main(String[] args) {

        int[] arr = {1,16,24,35,47,59,62,73,88,99};
        System.out.println(searching(62,arr));
    }

    public static int searching(int value,int[] arr){

        int len = arr.length;
        int low = 0;
        int high = len - 1;

        while (low <= high){
            int mid = (low + high) / 2;
            if(value < arr[mid]){
                high = mid - 1;
            }else if(value > arr[mid]){
                low = mid + 1;
            }else
                return mid + 1; //从0开始，所以要查找的元素应在第（mid+1）个位置
        }
        return 0;
    }
}
