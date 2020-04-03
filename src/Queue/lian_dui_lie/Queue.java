package Queue.lian_dui_lie;

public class Queue {

    Node front;  //队头指针
    Node rear;   //队尾指针
    Node head;   //链表的头结点
    int val;

    /*初始化队列*/
    public Queue() {
        head = new Node(0);
        front = head;  //刚开始队头队尾指针均指向链表的头结点，头结点的值默认为0
        rear = head;
    }

    /*判断队是否为空*/
    public boolean isEmpty(){

        if(front.next == null)
            return true;
        else
            return false;
    }

    /*入队（队尾入）*/
    public boolean enQueue(int val){

        /*链表不存在满的情况*/
        Node j = new Node(val);
        j.next = null;
        rear.next = j;
        rear = j; //队尾指针rear始终指向队尾最后一个结点

        return true;
    }

    /*出队(队头出)*/
    public boolean deQueue() throws EmptyException {

        if(isEmpty())
           throw new EmptyException("队列已空");
        front = front.next;  //队头指针始终指向队头第一个结点
        val = front.data;
        System.out.println(val);
        return true;
    }

    /*求队列长度*/
    public int length(){

        int len = 0;
        Node n = front;
        while (n.next != null){
            len++;
            n = n.next;
        }
        return len;
    }
}
