package er_cha_shu.er_cha_lian_biao;

public class test {

    public static void main(String[] args) {
        Er_cha_shu e = new Er_cha_shu();
        e.creatTree(e.j); //按前序遍历输入，将普通二叉树扩展P187，空的结点用0代替
        e.preOrderTraversse(e.j);
        System.out.println(e.depth(e.j));
        System.out.println(e.root());
    }
}
