package Queue.xun_huan_dui_lie;

public class test {

    public static void main(String[] args) {
        Queue d = new Queue(5);
        d.enQueue(4);
        d.enQueue(3);
        d.enQueue(2);
        System.out.println("队列长度为：" + d.length());
        d.deQueue();
        d.deQueue();
        d.deQueue();
        d.enQueue(1);
        d.deQueue();
    }
}
