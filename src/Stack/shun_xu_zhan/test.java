package Stack.shun_xu_zhan;

public class test {

    public static void main(String[] args) {

        Stack z = new Stack(6);
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
