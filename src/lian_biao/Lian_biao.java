package lian_biao;
import java.util.Scanner;

public class Lian_biao {

    Jie_dian node;
    int val; //用来存放删除的值

    public Jie_dian lian_biao(){

        Scanner s = new Scanner(System.in);
        System.out.println("请输入要建立结点的个数：");
        int length = s.nextInt();
        Jie_dian head = new Jie_dian(length);
        node = head;   //这里p可看成一个“指针”，指向链表的最后一个结点（此时链表只有一个头结点，故指向head,node此时就相当于head）
        node.next = null;  //由于只有一个头结点，故下一个结点为null

        for(int i = 0;i < length;i++) {
            System.out.println("请输入第" + (i+1) + "的值");
            int value = s.nextInt();
            Jie_dian j = new Jie_dian(value);
            node.next = j;  //第一次执行时，node相当于head，就把这个结点放到了head后面
            j.next = null;  //新建立的结点指向空，意味着其为最后一个结点
            node = j; //同node=head，此时node就等同于新建立的这个结点
        }
        return head;
    }

    /*将链表元素输出*/
    public void show_lianbiao(Jie_dian head){

        Jie_dian j = head.next;  //p的作用同node，也为一个“指针”
        while(j != null){
            System.out.println(j.data);
            j = j.next;
        }
    }

    /*判断链表是否为空*/
    public boolean is_empty(Jie_dian head){

        if(head.next == null)
            return true;
        else
            return false;
    }

    /*求链表长度*/
    public int length_list(Jie_dian head){

        Jie_dian j = head.next;
        int len = 0;
        while (j != null){
            len++;
            j = j.next;
        }
        return len;
    }

    /*链表排序（冒泡）*/
    public void sort_list(Jie_dian head){

        int t;
        int len = length_list(head);
        Jie_dian p,q;
        p = head.next;
        for(int i = 0;i < len - 1;i++,p = p.next){
            q = head.next;
            for(int j = 0;j < len - 1 - i;j++,q = q.next){
                if(q.data > q.next.data){
                    t = q.data;
                    q.data = q.next.data;
                    q.next.data = t;
                    }
            }
        }
    }

    /*在某个位置插入值*/
    public boolean insert_list(Jie_dian head,int pos,int val){

        int i = 0;
        Jie_dian j = head;

        while (j != null && i < pos -1){
            j = j.next;
            i++; //i=1,对应j在第1个结点
        }

        if(j == null || i > pos){
            return false;
        }
        //执行到这一步的时候，j所在的位置为pos的前一个结点
        Jie_dian p = new Jie_dian(val); //新建一个结点
        Jie_dian q = j.next; //先用q暂存原来第pos个结点的地址
        j.next = p; //第pos-1个结点的下一个结点的为新建的p
        p.next = q; //p的下一个结点为原来第pos个结点的q，即原来的第pos位置上的结点现在变为pos+1

        return true;
    }

    /*删除某个位置的元素*/
    public boolean delete_list(Jie_dian head,int pos){
        int i = 0;
        Jie_dian j = head;

        while (j.next != null && i < pos - 1){
            j = j.next;
            i++;
        }

        if(j.next == null || i > pos - 1){
            return  false;
        }

        val = j.next.data;
        Jie_dian p = j.next;
        j.next = p.next;
        p = null;

        return  true;
    }

    /*清空一个链表*/
    public void empty_list(Jie_dian head){

        Jie_dian j = head.next;  //p的作用同node，也为一个“指针”
        while(j != null){
            Jie_dian p = j.next;
            j = null;
            j = p;
        }
    }

}
