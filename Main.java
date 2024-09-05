import java.util.ArrayList;
import java.util.Scanner;

class Graph {
    private ArrayList<ArrayList<Integer>> adjList;

    // Constructor to initialize the graph with V vertices
    public Graph(int V) {
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add edge to the graph
    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);  // For an undirected graph
    }

    // Display the graph
    public void displayGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer edge : adjList.get(i)) {
                System.out.print(" -> " + edge);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of vertices and edges from user
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        Graph graph = new Graph(V);

        // Get all edges from user
        System.out.println("Enter the edges (source and destination): ");
        for (int i = 0; i < E; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        // Display the graph
        System.out.println("The adjacency list of the graph is: ");
        graph.displayGraph();

        scanner.close();
    }
}
