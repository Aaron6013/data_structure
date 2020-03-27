package zhan.lian_zhan;

public class test {

    public static void main(String[] args) {
        Zhan z = new Zhan();
        z.push(3);
        z.push(6);
        try{
            z.pop();
            z.pop();
        }catch (EmptyException e){
            e.printStackTrace();
        }
    }
}
