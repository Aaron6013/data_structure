package Sort.Straight_Insertion_sort;

/**
 * @author Aaron
 * @date 2020/4/10 - 11:15
 */
public class insertSort {

    public static void main(String[] args) {
        int[] arr = {0,10,4,7,1,3,2,5,9,8};  //下标为0的元素默认为0
        insertSort(arr);
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void insertSort(int[] arr){

        int len = arr.length;
        for (int i = 2; i < len; i++) {
            if(arr[i] < arr[i-1]){
                arr[0] = arr[i];
                int j;
                for (j = i - 1; arr[j] > arr[0]; j--){
                    arr[j+1] = arr[j];
                }
                arr[j+1] = arr[0];
            }
        }
    }
}
