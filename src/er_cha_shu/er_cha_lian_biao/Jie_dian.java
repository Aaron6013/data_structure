package er_cha_shu.er_cha_lian_biao;

public class Jie_dian {

    int data;
    Jie_dian left_child,right_child;

    public Jie_dian() {
        data = 0;
    }

    public Jie_dian(int data) {
        this.data = data;
        left_child = null;
        right_child = null;
    }
}
