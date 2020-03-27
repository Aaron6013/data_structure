package duilie.xun_huan_dui_lie;

import zhan.lian_zhan.Zhan;

public class test {

    public static void main(String[] args) {
        Dui_lie d = new Dui_lie(5);
        d.init_queue();
        d.en_queue(4);
        d.en_queue(3);
        d.de_queue();
        d.de_queue();
    }
}
