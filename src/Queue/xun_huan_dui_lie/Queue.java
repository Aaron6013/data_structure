package Queue.xun_huan_dui_lie;

public class Queue {

    int front; //队头指针
    int rear; //队尾指针
    int[] arr; // 数组
    int len; //len为数组长度
    int val; //保存出队元素

    /*初始化队列*/
    public Queue(int len) {
        this.front = 0; //刚开始队头和队尾指针均为数组下标0
        this.rear = 0;
        this.len = len;
        arr = new int[len];
    }

    /*判断队列是否满*/
    public boolean isFull(){
        if ((rear + 1) % len == front)  //队列满时，队中还有一个空位
            return true;
        else
            return false;
    }

    /*判断队列是否空*/
    public boolean isEmpty(){
        if(front == rear)
            return true;
        else
            return false;
    }

    /*入队*/
    public boolean enQueue(int val){
        if(isFull())
            return false;
        arr[rear] = val;  //队尾指针始终指向最后一个元素的下一个元素
        rear = (rear + 1) % len;  //队尾指针后移一位

        return true;
    }

    /*出队*/
    public boolean deQueue(){
        if(isEmpty())
            return false;
        val = arr[front];
        System.out.println(val);
        front = (front + 1) % len;  //队头指针始终指向第一个元素

        return true;
    }

    /*求队列长度*/
    public int length(){
        return (rear - front + len) % len;
    }
}
