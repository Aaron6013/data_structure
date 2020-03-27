package er_cha_shu.shun_xu_shi_xian;

import java.util.Scanner;

public class Er_cha_shu {

    int level; //第几层
    int order; //第几个
    int[] name;
    int len; //长度
    int v; // 记录返回的值
    int o;

    public Er_cha_shu(int len) {
        this.len = len;
        name = new int[len];
        level = 1;
        order = 1;
        o = 0;
    }

    /*按层序次序输入二叉树中结点的值(字符型或整型), 构造顺序存储的二叉树*/
    public boolean add(int val){

        name[o] = val;
        //判断此结点双亲是否为空，若为空则报错
        if(o != 0 && name[(o+1)/2-1] == 0 && name[o] !=0){
            System.out.println("出现无双亲的非根结点。");
            name[o] = 0;
            return false;
        }
        o++;
        return true;
    }

    /*判断二叉树是否为空*/
    public boolean is_empty(){
        if(name[0] == 0 )
            return true;
        else
            return false;
    }

    /*求树的深度*/
    public int depth(){

        int l = len - 1;
        int j = -1;
        /*先找到最后一个结点*/
        for(int i = len-1;i > 0;i--) {
            if (name[i] != 0)
                break;
            l--;
        }
        l++;
        do
            {
                j++;
        } while(l>=Math.pow(2,j));// 计算2的j次幂,不用log，因为会产生小数，并不好取整

        return j;
        }

    /*当树不空,用val返回树的根的值,返回true;否则返回false*/
    public boolean root(){
        if(is_empty())
            return false;
        else{
            v = name[0];
        }
        return true;
    }

    /*返回某个位置的值（第几层第几个）*/
    public int value(){
        return name[(int)Math.pow(2,level-1)+order-2];
    }

    /*更改某个位置的值*/
    public boolean assign(int val,int l,int o){

        int i = (int)Math.pow(2,l-1)+o-2; //找到位置
        if(val != 0 && name[(i+1)/2-1] == 0)  //子结点赋值不为空，双亲结点为空
            return false;
        else if(val == 0 && (name[i*2+1] != 0 || name[i*2+2] != 0)){ //双亲赋空值，但其有子结点
            return false;
        }
        name[i] = val;
        return true;
    }

    /*若val是T的非根结点,则返回它的双亲的值,否则返回＂空＂*/
    public int parent(int val){

        if(is_empty())
            return 0;

        for(int j = 1;j < len;j++){
            if(name[j] == val)  //先找到val所在位置
                return name[(j+1)/2 - 1];
        }

        return 0;
    }

    /*返回e的左孩子。若e无左孩子,则返回＂空＂*/
    public int left_child(int val){

        if(is_empty())
            return 0;

        for(int j = 0;j < len;j++){
            if(val == name[j])
                return name[j*2+1];
        }

        return 0;
    }

    /*返回e的右孩子。若e无左孩子,则返回＂空＂*/
    public int right_child(int val){

        if(is_empty())
            return 0;

        for(int j = 0;j < len;j++){
            if(val == name[j])
                return name[j*2+2];
        }

        return 0;
    }

    /*返回左兄弟*/
    public int left_brother(int val){

        if(is_empty())
            return 0;
        for(int j = 1;j < len;j++){
            if(name[j]==val && j%2==0) /* 找到e且其序号为偶数(是右孩子) */
                return name[j-1];
        }
        return 0;
    }

    /*返回右兄弟*/
    public int right_brother(int val){

        if(is_empty())
            return 0;
        for(int j = 1;j < len;j++){
            if(name[j]==val && j%2==1) /* 找到e且其序号为偶数(是左孩子),j%2==1确定其为左子树*/
                return name[j+1];
        }
        return 0;
    }

    /*前序遍历*/
    public void pre_order_traverse(int i){

        if(name[i] == 0)
            return;
        System.out.println(name[i]);
        if(2*i+1 < len)
            pre_order_traverse(2*i+1);
        if(2*i+2 < len)
            pre_order_traverse(2*i+2);
    }

    /*逐层、按本层序号输出二叉树*/
    public void print(){

       for(int i = 1;i <= depth();i++){
           System.out.println("第"+ i + "层");
           for(int j = 1;j<=Math.pow(2,i-1);j++)
           {
               level = i;
               order = j;
               int e = value();
               if(e != 0)
                   System.out.println("第" + j + "个： "+ e);
           }
       }
    }
}

