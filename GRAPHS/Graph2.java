import java.util.LinkedList;
import java.util.Scanner;

public class Graph2 {
    
    private LinkedList<Integer> adj[];

    public Graph2(int v) {
		adj = new LinkedList[v+1];   // 6
		for(int i = 0; i <= v; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int source, int destination) {
		adj[source].add(destination);
		adj[destination].add(source);
	}
    public void show() {
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(adj[i].get(j)+" ");
            }
            System.out.println();
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of vertices and edges");
		
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		Graph2 graph = new Graph2(v);
		System.out.println("Enter "+ e +" edges");
		for(int i = 0; i < e; i++) {
			int source = sc.nextInt();
			int destination = sc.nextInt();
			
			graph.addEdge(source, destination);
		}
		System.out.println();
        graph.show();
    }
}