package tu.lin_jie_biao;
import java.util.Scanner;
/**
 * @author Aaron
 * @date 2020/3/28 - 16:53
 */
public class CreateALGraph {
/*无向图*/
    int numVertexes; //顶点数
    int numEdges;    //边数
    VertexNode[] Vertex;

    public CreateALGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        Vertex = new VertexNode[numVertexes];
    }

    public VertexNode[] createVertexNode(){

        for (int i = 0; i < numVertexes; i++) {
            VertexNode v = new VertexNode(i);
            v.firstedge = null;
            Vertex[i] = v;
        }
        return Vertex;
    }

    public void createEdgeNode(){

        int p = 0;
        while (p < numEdges) {
            Scanner s = new Scanner(System.in);
            System.out.println("输入边（vi,vj）上的下标i，下标j(按顺序按回车键结束一次输入):");
            int i = s.nextInt();
            int j = s.nextInt();
            /*采用头插法*/
            EdgeNode e = new EdgeNode();
            e.adjvex = i;
            e.next = Vertex[j].firstedge;  //新的结点的next指向原来顶点firstedge指向的第一个边结点
            Vertex[j].firstedge = e;  //顶点firstedge指向e

            EdgeNode d = new EdgeNode();  //无向图是相互的
            d.adjvex = j;
            d.next = Vertex[i].firstedge;
            Vertex[i].firstedge = d;
            p++;
        }
    }
}
