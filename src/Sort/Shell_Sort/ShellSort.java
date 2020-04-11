package Sort.Shell_Sort;

/**
 * @author Aaron
 * @date 2020/4/10 - 12:08
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {0,10,4,7,1,3,2,5,9,8};  //下标为0的元素默认为0
        shellSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public static void shellSort(int[] arr){
        int increment = arr.length;
        do{
            increment = increment / 3 + 1;
            for (int i = increment; i < arr.length; i++) {
                int j;
                if(arr[i] < arr[i-increment]){
                    arr[0] = arr[i];
                    for(j = i - increment; j > 0 && arr[0] < arr[j]; j -= increment){
                        arr[j+increment] = arr[j];
                    }
                    arr[j+increment] = arr[0];
                }
            }
        }while (increment > 1);
    }
}

