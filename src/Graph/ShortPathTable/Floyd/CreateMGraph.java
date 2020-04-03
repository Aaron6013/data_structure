package Graph.ShortPathTable.Floyd;

import java.util.Scanner;

/**
 * @author Aaron
 * @date 2020/4/1 - 9:54
 */
public class CreateMGraph {

    int numVertexes; //顶点数
    int numEdges;    //边数
    int[] arr;      //顶点矩阵
    int[][] arr1;   //邻边矩阵
    int[][] P;  //记录到下标最近距离的前一顶点（行数为起点，下标为终点，值为前一顶点）
    int[][] D;  //记录到下标最近距离的权值和

    public CreateMGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        arr = new int[numVertexes];
        arr1 = new int[numVertexes][numVertexes];
        P = new int[numVertexes][numVertexes];
        D = new int[numVertexes][numVertexes];
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

    /*最短路径（可求得任意两顶点间的最短路径）*/
    public void shortTestPath_Floyd(){

        /*初始化P、D矩阵*/
        for (int i = 0; i < numVertexes; i++) {
            for(int j = 0; j < numVertexes; j++){
                D[i][j] = arr1[i][j];
                P[i][j] = j;  //从i到j的最短路径的下一结点，刚开始都为j
            }
        }

        for(int k = 0; k < numVertexes; k++){
            for (int i = 0; i < numVertexes; i++) {  //i为起点，j为终点，k为中转点
                for(int j = 0; j < numVertexes; j++){
                    if(D[i][k]+D[k][j] < D[i][j]){ //从中转点到j的距离比直接到j的距离小
                        D[i][j] = D[i][k]+D[k][j];
                        P[i][j] = P[i][k];
                    }
                }
            }
        }
    }

    /*输出最短路径*/
    public void printf(int begin,int end){
        int k = P[begin][end];
        if(k == end){  //直接到
            System.out.println("起点为：" + begin + "，终点为：" + end + "权值和为：" + D[begin][end]);
        }else {
            System.out.print("起点为：" + begin + " 途经：");
            while (k != end){
                System.out.print(k + " ");
                 k = P[k][end];  //i→k,k→j(中间可能不止一个中转点)
            }
            System.out.println("权值和为：" + D[begin][end]);
        }
    }
}
