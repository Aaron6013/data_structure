package Graph.lin_jie_jv_zhen;
import java.util.*;

/**
 * @author Aaron
 * @date 2020/3/28 - 16:03
 */
public class CreateMGraph {
/*无向图*/

    int numVertexes; //顶点数
    int numEdges;    //边数
    int[] arr;      //顶点矩阵
    int[][] arr1;   //邻边矩阵
    boolean[] visited; //访问标记矩阵，访问过的顶点对应为true，否则为false
    Queue q; //LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用

    public CreateMGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        arr = new int[numVertexes];
        arr1 = new int[numVertexes][numVertexes];
        q = new LinkedList(); //LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用
        visited = new boolean[numVertexes];
        for (int i = 0; i < numVertexes; i++) {
            visited[i] = false; //刚开始都没有访问过
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
            System.out.println("输入边（vi,vj）上的下标i，下标j(按顺序按回车键结束一次输入,1为有边，0为无边):");
            int i = s.nextInt();
            int j = s.nextInt();
            arr1[i][j] = 1;
            arr1[j][i] = arr1[i][j]; //无向为对称矩阵
            p++;
        }
        return arr1;
    }


    public void DFS(int beginNode) { //beginNode为从beginNode个顶点开始访问
    //深度优先遍历
        visited[beginNode] = true;
        System.out.println(arr[beginNode]);
        for (int i = 0; i < arr.length; i++) {
            if (arr1[beginNode][i] == 1 && visited[i] == false) {
                /*benginNode和i之间有边，且i没被访问过 */
                this.DFS(i);
            }
        }
    }

    public void BFS(){
    /*广度优先遍历（运行了深度优先后，visit数组值全改为true，需改回来）
      从第一个顶点开始，若没被访问过，先入栈，然后出栈，找到其可到顶点，依次将
      他们入栈，并标记为访问*/
        for (int i = 0; i < numVertexes; i++) {
            if(visited[i] == false){
                visited[i] = true;
                System.out.println(arr[i]);
                q.add(arr[i]);
                while (!q.isEmpty()){
                    int a = (int)q.remove();
                    for(int j = 0;j < numVertexes;j++){
                        if(arr1[a][j] == 1 && visited[j] == false){  //找出栈结点能够到的没有访问的所有结点，进栈并标记访问过
                            visited[j] = true;
                            System.out.println(arr[j]);
                            q.add(arr[j]);
                        }
                    }
                }
            }
        }
    }
}
