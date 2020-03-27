package lian_biao;

public class test {
    public static void main(String[] args) {
        Lian_biao l = new Lian_biao();
        Jie_dian head = l.lian_biao();
        l.insert_list(head,2,4);
        l.insert_list(head,6,6);
        l.sort_list(head);
        l.delete_list(head,3);
        l.show_lianbiao(head);
        System.out.println("删除元素为：" +l.val);
    }
}
