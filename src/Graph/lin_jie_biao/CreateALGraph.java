package Graph.lin_jie_biao;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * @author Aaron
 * @date 2020/3/28 - 16:53
 */
public class CreateALGraph {
/*无向图*/
    int numVertexes; //顶点数
    int numEdges;    //边数
    VertexNode[] Vertex;  //顶点矩阵
    Boolean[] visited;
    Queue q; //LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用

    public CreateALGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        Vertex = new VertexNode[numVertexes];
        visited = new Boolean[numVertexes];
        q = new LinkedList();
        for(int i = 0;i < numVertexes;i++){
            visited[i] = false;
        }
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
            /*采用头插法，和链表使用的尾插法不一样*/
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

    public void DFS(int beginNode){

        visited[beginNode] = true;
        System.out.println(Vertex[beginNode].data);
        EdgeNode e = Vertex[beginNode].firstedge;
        //beginNode连着的点存在，且没被访问过，则调用DFS函数，此次beginNode为e.adjvex
        while (e != null){
            if(visited[e.adjvex] != true)
                DFS(e.adjvex);
            e = e.next;
        }

    }

    public void BFS(){

        for (int i = 0; i < numVertexes; i++) {
            if(visited[i] == false){
                visited[i] = true;
                System.out.println(Vertex[i].data);
                q.add(Vertex[i]);
                while (!q.isEmpty()){
                    VertexNode a = (VertexNode) q.remove();
                    EdgeNode e = a.firstedge;
                    while (e != null && visited[e.adjvex] == false){
                        visited[e.adjvex] = true;
                        System.out.println(Vertex[e.adjvex].data);
                        q.add(Vertex[e.adjvex]);
                        e = e.next;
                    }
                }
            }
        }
    }
}

