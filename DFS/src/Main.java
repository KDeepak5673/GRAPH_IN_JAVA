import java.util.ArrayList;

public class Main {

    static class Edge{
        int src;
        int dist;

        public Edge(int s, int d){
            this.src = s;
            this.dist = d;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[0].add(new Edge(1, 0));
//        graph[0].add(new Edge(1, 3));

        graph[0].add(new Edge(2, 0));
        graph[0].add(new Edge(2, 4));

//        graph[0].add(new Edge(3, 1));
        graph[0].add(new Edge(3, 4));
        graph[0].add(new Edge(3, 5));

        graph[0].add(new Edge(4, 2));
        graph[0].add(new Edge(4, 3));
        graph[0].add(new Edge(4, 5));

        graph[0].add(new Edge(5, 3));
        graph[0].add(new Edge(5, 4));
        graph[0].add(new Edge(5, 6));

        graph[0].add(new Edge(6, 1));
    }

    public static void dfs(ArrayList<Edge>[] graph , int curr , boolean[] vis){
        System.out.println(curr+" ");
        vis[curr] = true;

        for (int i = 0; i < graph.length; i++) {
            Edge e = graph[curr].get(i);

            if(!vis[curr]) dfs(graph , e.dist , vis);
        }
    }
    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        for (int i = 0; i < vis.length; i++) {
            if(!vis[i]){
                dfs(graph , i , vis);
            }
        }

    }
}