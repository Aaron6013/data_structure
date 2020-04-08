package Searching.Binary_Sort_Tree;
/**
 * @author Aaron
 * @date 2020/4/5 - 16:06
 */
public class BinarySortTree{

    Node j;  //根
    Node p;  //指向目标值的结点

    /*查找（若找到元素返回true，否则返回false），若查找成功，q指向此结点，
      若不成功，则p指向查找路径上访问的最后一个结点*/
    public boolean searchBST(Node n, Node q, int value) {

        if (n == null) {
                p = q;
            return false;
        }
        else if (value == n.data) {
            p = n;
            return true;
        }
        else if (value < n.data)   //若值小于根值，则向根的左子树查找
            return searchBST(n.leftChild,n,value);
        else if (value > n.data)   //若值大于根值，则向根的右子树查找
            return searchBST(n.rightChild,n,value);
        return false;
    }

    /*插入元素（要插入的值树中不存在才能插入并返回true，否则不能插入返回fals）*/
    public boolean insertBST(int value){

        if(searchBST(j,null,value))
            return false;  //要插入的值存在
        else {
            Node e = new Node();
            e.data = value;
            if(p == null) {  //空树
               p = e;
               j = e;  //j代表根
            }
            else if(value > p.data)
                p.rightChild = e;
            else if(value < p.data)
                p.leftChild = e;
        }
        return true;
    }

    /*前序遍历*/
    public void preOrderTraversse(Node q){

        if(0 == q.data)
            return;
        System.out.println(q.data);
        if(q.leftChild != null)  //左孩子存在
            preOrderTraversse(q.leftChild);
        if(q.rightChild != null)
            preOrderTraversse(q.rightChild);
    }

    /*删除元素(先找到再通过delete函数删除)*/
    public boolean deleteBST(Node n, int value){

        if(n == null)
            return false;
        else if(value == n.data)
            return delete(n);
        else if(value > n.data)
            return deleteBST(n.rightChild,value);
        else
            return deleteBST(n.leftChild,value);
    }

    public boolean delete(Node n){

        Node m;
        if(n.rightChild == null){  //要删除结点右子树为空，将其左子树替换自己
            m = n;
            n = n.leftChild;
            m = null;
        } else if (n.leftChild == null){
            m = n;
            n = n.rightChild;
            m = null;
        }else {  //左右子树都不为空
            m = n;
            Node s = n.leftChild;
            while (s.rightChild != null){  //最终s为要删除结点的前驱（中序遍历）
                m = s;
                s = s.rightChild;
            }
            n.data = s.data;  //被删结点的值换成其前驱的值（也就是把前驱移到被删结点，被删结点的左右子树不变）
            if(m != n)
                m.rightChild = s.leftChild;
            else
                m.leftChild = s.leftChild;
            m = null;
        }
        return true;
    }
}
