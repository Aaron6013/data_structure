package Sort.Quick_Sort;

/**
 * @author Aaron
 * @date 2020/4/11 - 10:43
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {50,10,90,30,70,40,80,60,20};
        qSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void qSort(int[] arr,int low,int high){

        if(low < high){
            int pivot = partition(arr,low,high);
        /*根据上次返回的pivotkey位置，将数组分成两部分，pivotkey前的均比pivotkey
          小，后面的均比他大。修改low和high值，再进行找pivotkey值*/
            qSort(arr,low,pivot-1);
            qSort(arr,pivot+1,high);
        }

    }

    public static int partition(int[] arr,int low,int high){
    /*第一次选取下标为0的元素为pivotkey，通过while循环后，比pivotkey小的元素
      在他的前面，比他大的在他后面，返回pivotkey所在位置的下标。第一次，low
      指向数组的下标为0的元素，high指向数组最后一个元素。*/
        int t;
        int pivotkey;

        /*三数取中改进*/
       int mid = (low + high) / 2;
       if(arr[low] > arr[high])
           swap(arr,low,high);
       if(arr[mid] > arr[high])
           swap(arr,mid,high);
       if(arr[low] < arr[mid])
           swap(arr,low,mid);
       //使以low为下标的值为中间值

       pivotkey = arr[low];

        while (low < high){
            while (low < high && arr[high] >= pivotkey)
                /*若high所指向元素比pivotkey大，则high向前移一位，直到找到比
                   pivotkey小的元素，交换pivotkey和其位置*/
                high--;

            //swap(arr,low,high);
            arr[low] = arr[high];

            while (low < high && arr[low] <= pivotkey)
                /*同上，从低位向前找比pivotkey大的元素，交换其位置*/
                low++;

           //wap(arr,low,high);
            arr[high] = arr[low];
        }
        arr[high] = pivotkey;
        return high;  //返回pivotkey所在位置（最终high和low相等）
    }

    public static void swap(int[] arr,int low,int high){
        int t = arr[low];
        arr[low] = arr[high];
        arr[high] = t;
    }
}
