package Graph.MiniSpanTree_Prim;

import java.util.Scanner;

/**
 * @author Aaron
 * @date 2020/3/29 - 17:48
 */
public class CreateMGraph {

    int numVertexes; //顶点数
    int numEdges;    //边数
    int[] arr;      //顶点矩阵
    int[][] arr1;   //邻边矩阵

    public CreateMGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        arr = new int[numVertexes];
        arr1 = new int[numVertexes][numVertexes];
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

    /*最小生成树*/
    public void MiniSpanTree_Prim(){

        int min;
        int k;
        int p;

        int[] adjvex = new int[numVertexes];  //mst[i]:表示对应lowcost[i]的起点，即说明边<mst[i],i>是MST的一条边，当mst[i]=0表示起点i加入MST
        int[] lowcost = new int[numVertexes];  //lowcost[i]:表示以i为终点的边的最小权值,当lowcost[i]=0说明以i为终点的边的最小权值=0,也就是表示i点加入了MST

        lowcost[0] = 0; //顶点0加入生成树
        adjvex[0] = 0;

        //初始化lowcost数组和adjvex数组
        for (int i = 0; i < numVertexes; i++) {

            lowcost[i] = arr1[0][i];  //现在lowcost为arr1的第一行，值为各顶点到顶点0的权值
            adjvex[i] = 0;   //所有起点均为顶点0
        }

        for(int j = 1;j < numVertexes;j++) {  //j仅为次数，代表要找出所有结点

           min = 65535; //初始化最小权值为65536
           k = 0;
           p = 1;  //顶点0此时已经为最小生成树顶点，从顶点1开始找下一个最小生成树顶点
           while (p < numVertexes){  //第一次：找一个到顶点0权值最小的顶点，作为下一个最小生成树的点
               if(lowcost[p] != 0 && lowcost[p] < min){
                   //寻找下一个最小生成树的点
                   min = lowcost[p];
                   k = p;  //最终k成为下一个最小生成树顶点
               }
               p++;
           }

           System.out.println("起点为：" + adjvex[k] + ",终点为：" + k);
           lowcost[k] = 0; //将顶点k列入最小生成树

           /*更新lowcost和adjvex，此时起点已经为k，而不是0*/
            for (int i = 1; i < numVertexes; i++) {
                if(lowcost[i] != 0 && lowcost[i] > arr1[k][i]){  //不等于0意思是排查已经在最小生成树的顶点，只有k到i权值大于原来的权值才进行更改
                    lowcost[i] = arr1[k][i];  //对应权值改为从顶点k到顶点i的权值
                    adjvex[i] = k;  //起点改为k
                }
            }
        }
    }
}
