
import Graph.Undigraph;

import java.util.Stack;

/**
 * 寻找路径
 */
public class Paths {


    boolean[] marked;  // 是否已经遍历过
    int count; // 连通的顶点个数

    private int[] edgeTo;  // 从起点到一个顶点的已知路径上的最后一个顶点
    private int startPoint;  // 起点




    /**
     * 在图 G中找到所有起点为S的路径
     * @param G 图
     * @param s 起点
     */
    public Paths(Undigraph G,int s){

        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.startPoint = s;
        dfs(G,s);

    }


    private void dfs(Undigraph G,int v){

        marked[v] = true;
        count ++;
        for (int w:G.GAdj[v]){
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G,w);
            }
        }

    }



    /**
     * 从起点s到顶点v是否存在路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v){

        return marked[v];
    }


    /**
     * 从起点s到v的路径
     * @param v
     * @return
     */
    Iterable<Integer> pathTo(int v){
       if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v;x != startPoint;x = edgeTo[x]){
            path.push(x);
        }
        path.push(startPoint);
        return path;

    }
}
