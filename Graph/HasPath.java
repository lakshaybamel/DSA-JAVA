import java.util.*;

public class HasPath {

    // Edge representation
    static class Edge {
        int src, dest, wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        // initialize adjacency list
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // add edges (undirected graph)
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }

    // DFS-based function to check if a path exists from src to dest
    public static boolean hasPath(ArrayList<Edge>[] graph,
                                  int src,
                                  int dest,
                                  boolean[] visited) {

        // base case: reached destination
        if (src == dest) {
            return true;
        }

        // mark current node as visited
        visited[src] = true;

        // explore all neighbors of current node
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i); // e.dest is neighbor

            // visit neighbor only if not visited
            if (!visited[e.dest]) {

                // recursively check path from neighbor to destination
                if (hasPath(graph, e.dest, dest, visited)) {
                    return true; // path found
                }
            }
        }

        // no path found from this route
        return false;
    }

    public static void main(String[] args) {

        int V = 7; // vertices: 0 to 6
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        // check if path exists from 0 to 5
        System.out.println(hasPath(graph, 0, 5, new boolean[V]));
    }
}
