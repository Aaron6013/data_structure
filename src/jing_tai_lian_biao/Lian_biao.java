package jing_tai_lian_biao;

public class Lian_biao {

    int len;
    Node[] node;
    int val;

    /*初始化链表*/
    public Lian_biao(int len) {

        this.len = len;
        node = new Node[len];
        for(int i = 0;i < len;i++){
            node[i] = new Node();
            node[i].next = i + 1; //node[0]不存数据，其.next指向最后一个有数据的位置的下一个位置
        }
        node[len - 1].next = 0; //node[len-1]（数组最后一个元素）不存数据，其.next指向第一个有数据的位置
    }

    /*动态分配内存（添加元素时，实现数组第一个元素的后移）*/
    public int malloc(){

        int  i = node[0].next;
        if(i != 0){
            node[0].next = node[i].next;
        }
        return i;
    }

    /*链表的长度（有效元素的个数）*/
    public int length(){

        int j = 0;
        int i = node[len - 1].next;  //数组最后一个元素node[len - 1]指向第一个有效元素
        while (i != 0){
            j++;
            i = node[i].next;
        }
        return j;
    }

    /*插入元素*/
    public boolean insert(int pos,int val1){
    /*实际的插入位置为有效元素的最后面一位，通过调整pos-1位置next的指向，
      使其指向这个插入元素，插入元素的next指向原来pos位置的元素*/
        if(pos < 1 || pos > length() + 1)  //插入位置小于1或在最后一个有效元素的后面的后面，不能插入
            return false;
        int k = len - 1;
        int i = malloc();  //i为插入的位置的下标

        if(i!= 0){
            node[i].data = val1;
            for(int l = 1;l <= pos - 1;l++){
                k = node[k].next;  //l=1时，node[k].next指向第一个元素，随着k的增加，指向元素往后推
            }
            node[i].next = node[k].next;  //node[k]为第pos-1位置的元素
            node[k].next = i;
        }

        return true;
    }

    /*删除元素*/
    public boolean delete(int pos){

        if(pos < 1 || pos > length())
            return false;

        int k = len - 1;
        for(int i = 1;i <= pos - 1;i++){
            k = node[k].next;
        }   //经过for循环后，k在pos-1位置
        int p = node[k].next;
        val  = node[p].data;  //将删除元素的值赋给val
        System.out.println(val);
        node[k].next = node[p].next;
        node[p].next = 0;

        return true;
    }

    public void show(){
        int i = node[0].next;  //node[0].next为最后一个有效元素的下一个位置
        int j = node[len-1].next;  //第一个有效元素
        while (j <= (i - 1)){
            System.out.println(node[j].data);
            j = node[j].next;  //node[i-1].next=0,node[j=0]=node[0]=0(i-1为最后一个)
            if(j == 0){
                break;
            }
        }
    }
}
