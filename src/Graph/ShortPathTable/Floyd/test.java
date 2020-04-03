package Graph.ShortPathTable.Floyd;

/**
 * @author Aaron
 * @date 2020/4/1 - 10:18
 */
public class test {

    public static void main(String[] args) {
        CreateMGraph c = new CreateMGraph(9,16);
        c.VertexNode();
        c.lin_jie_jv_zhen();
        c.shortTestPath_Floyd();
        c.printf(0,8);
    }
}
