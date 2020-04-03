package Graph.lin_jie_jv_zhen;

/**
 * @author Aaron
 * @date 2020/3/29 - 11:07
 */
public class test {

    public static void main(String[] args) {
        CreateMGraph c = new CreateMGraph(9,15);
        c.VertexNode();
        c.lin_jie_jv_zhen();
        c.DFS(0);
        //c.BFS();

    }
}
