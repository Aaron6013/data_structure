package Graph.ShortPathTable.Dijkstra;

/**
 * @author Aaron
 * @date 2020/3/31 - 20:14
 */
public class test {

    public static void main(String[] args) {
        CreateMGraph c = new CreateMGraph(9,16);
        c.VertexNode();
        c.lin_jie_jv_zhen();
        /*起点默认为0顶点*/
        int[] path = c.shortTestPath_Dijkstra();
        for (int i = 0; i < path.length; i++) {
            System.out.println(path[i]);
        }
    }
}
