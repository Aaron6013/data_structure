package Searching.Binary_Sort_Tree;

/**
 * @author Aaron
 * @date 2020/4/5 - 16:18
 */
public class test {

    public static void main(String[] args) {

        BinarySortTree b = new BinarySortTree();
        /*b.creatTree(b.j);
        System.out.println(b.searchBST(b.j,null,47));
        System.out.println(b.p.leftChild.data);
        System.out.println(b.insertBST(95));
        System.out.println(b.p.rightChild.data);*/
        int[] arr = {62,88,58,47,35,73,51,99,37,93};
        for(int i = 0; i < arr.length; i++){
            b.insertBST(arr[i]);
        }
        b.preOrderTraversse(b.j);
        //System.out.println(b.searchBST(b.j,null,47));
        //System.out.println(b.p.leftChild.data);
        System.out.println(b.deleteBST(b.j,47));
    }
}
