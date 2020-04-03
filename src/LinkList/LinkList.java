package LinkList;

import java.util.Scanner;

public class LinkList {

    Node head; //头结点
    Node node; //始终指向链表的最后一个结点
    int val; //用来存放删除的值
    int numNode;  //结点个数（头结点不算）

    /*创建头结点*/
    public LinkList(int numNode) {
        this.numNode = numNode;
        head = new Node(0); //头结点默认存0
        node = new Node(numNode);
        node = head;  //node此时指向链表最后一个结点，即头结点
    }

    public void createLinkList(){

        for(int i = 0;i < numNode;i++) {

            Scanner s = new Scanner(System.in);
            System.out.println("请输入第" + (i + 1) + "的值");
            int value = s.nextInt();
            Node n = new Node(value);
            node.next = n;  //第一次执行时，node相当于head，就把这个结点放到了head后面
            node = n; //node此时指向结点n
        }
    }

    /*将链表元素输出*/
    public void showLinkList(){

        Node n = head.next;  //n的作用同node，也为一个“指针”
        while(n != null){   //等于null，说明到了链表的尾部
            System.out.println(n.data);
            n = n.next;
        }
    }

    /*判断链表是否为空*/
    public boolean isEmpty(){

        if(head.next == null)
            return true;
        else
            return false;
    }

    /*求链表长度，和输出链表如出一辙，到了每输出一个元素长度就加一*/
    public int lengthLinkList(){

        Node n = head.next;
        int len = 0;
        while (n != null){
            len++;
            n = n.next;
        }
        return len;
    }

    /*链表排序（冒泡）*/
    public void sortLinkList(){

        int t;
        int len = lengthLinkList();
        Node p,q;
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
    public boolean insertLinkList(int pos, int val){
    /*先找到pos的前一个结点（pos-1），然后将此结点（前一结点）的下一个结点指向新建
    结点,将新建结点的下一个结点指向原来pos-1结点的前一个结点*/
        int i = 0;
        Node j = head;

        while (j != null && i < pos -1){
            j = j.next;
            i++; //i=1,对应j在第1个结点
        }

        if(j == null || i > pos){
            return false;
        }
        //执行到这一步的时候，j所在的位置为pos的前一个结点
        Node p = new Node(val); //新建一个结点
        Node q = j.next; //先用q暂存原来第pos个结点的地址
        j.next = p; //第pos-1个结点的下一个结点的为新建的p
        p.next = q; //p的下一个结点为原来第pos个结点的q，即原来的第pos位置上的结点现在变为pos+1

        return true;
    }

    /*删除某个位置的元素*/
    public boolean deleteLinkList(int pos){
        /*同添加结点，先找到pos-1位置的结点，将此结点的下一个结点指向
         要删除结点的下一个结点*/
        int i = 0;
        Node j = head;

        while (j.next != null && i < pos - 1){
            j = j.next;
            i++;
        }

        if(j.next == null || i > pos - 1){
            return  false;
        }

        val = j.next.data;  //删除结点的值赋给val
        Node p = j.next;
        j.next = p.next;
        p = null;

        return  true;
    }

    /*清空一个链表*/
    public void clearLinkList(){

        Node j = head.next;  //p的作用同node，也为一个“指针”
        while(j != null){
            Node p = j.next;
            j = null;
            j = p;
        }
    }

}
