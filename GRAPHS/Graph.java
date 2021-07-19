import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class GraphAdjacencyMatrix{
    int n; // vertices
    int m; // edges
    int matrix[][];
    public GraphAdjacencyMatrix(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new int[n+1][n+1];  // 6 6
    }
    public void create() {
        // edge 1
        matrix[1][2] = 1;
        matrix[2][1] = 1;
        // edge 2
        matrix[4][2] = 1;
        matrix[2][4] = 1;
        // edge 3
        matrix[4][3] = 1;
        matrix[3][4] = 1;
        // edge 4
        matrix[5][3] = 1;
        matrix[3][5] = 1;
        // edge 5
        matrix[5][1] = 1;
        matrix[1][5] = 1;
        // edge 6
        matrix[1][3] = 1;
        matrix[3][1] = 1;
        // edge 7
        matrix[2][3] = 1;
        matrix[3][2] = 1;
    }
    public void diplay() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }



}
class GraphAdjacencyList{
     int n;
     int m;
     ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
     public GraphAdjacencyList(int n,int m) {
         this.n = n;
         this.m = m;
         for (int i = 0; i <= n; i++) {
             list.add(new ArrayList<>());
         }
     }
     public void createList() {
        // edge 1
        list.get(1).add(2);
        list.get(2).add(1);
        // edge 2
        list.get(2).add(4);
        list.get(4).add(2);
        // edge 3
        list.get(4).add(3);
        list.get(3).add(4);
        // edge 4
        list.get(5).add(3);
        list.get(3).add(5);
        // edge 5
        list.get(5).add(1);
        list.get(1).add(5);
        // edge 6
        list.get(1).add(3);
        list.get(3).add(1);
        // edge 7
        list.get(2).add(3);
        list.get(3).add(2);
     }
     public void displayList() {
         for (int i = 0; i <= n; i++) {
             for (int j = 0; j < list.get(i).size(); j++) {
                 System.out.print(list.get(i).get(j)+" ");
             }
             System.out.println();
         }
     }


}
class GraphAdjacencyList2 {
    int V;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public GraphAdjacencyList2(int V) {
        this.V = V;
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
    }
    public void creatGraph(int src,int dest) {
        list.get(src).add(dest);
        list.get(dest).add(src);
    }
    public void displayGraph() {
        for (int i = 0; i <= V; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public void BFS() {
       Queue<Integer> que = new LinkedList<>();
       boolean visited[] = new boolean[V+1];
       que.add(0);
       visited[0] = true; 
       for(int i = 0; i <= V; i++) {
           if(!visited[i]) {
              while(!que.isEmpty()) {
                  int poll = que.poll();
                  System.out.print(poll+" ");
                  visited[poll] = true;

                  for(Integer x : list.get(poll)) {
                      if(!visited[x]) {
                         visited[x] = true;
                         que.add(x);
                      }
                  }
              }
           }
       }
    }
    public void dfsUtil(int ver,boolean vis[]) {
        vis[ver] = true;
        System.out.print(ver+" ");
        for (Integer integer : list.get(ver)) {
            if(!vis[integer]) {
                dfsUtil(integer, vis);
            }
        }
    }
    public void DFS(int start) 
    { 
        boolean vis[] = new boolean[V+1];
        for(int i = start; i <= V; i++) {
           if(!vis[i]) 
           dfsUtil(i, vis);
        }
    }
    public void DFS1() 
    { 
        boolean vis[] = new boolean[V+1];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        vis[0] = true; 
        for(int i = 1; i <= V; i++) {
           if(!vis[i]) {
               while(!stack.isEmpty()) {
                  int p = stack.pop();
                  System.out.print(p+" ");
                  vis[p] = true;
                  for(Integer x : list.get(p)) {
                      if(!vis[x]) {
                          vis[x] = true;
                          stack.push(x);
                      }
                  }
              }
           }
           
        }
    }
    
    public static boolean cycleUtil(int start, ArrayList<ArrayList<Integer>>adj,boolean vis[]) {
         Queue<CheckCycle> que = new LinkedList<>();
         que.add(new CheckCycle(start, -1));
         vis[start] = true;

         while(!que.isEmpty()) {
             int curr = que.peek().curr; // Why ?
             int prev = que.peek().prev;
             que.remove();

             for(Integer x : adj.get(curr)) {
                 if(!vis[x]) {
                     vis[x] = true;
                     que.add(new CheckCycle(x, curr));
                 }
                 else if(x != prev) {
                     return true;
                 }
             }
         }
         return false;
    }
    public boolean isCycle() {
        boolean vis[] = new boolean[V+1];
        for (int i = 0; i <= V; i++) {
            if(!vis[i]) {
                if(cycleUtil(i,list,vis)) {
                    return true;
                }
            }
        }
        return false;
    }

} 

class CheckCycle {
    int curr;
    int prev;

    public CheckCycle(int curr, int prev) {
       this.curr = curr;
       this.prev = prev;
    }
}

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nBy AdjacencyList2 :");
        System.out.println("\nEnter Vertex and Edges : ");
        int v = sc.nextInt();
        int e = sc.nextInt();
        GraphAdjacencyList2 l2 = new GraphAdjacencyList2(v);

        System.out.println("\nEnter "+ e + " edges :" );
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            l2.creatGraph(src, dest);
        }
        System.out.println();
        System.out.println("\nBreadth First Search : ");
        l2.BFS();
        System.out.println("\nDepth First Search1 : ");
        l2.DFS1();
        System.out.println("\nShow: ");
        l2.displayGraph();
        
        // System.out.println("\nDepth First Search2 : ");
        // l2.DFS3(4);


        // GraphAdjacencyMatrix g = new GraphAdjacencyMatrix(5, 7);
        // GraphAdjacencyList l = new GraphAdjacencyList(5, 7);
        // g.create();
        // System.out.println("\nBy AdjacencyMatrix :");
        // g.diplay();
        // System.out.println("\nBy AdjacencyList :");
        // l.createList();
        // l.displayList();

         // System.out.println("\nBy AdjacencyList2 Display :");
        // l2.displayGraph();
    }
}