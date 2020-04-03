package Graph.guan_jian_lu_jing;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Aaron
 * @date 2020/4/1 - 17:19
 */
public class CreateALGraph {

    int numVertexes;  //顶点数
    int numEdges;   //边数
    VertexNode[] Vertex;  //顶点矩阵
    int[] etv; //事件最早发生时间数组
    int[] ltv; //事件最晚发生时间数组
    Stack t1;  //储存拓扑序列的栈
    int[] r = {0,1,1,2,2,1,1,2,1,2};

    public CreateALGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        Vertex = new VertexNode[numEdges];
        etv = new int[numVertexes];
        ltv = new int[numVertexes];
        t1 = new Stack();
    }

    /*初试化顶点矩阵*/
    public void createVertexNode(){

        for (int i = 0; i < numVertexes; i++) {
            VertexNode v = new VertexNode(i,r[i]);
            Vertex[i] = v;
        }
    }

    /*初始化邻接表*/
    public void createEdgeNode(){

        int p = 0;

        while (p < numEdges) {

            Scanner s = new Scanner(System.in);
            System.out.println("输入边（vi,vj）上的下标i，下标j和权值(按顺序按回车键结束一次输入):");
            int i = s.nextInt();
            int j = s.nextInt();
            int weight = s.nextInt();

            EdgeNode e = new EdgeNode();
            e.adjvex = j;
            e.weight = weight;
            e.next = Vertex[i].firstedge;
            Vertex[i].firstedge = e;

            p++;
        }
    }

    /*拓扑序列*/
    public boolean topologicalSort(){

        Stack t = new Stack();
        int count = 0;
        for (int i = 0; i < numVertexes; i++) {
            if(Vertex[i].in == 0){
                t.push(Vertex[i]);
            }
        }

        while (!t.empty()){
            VertexNode v = (VertexNode)t.pop();
            count++;
            t1.push(v);

            EdgeNode e = v.firstedge;
            while (e != null){
                if(--Vertex[e.adjvex].in == 0){
                    t.push(Vertex[e.adjvex]);
                }
                if(etv[e.adjvex] < etv[v.data] + e.weight){
                    etv[e.adjvex] = etv[v.data] + e.weight;
                }
                e = e.next;
            }
        }

        if(count < numVertexes)
            return false;
        else
            return true;
    }

    /*求关键路径*/
    public void criticalPath(){

        //初始化ltv数组
        for (int i = 0; i < numVertexes; i++) {
            ltv[i] = etv[numVertexes-1]; //都为最后一个顶点发生的时间
        }

       while (!t1.isEmpty()){ //根据拓扑序列，出栈的顺序为从后向前
           VertexNode v = (VertexNode) t1.pop();
           EdgeNode e = v.firstedge;
           while (e != null){
               if(ltv[e.adjvex] - e.weight < ltv[v.data]){
               //为了不耽误工期，最后一个结点的前一个结点的最晚开工时间应为最后一个结点的开工时间减去他俩之间的权值
                   ltv[v.data] = ltv[e.adjvex] - e.weight;
               }
               e = e.next;
           }
       }

       for(int p = 0; p < numVertexes; p++){
           EdgeNode e = Vertex[p].firstedge;
           while (e != null){
               int ete = etv[p]; //活动最早发生时间
               int lte = ltv[e.adjvex] - e.weight; //活动最晚发生时间要早于边终点的发生时间ltv[e.adjvex]
               if(ete == lte){  //相等即为关键路径
                   System.out.println("<" + Vertex[p].data + "," + Vertex[e.adjvex].data +
                                       "> " + e.weight);
               }
               e = e.next;
           }
       }
    }
}
