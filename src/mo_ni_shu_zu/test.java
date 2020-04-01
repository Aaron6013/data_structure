package mo_ni_shu_zu;

public class test {

    public static void main(String[] args) {

        Array a = new Array(5); //数组长度为10，有效元素为0
        try{
            a.append_Array(100);
            a.append_Array(66);
            a.append_Array(88);
            a.insert_Array(2,40);
            a.insert_Array(5,2312);
            a.sort_Array();
            a.delect_Array(2);
            a.show_Array();
        } catch(Exception e){
           e.printStackTrace();
        }
    }
}
