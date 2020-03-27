package zhan.lian_zhan;

public class Zhan {

    Jie_dian top; //栈顶指针
    int num; //元素个数
    int val; //用于接收出栈的值

    public Zhan() {

        this.top = null;
        this.num = 0;
    }

    /*压栈*/
    public void push(int val){

        Jie_dian j = new Jie_dian();
        j.data = val;
        j.next = top; //j指向其下一个结点
        top = j; //top指向j
        num++;
    }

    /*判断栈是否为空*/
    public boolean is_empty(){
        if(num == 0)
            return true;
        else
            return false;
    }

    /*出栈*/
    public boolean pop() throws EmptyException{

        if(is_empty())
            throw new EmptyException("栈为空");

        val = top.data;
        System.out.println(val);
        Jie_dian p = top.next;  //p指向top的下一个结点
        top = null; //在出栈的结点释放
        top = p; //top指向下一个结点

        return true;
    }
}
