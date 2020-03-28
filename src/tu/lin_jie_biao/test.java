package tu.lin_jie_biao;

/**
 * @author Aaron
 * @date 2020/3/28 - 17:07
 */
public class test {

    public static void main(String[] args) {

        CreateALGraph c = new CreateALGraph(4,5);
        VertexNode[] a = c.createVertexNode();
        c.createEdgeNode();

        /*输出顶点表和邻接表*/
        for (int i = 0; i < a.length; i++) {
            System.out.print("顶点为：" + a[i].data + " " +
                    "邻结点为：" + a[i].firstedge.adjvex + " ");
            EdgeNode p = a[i].firstedge.next;
           while (p != null){
               System.out.print(p.adjvex + " ");
               p = p.next;
           }
            System.out.println();
        }
    }
}
