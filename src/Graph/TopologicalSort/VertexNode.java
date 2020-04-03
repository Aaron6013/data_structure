package Graph.TopologicalSort;

/**
 * @author Aaron
 * @date 2020/4/1 - 12:05
 */
public class VertexNode {

    int in;
    int data;
    EdgeNode firstedge;

    public VertexNode(int data,int in) {
        this.data = data;
        this.in = in;
        this.firstedge = null;
    }
}
