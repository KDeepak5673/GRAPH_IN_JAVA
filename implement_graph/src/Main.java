import java.util.ArrayList;

public class Main {

    static class Edge{
        int src;
        int dist;

        public Edge(int s , int d){
            this.src = s;
            this.dist = d;
        }
    }

    public static  void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0 , 1));

        graph[1].add(new Edge(1 , 2));
        graph[1].add(new Edge(1 , 3));

        graph[2].add(new Edge(2 , 0));
        graph[2].add(new Edge(2 , 1));
        graph[2].add(new Edge(2 , 3));

        graph[3].add(new Edge(3 , 1));
        graph[3].add(new Edge(3 , 2));

    }
    public static void main(String[] args) {

        int V = 4;

        ArrayList<Edge> graph[] = new ArrayList[V];

        createGraph(graph);

        System.out.println("Print the Graph");
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ":");
            for (Edge edge : graph[i]) {
                System.out.print("  " +  "("+ edge.src + "," + edge.dist +  ")");
            }

            System.out.println("");
        }

        System.out.println("Print the 2's neighbours");
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dist + " ");
        }
    }
}