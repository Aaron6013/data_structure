package jing_tai_lian_biao;

public class test {

    public static void main(String[] args) {
        Lian_biao l = new Lian_biao(5);
        l.insert(1,1);
        l.insert(2,2);
        l.insert(3,3);
        l.delete(2);
        l.show();
    }
}
