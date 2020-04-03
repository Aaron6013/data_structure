package Stack.lian_zhan;

public class test {

    public static void main(String[] args) {
        Stack z = new Stack();
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
