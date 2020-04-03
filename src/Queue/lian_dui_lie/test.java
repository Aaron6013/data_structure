package Queue.lian_dui_lie;

public class test {

    public static void main(String[] args) {
        Queue d = new Queue();
        d.enQueue(3);
        d.enQueue(5);
        d.enQueue(6);
        System.out.println("队列长度为：" + d.length());
        try {
            d.deQueue();
            d.deQueue();
            d.deQueue();
            d.enQueue(4);
            d.deQueue();
        }catch (EmptyException e){
            e.printStackTrace();
        }
    }
}
