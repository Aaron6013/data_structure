package Graph.MiniSpanTree_Kruskal;

/**
 * @author Aaron
 * @date 2020/3/31 - 16:43
 */
public class test {

    public static void main(String[] args) {
        CreateMGraph c = new CreateMGraph(9,15);
        c.VertexNode();
        c.lin_jie_jv_zhen();
        c.swapn();
        c.miniSpanTree_Kruskal();
    }
}
