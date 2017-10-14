package Graph;


import java.io.*;

public class Undigraph {


   public  Undigraph(BufferedReader reader){

            try {
                while (true){
                    String lineStr = reader.readLine();
                    if (lineStr == null) break;
                     String s[] = lineStr.split(" ");
                     if (s.length == 0) break;
                     for (int i = 0;i<s.length;i++){
                         System.out.println(s[i]);
                     }
                }
            }catch (IOException e){

            }

    }

    public  Undigraph(int V){


    }


/*顶点数*/
    public int V(){

        return 0;
    }
/*边数*/
    public int E(){
        return 0;
    }

    /*添加一条边  v--w*/
    public void addEdge(int v,int w){

    }


    /*和v相邻的所有顶点*/

    public Iterable<Integer> adj(int v){
        return null;
    }

    /*对象的字符串表示*/
//    String toString(){
//        return super.toString();
//    }







    // 计算V的度数







}
