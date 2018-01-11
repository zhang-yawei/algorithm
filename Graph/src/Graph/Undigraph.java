package Graph;

import java.io.*;
import java.lang.*;

public class Undigraph {

    private int V;  // 顶点数目
    private int E;  // 边数
    public Bag<Integer>[] GAdj; //  表示图的邻接表

//    public Undigraph(int V){
//        this.V = V;
//        this.E = 0;
//        GAdj = new Bag[V];
//
//        for (int v = 0;v < V;v++){
//            GAdj[v] = new Bag;
//        }
//
//    }



   public  Undigraph(BufferedReader reader){
        this.E = 0;
        int a = 0;
            try {
                while (true){
                 String s = reader.readLine();
              //   System.out.println(s);
                 if (s == null) break;

                 String[] arr = s.split("\\s+");
              //   System.out.println("-------------"+arr.length);
             if (a < 2){
                 if (a == 0) {
                     int countOfV = Integer.valueOf(arr[0]);

                     this.V = countOfV;
                     this.GAdj = new Bag[countOfV];
                     for (int v = 0;v < countOfV;v++){
                         this.GAdj[v] = new Bag(1);
                     }
                     a++;
                 }else if(a == 1){
                     a++;
                 }

             }else{

                 int v = Integer.valueOf(arr[0]);
                 int e = Integer.valueOf(arr[1]);
                 addEdge(v,e);
             }
                }

            }catch (IOException e){

            }

    }


/*顶点数*/
    public int V(){

        return V;
    }
/*边数*/
    public int E(){
        return E;
    }

    /*添加一条边  v--w*/
    public void addEdge(int v,int w){

        GAdj[v].add(w);
        GAdj[w].add(v);
        E++;
    }


    /*和v相邻的所有顶点*/

    public Iterable<Integer> adj(int v){
        return GAdj[v];
    }


    /*对象的字符串表示*/
    public String toString() {

        String s = V + "顶点数," + this.E+ "边数 \n";
        for (int v = 0; v < V; v++) {

            s += v + " : ";
            Iterable vBag = adj(v);
            for (Integer adjV : (Bag<Integer>)vBag) {
                s += adjV + "  ";
            }
            s += "\n";
        }

        return s;
    }













}
