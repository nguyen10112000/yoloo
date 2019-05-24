import java.io.*;
import java.util.*;


class Graph{
    private int V;

    private LinkedList<Integer> adj[];

    Graph(int v){
        V=v;
        adj = new LinkedList[v];
        for(int i=0; i<v; i++){
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
    }

    void DFSutil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+ " ");

        Iterator<Integer> i = adj[v].listIterator();

        while (i.hasNext()){
            int n = i.next();
            DFSutil(n, visited);
        }
    }

    void DFS(int v){
        boolean[] visited = new boolean[V];
        DFSutil(v, visited);
    }

    void BFS(int v){
        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[v] = true;
        queue.add(v);

        while(queue.size()!=0){

            v = queue.poll();
            System.out.print(v+" ");

            Iterator<Integer> i = adj[v].listIterator();
            while(i.hasNext()){
                int n=i.next();
                if (!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }



};

public class Main {

    public static boolean yasuo(int xb, int yb, int x1, int y1, int x2, int y2){
        if (xb < yb){
            if(yb%xb != 0 || xb == 1) {return true;}
            else{
                int k = yb/xb;
                int x3 = 1, y3 = k; // đây là tọa độ cây chắn view gần (0,0) nhất
                int x4 = xb-1, y4 = k*(xb-1); // đây là tọa độ cây chắn view gần (xb,yb) nhất (gần con Belle nhất)
                if (x3 >= x1 && x3 <= x2 && y3 >= y1 && y3<= y2 && x4 >= x1 && x4 <= x2 && y4 >= y1 && y4<= y2){
                    return true;
                } // test xem 2 cây này có bị chặt k. 2 cây này bị chặt auto các cây ở giữa bị chặt vì cắt cả 1 khu theo hình chữ nhật
                else {return false;}
            }
        }
        else{
            if(xb%yb != 0 || yb == 1) {return true;}
            else{
                int k = xb/yb;
                int y3 = 1, x3 = k; // đây là tọa độ cây chắn view gần (0,0) nhất
                int y4 = yb-1, x4 = k*(yb-1); // đây là tọa độ cây chắn view gần (xb,yb) nhất (gần con Belle nhất)
                if (x3 >= x1 && x3 <= x2 && y3 >= y1 && y3<= y2 && x4 >= x1 && x4 <= x2 && y4 >= y1 && y4<= y2){
                    return true;
                } // test xem 2 cây này có bị chặt k. 2 cây này bị chặt auto các cây ở giữa bị chặt vì cắt cả 1 khu theo hình chữ nhật
                else {return false;}
            }
        }
    }

    public static void main(String[] args) {

        System.out.print(yasuo(2,6, 3, 5,5,7));
    }
}
