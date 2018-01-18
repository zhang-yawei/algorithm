
import Graph.Undigraph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 图的广度优先搜索
 */
public class BreadFristSearch {

    private boolean[] marked;    //表示该值是否被访问过
    private LinkedList<Integer> linkedList;   // 访问队列
    private int startPoint;                     //
    private Undigraph G;
    private int[] edgeTo;           // 访问路径.


    public BreadFristSearch(Undigraph G,int S){
        this.G = G;
        this.startPoint = S;
        marked = new  boolean[G.V()];
        linkedList = new LinkedList<>();
        edgeTo = new  int[G.V()];
        bfs(G,S);
    }


    /**
     * 广度优先搜索图
     * @param G
     * @param s
     */
    public void bfs(Undigraph G, int s){
        linkedList.add(s);
        while (linkedList.peek() != null){
            int p = linkedList.poll();
            for (int v:G.GAdj[p]){
               if (!marked[v]){
                   linkedList.add(v);
                   edgeTo[v] = p;
                   marked[v] = true;
               }
            }
        }

    }



    /** v 和 s 是连通的吗
     *
     * @param v
     * @return
     */
    public boolean marked(int v){

        return marked[v];
    }

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
        LinkedList<Integer> path = new LinkedList<Integer>();
        for (int x = v;x != startPoint;x = edgeTo[x]){
            path.add(x);
        }
        path.add(startPoint);
        return path;

    }

}
