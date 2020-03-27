package jing_tai_lian_biao;

public class Lian_biao {

    int len;
    Jie_dian[] node;
    int val;

    /*初始化链表*/
    public Lian_biao(int len) {

        this.len = len;
        node = new Jie_dian[len];
        for(int i = 0;i < len;i++){
            node[i] = new Jie_dian();
            node[i].next = i + 1; //node[0]不存数据，其.next指向最后一个有数据的位置的下一个位置
        }
        node[len - 1].next = 0; //node[len-1]不存数据，其.next指向第一个有数据的位置
    }

    /*动态分配内存*/
    public int malloc(){

        int  i = node[0].next;
        if(i != 0){
            node[0].next = node[i].next;
        }
        return i;
    }

    /*链表的长度*/
    public int length(){

        int j = 0;
        int i = node[len - 1].next;
        while (i != 0){
            j++;
            i = node[i].next;
        }
        return j;
    }

    /*插入元素*/
    public boolean insert(int pos,int val1){

        if(pos < 1 || pos > length() + 1)
            return false;
        int k = len - 1;
        int i = malloc();

        if(i!= 0){
            node[i].data = val1;
            for(int l = 1;l <= pos - 1;l++){
                k = node[k].next;
            }
            node[i].next = node[k].next;
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
        val  = node[p].data;
        System.out.println(val);
        node[k].next = node[p].next;
        node[p].next = 0;

        return true;
    }

    public void show(){
        int i = node[0].next;
        int j = node[len-1].next;
        while (j <= (i - 1)){
            System.out.println(node[j].data);
            j = node[j].next;  //node[i-1].next=0,node[j=0]=node[0]=0(i-1为最后一个)
            if(j == 0){
                break;
            }
        }
    }
}
