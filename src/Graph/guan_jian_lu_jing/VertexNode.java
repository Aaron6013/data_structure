package Graph.guan_jian_lu_jing;

/**
 * @author Aaron
 * @date 2020/4/1 - 17:25
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
