package Searching.Hash_Table;

/**
 * @author Aaron
 * @date 2020/4/8 - 17:42
 */
public class test {

    public static void main(String[] args) {

        int[] arr = {12,67,56,16,25,37,22,29,15,47,48,34};
        HashTable h = new HashTable(12);
        /*将值存入*/
        for (int i = 0; i < arr.length; i++) {
            h.insertHash(arr[i]);
        }

        System.out.println(h.searchHash(34));
        System.out.println(h.searchHash(10));
    }
}
