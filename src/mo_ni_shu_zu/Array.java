package mo_ni_shu_zu;
/*定义一个数组类*/

public class Array {

    int len; //数组长度
    int cnt; //有效元素的个数
    int[] arr;
    int remove_value; //记录删除的元素的值

    public Array(int len) {
        cnt = 0;  //有效元素个数刚开始为0,以cnt为下标的位置无值
        this.len = len;
        arr = new int[len];  //初始化数组，长度为len，值都为0
    }


    /*判断数组是否为空*/
    public boolean is_empty() {
        if (cnt == 0)
            return true;
        else
            return false;
    }

    /*输出数组*/
    public void show_Array() throws EmptyException{

        if(is_empty()){
            throw new EmptyException("数组为空，无法输出");
        }else{
            for(int i = 0;i < cnt;i++){
                System.out.println(arr[i]);
            }
        }
    }

    /*判断数组是否满*/
    public boolean is_full(){
        if (cnt == len)
            return true;
        else
            return  false;
    }

    /*数组追加元素*/
    public boolean append_Array (int value) throws FullException {

        if (is_full()) {
            throw new FullException("数组已满，无法追加");
        }else{
            arr[cnt] = value;
            cnt++;
            return true;
        }
    }

    /*在某个特定位置添加元素*/
    public boolean insert_Array(int pos,int value) throws FullException {

        if (is_full()) {
            throw new FullException("数组已满，无法添加");
        }else{
            /*例如要在第三个位置添加，实际上是在下标为2的地方添加，
              从最后一个位置的元素到下标为2的元素，依次向后移一位，
              先移后添加
            */
            for(int i = cnt;i > pos - 1; i--){
                arr[i] = arr[i-1];
            }
            arr[pos - 1] = value;
            cnt++;  //添加后数组元素多一个，故++
            return true;
        }
    }

    /*删除某个位置元素*/
    public boolean delect_Array(int pos)throws EmptyException{

        if(is_empty()) {
            throw new EmptyException("数组为空，无法删除");
        }else if(pos < 1 || cnt < pos){  //若要删除的位置小于1或者大于数组有效元素的个数，则报错
            return false;
        } else{
            /*同在某个位置添加元素，不同的先将元素删除，再把后面位置的元素依次向前移一位*/
            remove_value = arr[pos - 1];
            for(int i = pos;i < cnt;i++) {
                  arr[i - 1] = arr[i];
               }
	    cnt--;
        }
        return true;
    }

    /*数组元素倒置，此方法适用于有效元素个数为奇数或偶数*/
    public void inversion_Array(){

        int i = 0;
        int j = cnt - 1;  //最后一个元素的下标为cnt-1
        int t;
        while(i < j){
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    /*使用冒泡排序对数组进行排序（从小到大）*/
    public void sort_Array(){

        int t;
        for(int i = cnt - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if(arr[j] > arr[j+1]){
                    t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                }
            }
        }
    }
}