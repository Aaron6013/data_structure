package Sort.Heap_Sort;

/**
 * @author Aaron
 * @date 2020/4/10 - 17:04
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {0,50,10,90,30,70,40,80,60,20};
        sort(arr,arr.length-1);
        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr, int len){

        //构建大顶堆，之前的树是按数组下标依次建的，故下标比len/2小的结点有孩子
        for(int j = len/2; j > 0; j--){
            heapAdjust(arr,j,len);
        }

        for (int i = len; i > 1; i--) {
            //将根（最大值）和最后面一个结点值互换，再将除最大值外的结点构建大顶堆
            int t = arr[i];
            arr[i] = arr[1];
            arr[1] = t;
            heapAdjust(arr,1,i-1);
        }
    }

    /*构建大顶堆*/
    public static void heapAdjust(int[] arr,int s,int len){

        int t = arr[s];
        for(int i = 2 * s; i <= len; i *= 2){
            //2*s和2*s+1为s的左右孩子，最终是这三个结点中，值最大的为根结点
            if(i < len && arr[i] < arr[i+1])
                i = i + 1;
            if(arr[s] > arr[i])
                break;
            arr[s] = arr[i];
            s = i;
            arr[s] = t;
        }
    }
}
