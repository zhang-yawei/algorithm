import Graph.Undigraph;


/**
 * 深度优先搜索
 */
public class DepthFirstSearch {

    private int startPoint;// 起点

    private Undigraph graph; // 图

    private boolean[] marked;  // 标记顶点是否已经被询问过了.
    private int count;     // 和s连通顶点的个数





    // 图处理算法的API

    /**
     * 找到和起点S连通的所有顶点
     * @param graph  图
     * @param s 顶点
     */
    public DepthFirstSearch(Undigraph graph, int s){
      //  this.graph = graph;
       // this.startPoint = s;
        marked = new boolean[graph.V()];  // 和顶点合数相同大小的数组
        dfs(graph,s);  //

    }


    /**  深度优先搜索
     *
     * 找到图G中和 v 连通的所有的顶点的个数
     * @param G 图
     * @param v 顶点
     */
    private void dfs(Undigraph G, int v){
        marked[v] = true;
        count ++;
        for (int w:G.GAdj[v]){
             if(marked(w) == false){
                 dfs(G,w);

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

    /**
     * 和 s 连通的顶点总数.
     * @return
     */
    int count(){
        return count;
    }

}
