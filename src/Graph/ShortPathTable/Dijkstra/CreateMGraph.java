package Graph.ShortPathTable.Dijkstra;

import java.util.Scanner;

/**
 * @author Aaron
 * @date 2020/3/31 - 18:26
 */
public class CreateMGraph {

    int numVertexes; //顶点数
    int numEdges;    //边数
    int[] arr;      //顶点矩阵
    int[][] arr1;   //邻边矩阵
    int[] pathArc;  //起点为0顶点，到下标顶点，0要到的下一个顶点为其值
    int[] shortPathTable; //存储顶点0到各点（下标）的最小权值和
    int[] fin;   //对应下标为1表示求得顶点0到其最短路径

    public CreateMGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        arr = new int[numVertexes];
        arr1 = new int[numVertexes][numVertexes];
        pathArc = new int[numVertexes];
        shortPathTable = new int[numVertexes];
        fin = new int[numVertexes];
        //初始化邻接矩阵
        for (int i = 0; i < numVertexes; i++) {
            for(int j = 0;j < numVertexes; j++){
                if(i == j){
                    arr1[i][j] = 0;
                }else {
                    arr1[i][j] = 65536;   //刚开始顶点之间都不通
                }
            }
        }
    }

    public int[] VertexNode(){
        //顶点矩阵创建
        for (int i = 0; i < numVertexes; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public int[][] lin_jie_jv_zhen(){
        //邻接矩阵创建
        Scanner s = new Scanner(System.in);

        int p = 0;
        while (p < numEdges) {
            System.out.println("输入边（vi,vj）上的下标i，下标j和权值(按顺序按回车键结束一次输入,1为有边，0为无边):");
            int i = s.nextInt();
            int j = s.nextInt();
            int weight = s.nextInt();
            arr1[i][j] = weight;
            arr1[j][i] = arr1[i][j]; //无向为对称矩阵
            p++;
        }
        return arr1;
    }

    /*最短路径*/
    public int[] shortTestPath_Dijkstra(){
    /*仅能求得从某顶点开始到其它顶点的最短路径，默认起始点为0顶点
      和最小生成树的prim算法有点像*/
        int min;
        int k;

        for (int i = 0; i < numVertexes; i++) {
            shortPathTable[i] = arr1[0][i];
        }

        fin[0] = 1;   //顶点0已求完


        for(int j = 1;j < numVertexes;j++) {

            min = 65536;
            k = 0;

            for (int i = 0; i < numVertexes; i++) {
                if(fin[i] == 0 && shortPathTable[i] < min){  //在当前顶点能到的所有顶点中，选择一个距离最近的
                    min = shortPathTable[i];
                    k = i;
                }
            }

            fin[k] = 1;  //k也求完

            for (int i = 1; i < numVertexes; i++) {
                if(fin[i] ==  0 && (shortPathTable[i] > (arr1[k][i] + min))){
                    shortPathTable[i] = min + arr1[k][i];
                    pathArc[i] = k;
                }
            }
        }
        return pathArc;
    }
}
