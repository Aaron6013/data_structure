package Sort.Bubble_Sort;

/**
 * @author Aaron
 * @date 2020/4/10 - 9:30
 */
public class BubbleSort1 {

    public static void main(String[] args) {
        int[] arr = {10,4,7,1,3,2,5,9,8};
        bubbleSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort1(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for(int j = i+1; j < len; j++){
                if(arr[i] > arr[j]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
}
