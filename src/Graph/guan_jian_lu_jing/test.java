package Graph.guan_jian_lu_jing;

/**
 * @author Aaron
 * @date 2020/4/3 - 9:17
 */
public class test {

    public static void main(String[] args) {
        CreateALGraph c = new CreateALGraph(10,13);
        c.createVertexNode();
        c.createEdgeNode();
        c.topologicalSort();
        c.criticalPath();
    }
}
