package zhan.shun_xu_zhan;

public class test {

    public static void main(String[] args) {

        Zhan z = new Zhan(6);
        z.init_zhan();
        try{
            z.push(1);
            z.push(2);
            z.pop();
            z.pop();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
