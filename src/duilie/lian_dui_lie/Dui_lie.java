package duilie.lian_dui_lie;

public class Dui_lie {

    Jie_dian front;
    Jie_dian rear;
    Jie_dian head;
    int val;

    /*初始化队列*/
    public Dui_lie() {
        this.front = null;
        this.rear = null;
    }

    public void init_duilie(){

        head = new Jie_dian(0);
        front = head;
        rear = head;
        rear.next = null;
    }

    /*判断队是否为空*/
    public boolean is_empty(){

        if(front == rear)
            return true;
        else
            return false;
    }

    /*入队*/
    public boolean en_queue(int val){

        /*链表不存在满的情况*/
        Jie_dian j = new Jie_dian(val);
        rear.next = j;
        j.next = null;
        rear = j;

        return true;
    }

    /*出队*/
    public boolean de_queue() throws EmptyException {

        if(is_empty())
           throw new EmptyException("队列已空");
        Jie_dian j = front.next;
        val = j.data;
        System.out.println(val);
        front.next = j.next;
        if(j == rear)
            front = rear;
        j = null;
        return true;
    }

}
