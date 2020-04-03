package Tree.shun_xu_shi_xian;

public class test {

    public static void main(String[] args) {
        Er_cha_shu e = new Er_cha_shu(7);
        e.add(1);
        e.add(2);
        e.add(3);
        e.add(4);
        e.add(5);
        e.add(6);
        e.add(7);
        e.assign(8,3,4);
        System.out.println("树的深度为：" + e.depth());
        e.root();
        System.out.println("树的根的值为：" + e.v);
        System.out.println("2的双亲为：" + e.parent(2));
        System.out.println("2的左孩子为：" + e.left_child(2));
        System.out.println("2的右兄弟为：" + e.right_brother(2));
        e.pre_order_traverse(0);
        e.print();
    }
}
