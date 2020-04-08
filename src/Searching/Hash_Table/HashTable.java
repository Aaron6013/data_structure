package Searching.Hash_Table;

/**
 * @author Aaron
 * @date 2020/4/8 - 17:34
 */
public class HashTable {

    int[] arr;
    int num;

    public HashTable(int num) {
        this.num = num;
        arr = new int[num];
    }

    /*散列函数*/
    public int Hash(int val){

        return val % num;
    }

    /*插入值进散列表*/
    public void insertHash(int val){

        int add = Hash(val);
        while (arr[add] != 0){  //不等于0说明冲突，更改地址，继续往下
            add = (add + 1) % num;
        }
        arr[add] = val;
    }

    /*查找*/
    public boolean searchHash(int val){

        int add = Hash(val);
        while (arr[add] != val){  //冲突，更改地址，继续查找
            add = (add + 1) % num;
            if(add == Hash(val))   //找了一圈没找到，说明不存在
                return false;
        }
        return true;
    }
}
