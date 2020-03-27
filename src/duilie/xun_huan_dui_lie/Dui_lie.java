package duilie.xun_huan_dui_lie;

public class Dui_lie {

    int front; //对头指针
    int rear; //队尾指针
    int[] name; // 数组
    int len; //len为数组长度
    int val; //保存出队元素

    /*初始化队列*/
    public Dui_lie(int len) {
        this.front = 0; //刚开始队头和队尾指针均为0
        this.rear = 0;
        this.len = len;
    }

    public void init_queue(){
        name = new int[len];
    }

    /*判断队列是否满*/
    public boolean is_full(){
        if ((rear + 1) % len == front)
            return true;
        else
            return false;
    }

    /*判断队列是否空*/
    public boolean is_empty(){
        if(front == rear)
            return true;
        else
            return false;
    }

    /*入队*/
    public boolean en_queue(int val){
        if(is_full())
            return false;
        name[rear] = val;
        rear = (rear + 1) % len;

        return true;
    }

    /*出队*/
    public boolean de_queue(){
        if(is_empty())
            return false;
        val = name[front];
        System.out.println(val);
        front = (front + 1) % len;

        return true;
    }

}
