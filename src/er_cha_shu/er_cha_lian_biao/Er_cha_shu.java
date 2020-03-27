package er_cha_shu.er_cha_lian_biao;
import java.util.Scanner;

public class Er_cha_shu {

    Jie_dian j;
    Scanner s = new Scanner(System.in);

    public Er_cha_shu() {
        j = new Jie_dian();
    }

    /*创建树*/
    public Jie_dian creatTree(Jie_dian q) {

        System.out.println("请输入值：");
        int val = s.nextInt();
        if(0 == val){
            return null;
        }else{
            q.data = val;
            q.left_child = creatTree(new Jie_dian()); //此处实参不能向c语言一样传q.left.child
            q.right_child = creatTree(new Jie_dian());
            return q;
        }
    }

    /*前序遍历*/
    public void preOrderTraversse(Jie_dian q){

        if(0 == q.data)
            return;
        System.out.println(q.data);
        if(q.left_child != null)  //不能超出结点的总数
            preOrderTraversse(q.left_child);
        if(q.right_child != null)
            preOrderTraversse(q.right_child);
    }

    /*判断二叉树是否为空(默认只有根结点时为空)*/
    public boolean is_empty(){
        if(j.data == 0)
            return true;
        else
            return false;
    }
    /*求树的深度*/
    public int depth(Jie_dian p){

        int i , j ;
        if(is_empty())  //判断是否为空树
            return 0;
        if(p.left_child != null) {
            i = depth(p.left_child);
        }
        else {
           i = 0;
        }
        if(p.right_child != null) {
            j = depth(p.right_child);
        }
        else {
           j = 0;
        }
        return i>j?i+1:j+1;
    }

    /*返回树的根*/
    public int root(){
        if(is_empty())
            return 0;
        else{
            return j.data;
        }
    }
}
