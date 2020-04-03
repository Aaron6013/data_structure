package Graph.MiniSpanTree_Prim;

/**
 * @author Aaron
 * @date 2020/3/29 - 18:17
 */
public class test {

    public static void main(String[] args) {
        CreateMGraph c = new CreateMGraph(9,15);
        c.VertexNode();
        c.lin_jie_jv_zhen();
        c.MiniSpanTree_Prim();
    }
}
