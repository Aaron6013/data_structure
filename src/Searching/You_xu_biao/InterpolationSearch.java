package Searching.You_xu_biao;

/**
 * @author Aaron
 * @date 2020/4/5 - 10:32
 */
public class InterpolationSearch {
    /*插值查找，和二分查找主要区别在于mid值的修改*/
    public static void main(String[] args) {

        int[] arr = {1,16,24,35,47,59,62,73,88,99};
        System.out.println(searching(62,arr));
    }

    public static int searching(int value,int[] arr){

        int len = arr.length;
        int low = 0;
        int high = len - 1;

        while (low <= high){
            int mid = low + (high - low) * (value - arr[low]) / (arr[high] - arr[low]);
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
