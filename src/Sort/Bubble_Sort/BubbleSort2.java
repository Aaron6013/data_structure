package Sort.Bubble_Sort;

/**
 * @author Aaron
 * @date 2020/4/10 - 9:51
 */
public class BubbleSort2 {

    public static void main(String[] args) {

        int[] arr = {10,4,7,1,3,2,5,9,8};
        bubbleSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void bubbleSort2(int[] arr){

        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for(int j = len - 2; j >= i; j--){
                if(arr[j+1] < arr[j]){
                    int t = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
}
