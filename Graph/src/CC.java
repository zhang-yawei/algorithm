

import Graph.Undigraph;

/**
 * CC,连通分分量
 */
public class CC {


    private boolean[] marked;    // 标记顶点是否已经属于某个已知的连通分量
    private int[] id;         // 指示标识符的数组
    private int count;    // 连通分量的个数




    public CC(Undigraph G){

        marked = new boolean[G.V()];
        id = new int[G.V()];
        // 之所以fore循环遍历,是因为图有可能是非连通的
        for (int s=0 ;s < G.V();s++){
            if (!marked[s]){
                dfs(G,s);
                count++;
                }

        }
    }

    /**
     * 深度优先
     * @param G
     * @param v
     */
    private void dfs(Undigraph G,int v){
        marked[v] = true;
        id[v] = count;   // 把连通子图的唯一标识符id赋为 count
        for(int i:G.adj(v)){
            if (!marked[i]) dfs(G,i);
        }

    }





    /**
     * v 和 w连通吗
     * @param v
     * @param w
     * @return
     */
    public boolean connected(int v, int w){
        return id[v] == id[w];
    }


    /**
     * 连通分量数
     * @return
     */
    public int count(){

        return count;
    }


    /**
     * 顶点v所在的连通分量的标识符
     * @param v
     * @return
     */
    public int id(int v){
        return id[v];
    }


}
