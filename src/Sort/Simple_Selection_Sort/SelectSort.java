package Sort.Simple_Selection_Sort;

/**
 * @author Aaron
 * @date 2020/4/10 - 10:27
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {10,4,7,1,3,2,5,9,8};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void selectSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for(int j = i+1; j < len; j++){  //j<len等同于j<=len-1
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(min != i){
                int t = arr[i];
                arr[i] = arr[min];
                arr[min] = t;
            }
        }
    }
}
