
/** 图是由一组顶点和一组能够将两个顶点(vertex)相连的边(edge)组成的
 * 自环:即一条连接一个顶点和其自身的边
 * 连接同一对顶点的两条边称为平行边.
 *
 * 1.含有平行边的图叫做多重图,没有平行边或者自环的图称为简单图
 * 2.
 *
 * 术语:
 * 1. 两个顶点通过一条边相连,我们称这两个顶点是相邻的.
 * 2. 顶点的度数是指 依附于该顶点的边的总数
 * 3. 子图:是由一幅图所有边的一个子集 以及 它们所依附的所有的顶点组成的图.
 * 4. 路径: 是由边顺序链接的一系列顶点
 * 5. 简单路径: 是一条没有重复顶点的路径
 * 6. 环: 是至少有一条边切起点和终点相同的路径
 * 7. 简单环: 是一条(除了起点和终点相同之外)不含有重复顶点和边的环.
 * 8. 路径或者环的长度为其中所包含的边数
 * 9. 如果从任意一个顶点都存在一条路径到达另一个任意顶点,我们称这幅图是连通图.
 *    一幅非连通的图由若干连通的部分组成,它们都是其极大连通子图.
 * 10. 树是一幅无环连通图. 互不相连的树组成的集合叫做 森林. 连通图的生成树是它的子图, 它含有图中所有顶点且是一颗树. 图的生成森林是它的所有连通子图的生成树的集合
 * 11. 图的密度是指 已经连接的顶点对占所有可能被连接的顶点对的比例.
 *
 *
 */

import Graph.Undigraph;

import java.io.*;

public class Graph {
    public static void main(String[] args){


        try {
            FileReader reader = new FileReader(new File("/Users/lidaoyuan/Desktop/FMProjects/algorithm/Graph/src/mediumG.txt")); // 读取文本中内容
            BufferedReader br = new BufferedReader(reader);

            Undigraph undigraph =new Undigraph(br);
            undigraph.toString();

        }catch (IOException e) {

        }



    // 计算V的度数
    public static int degree(Undigraph ung,int v){

        int degree = 0;
        for (int w:ung.adj(v)){
            degree++;
        }
        return degree;
    }


    // 计算所有顶点的最大度数
    public static int maxDegree(Undigraph undigraph){
        int max = 0;
        for (int i=0;i<)

    }
}


}