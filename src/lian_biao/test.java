package lian_biao;

public class test {
    public static void main(String[] args) {
        LinkList l = new LinkList(5);
        l.createLinkList();
        l.insertLinkList(3,4);
        l.insertLinkList(6,6);
        l.sortLinkList();
        l.deleteLinkList(3);
        l.showLinkList();
        System.out.println("删除元素为：" +l.val);
    }
}
