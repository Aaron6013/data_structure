package zhan.shun_xu_zhan;

public class Zhan {

    int len;
    int top;
    int [] name;
    int val; // 用于接收出栈的值

    public Zhan() {
        this(6); //无参构造方法，默认创建的栈长度为6
    }

    public Zhan(int len) {
        this.len = len; //栈的长度
        this.top = -1;  //栈顶指针
    }

    /*初始化栈*/
    public void init_zhan(){
        name = new int[len];
    }

    /*判断栈是否满*/
    public boolean is_full(){
        if(top == len - 1)
            return true;
        else
            return false;
    }

    /*判断栈是否为空*/
    public boolean is_empty() {
        if(top == -1)
            return true;
        else
            return false;
    }

    /*压栈*/
    public boolean push(int val) throws FullException{

            if(is_full())
                throw new FullException("栈已满");

            name[++top] = val;
            return true;
    }

    /*出栈*/
    public boolean pop() throws EmptyException{

        if(is_empty())
            throw new EmptyException("栈为空");

        val = name[top--];
        System.out.println(val);
        return true;
    }
}
