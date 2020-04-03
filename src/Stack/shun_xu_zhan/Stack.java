package Stack.shun_xu_zhan;

public class Stack {

    int len;  //栈的长度
    int top;  //栈顶指针，由于为数组实现，故其类型为整型（数组下标）
    int [] arr;  //存放栈的数组
    int val; // 用于接收出栈的值

    public Stack(int len) {
        this.len = len;
        this.top = -1;  //栈顶指针,空栈时为-1，有元素时。始终指向栈顶元素
        arr = new int[len];
    }

    /*判断栈是否满*/
    public boolean isFull(){
        if(top == len - 1)
            return true;
        else
            return false;
    }

    /*判断栈是否为空*/
    public boolean isEmpty() {
        if(top == -1)
            return true;
        else
            return false;
    }

    /*压栈*/
    public boolean push(int val) throws FullException{

            if(isFull())
                throw new FullException("栈已满");

            arr[++top] = val;  //栈顶指针先上移一位，在入值
            return true;
    }

    /*出栈*/
    public boolean pop() throws EmptyException{

        if(isEmpty())
            throw new EmptyException("栈为空");

        val = arr[top--];   //先删除栈顶元素，再将栈顶指针下移一位
        System.out.println(val);
        return true;
    }
}
