package Graph.TopologicalSort;

/**
 * @author Aaron
 * @date 2020/4/1 - 15:12
 */
public class test {

    public static void main(String[] args) {
        CreateALGraph c = new CreateALGraph(14, 20);
        c.createVertexNode();
        c.createEdgeNode();
        c.topologicalSort();
    }
}
