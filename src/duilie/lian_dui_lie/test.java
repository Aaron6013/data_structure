package duilie.lian_dui_lie;

public class test {

    public static void main(String[] args) {
        Dui_lie d = new Dui_lie();
        d.init_duilie();
        d.en_queue(3);
        d.en_queue(5);
        d.en_queue(4);
        d.en_queue(6);
        try {
            d.de_queue();
            d.de_queue();
            d.de_queue();
            d.de_queue();
            d.de_queue();
        }catch (EmptyException e){
            e.printStackTrace();
        }
    }
}
