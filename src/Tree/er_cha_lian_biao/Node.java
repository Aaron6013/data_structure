package Tree.er_cha_lian_biao;

public class Node {

    int data;
    Node left_child,right_child;

    public Node() {
        data = 0;
    }

    public Node(int data) {
        this.data = data;
        left_child = null;
        right_child = null;
    }
}
