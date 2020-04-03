package Graph.MiniSpanTree_Kruskal;

import java.util.Scanner;

/**
 * @author Aaron
 * @date 2020/3/31 - 16:12
 */
public class CreateMGraph {

    int numVertexes; //顶点数
    int numEdges;    //边数
    int[] arr;      //顶点矩阵
    Edge[] edge;   //边集数组
    int[] parent;

    public CreateMGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        arr = new int[numVertexes];
        edge = new Edge[numEdges];
        for (int i = 0; i < numEdges; i++) {
            edge[i] = new Edge();
        }
        parent = new int[numVertexes];
    }

    public int[] VertexNode(){
        //顶点矩阵创建
        for (int i = 0; i < numVertexes; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public Edge[] lin_jie_jv_zhen(){
        //边集数组创建
        Scanner s = new Scanner(System.in);

        int p = 0;
        while (p < numEdges) {
            System.out.println("输入边（vi,vj）上的下标i，下标j和权值(按顺序按回车键结束一次输入,1为有边，0为无边):");
            int i = s.nextInt();
            int j = s.nextInt();
            int weight = s.nextInt();
            edge[p].begin = i;
            edge[p].end = j;
            edge[p].weight = weight;
            p++;
        }
        return edge;
    }

    /*边集数组排序*/
    public void swapn(){

        for(int i = 0;i < numEdges;i++){
            for(int j = i+1;j < numEdges;j++){
                if(edge[i].weight > edge[j].weight){
                    int p = edge[i].begin;
                    int q = edge[i].end;
                    int t = edge[i].weight;
                    edge[i].begin = edge[j].begin;
                    edge[i].end = edge[j].end;
                    edge[i].weight = edge[j].weight;
                    edge[j].begin = p;
                    edge[j].end = q;
                    edge[j].weight = t;
                }
            }
        }
    }

    /*最小生成树*/
    public void miniSpanTree_Kruskal(){

        for(int i = 0;i < numEdges;i++){

            int m = find(edge[i].begin);
            int n = find(edge[i].end);

            if(n != m){
                parent[m] = n;
                System.out.println("顶点：" + edge[i].begin + ",顶点：" + edge[i].end + "权值：" + edge[i].weight);
            }
        }
    }

    public int find(int f){
        while (parent[f] > 0){
            f = parent[f];     //parent下标为生成树边的起点，值为终点
        }
        return f;
    }
}
