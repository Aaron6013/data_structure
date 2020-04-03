package Graph.TopologicalSort;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Aaron
 * @date 2020/4/1 - 12:09
 */
public class CreateALGraph {

    int numVertexes;  //顶点数
    int numEdges;   //边数
    VertexNode[] Vertex;  //顶点矩阵
    int[] r = {0,0,2,0,2,3,1,2,2,2,1,2,1,2};  //为了方便，将入度写成矩阵，若换图，则需要更改

    public CreateALGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        Vertex = new VertexNode[numVertexes];
    }

    /*初始化顶点矩阵*/
    public VertexNode[] createVertexNode(){

        for (int i = 0; i < numVertexes; i++) {
            VertexNode v = new VertexNode(i,r[i]);
            Vertex[i] = v;
        }
        return Vertex;
    }

    /*邻接表*/
   public void createEdgeNode(){

       int p = 0;
       while (p < numEdges){
           Scanner s = new Scanner(System.in);
           System.out.println("输入边（vi,vj）上的下标i，下标j(按顺序按回车键结束一次输入):");
           int i = s.nextInt();
           int j = s.nextInt();

           EdgeNode e = new EdgeNode();
           e.adjvex = j;
           e.next = Vertex[i].firstedge;
           Vertex[i].firstedge = e;

           p++;
       }
   }

   public boolean topologicalSort(){

       Stack s = new Stack();
       int count = 0;

       for (int i = 0; i < numVertexes; i++) {   //将度为0的顶点依次入栈

           if(Vertex[i].in == 0){
               s.push(Vertex[i]);
           }
       }

       while (!s.empty()){
           /*栈顶元素出栈，并将以其为弧尾的弧头顶点的入度减一，若减完后入度为0，
             将其顶点入栈。
            */
           VertexNode v = (VertexNode)s.pop();
           System.out.println(v.data);
           count++;
           EdgeNode e = v.firstedge;
           while (e != null){
               if(--Vertex[e.adjvex].in == 0){
                   s.push(Vertex[e.adjvex]);
               }
               e = e.next;
           }
       }

       if(count < numVertexes)
           return false;     //若出栈的顶点数少于顶点数，则说明图有环
       else
           return true;
   }
}
