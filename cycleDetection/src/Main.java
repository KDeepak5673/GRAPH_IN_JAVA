import java.util.ArrayList;

public class Main {

    static class Edge{
        int src;
        int dest;

        public Edge(int s ,int d){
            this.src = s;
            this.dest = d;

        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0 , 2));

        graph[1].add(new Edge(1 , 0));

//        graph[2].add(new Edge(2 , 3));

        graph[3].add(new Edge(3 , 0));
    }

    public static boolean isCycleDirected(ArrayList<Edge>[] graph , boolean[] vis , int curr , boolean[] rec) {
        vis[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(rec[e.dest]){
                return true;
            } else if (!vis[e.dest]) {
                return isCycleDirected(graph, vis , e.dest , rec);

            }

        }
        rec[curr] = false;

        return false;
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        boolean[] rec = new boolean[V];

        for(int i = 0 ; i < V ; i++){
            if(!vis[i]){
                boolean ans =  isCycleDirected(graph, vis , 0 , rec);

                if(ans){
                    System.out.println("True");
                    break;

                }else {
                    System.out.println("False");
                    break;
                }

            }
        }

    }
}