
import Graph.Undigraph;

/**
 * 图的搜索的API
 */
public class Search {




    private int startPoint;// 起点

    private  Undigraph graph; // 图
    // 图处理算法的API

    /**
     * 找到和起点S连通的所有顶点
     * @param graph  图
     * @param s 顶点
     */
    public Search(Undigraph graph,int s){
        this.graph = graph;
        this.startPoint = s;
    }


    /** v 和 s 是连通的吗
     *
     * @param v
     * @return
     */
   public boolean marked(int v){

       return true;
   }

    /**
     * 和 s 连通的顶点总数.
     * @return
     */
   int count(){
        return 0;
   }





}
