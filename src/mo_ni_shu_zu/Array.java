package mo_ni_shu_zu;
/*定义一个数组类*/

public class Array {

    int len; //数组长度
    int cnt; //有效元素的个数
    int [] name;
    int remove_value; //记录删除的元素的值

    public Array(int len) {
        cnt = 0;
        this.len = len;
    }


    /*初始化数组*/

    public void init_Array() {

        name = new int[len];
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
                System.out.println(name[i]);
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
            name[cnt] = value;
            cnt++;
            return true;
        }
    }

    /*在某个特定位置添加元素*/
    public boolean insert_Array(int pos,int value) throws FullException {

        if (is_full()) {
            throw new FullException("数组已满，无法添加");
        }else{
            for(int i = cnt;i > pos - 1; i--){
                name[i] = name[i-1];
            }
            name[pos - 1] = value;
            cnt++;
            return true;
        }
    }

    /*删除某个位置元素*/
    public boolean delect_Array(int pos)throws EmptyException{

        if(is_empty()) {
            throw new EmptyException("数组为空，无法删除");
        }else if(pos < 1 || cnt < pos){
            return false;
        } else{
            remove_value = name[pos - 1];
            if(pos < cnt){
                for(int i = pos;i < cnt;i++) {
                    name[i - 1] = name[i];
                    if (i == cnt - 1) {
                        cnt--;
                    }
                }
            }
        }
        return true;
    }

    /*数组元素倒置*/
    public void inversion_Array(){

        int i = 0;
        int j = cnt - 1;
        int t;
        while(i < j){
            t = name[i];
            name[i] = name[j];
            name[j] = t;
            i++;
            j--;
        }
    }

    /*使用冒泡排序对数组进行排序（从小到大）*/
    public void sort_Array(){

        int t;
        for(int i = cnt - 1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if(name[j] > name[j+1]){
                    t = name[j];
                    name[j] = name[j+1];
                    name[j+1] = t;
                }
            }
        }
    }
}