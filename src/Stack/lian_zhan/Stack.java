package Stack.lian_zhan;

public class Stack {

    Node top; //栈顶指针
    int num; //元素个数
    int val; //用于接收出栈的值

    public Stack() {

        this.top = null;
        this.num = 0;
    }

    /*压栈*/
    public void push(int val){

        Node j = new Node(val);   //先生成一个结点
        j.data = val;
        j.next = top; //j指向其前面一个结点
        top = j; //top指向j（top始终指向栈顶元素（最后一个结点））
        num++;  //元素个数加1
    }

    /*判断栈是否为空*/
    public boolean isEmpty(){
        if(num == 0)
            return true;
        else
            return false;
    }

    /*出栈*/
    public boolean pop() throws EmptyException{

        if(isEmpty())
            throw new EmptyException("栈为空");

        val = top.data;  //出栈的值赋给val
        System.out.println(val);
        Node p = top.next;  //p指向top的下一个结点（栈顶元素的下面一个元素）
        top = null; //在出栈的结点释放
        top = p; //top指向下一个结点

        return true;
    }
}
