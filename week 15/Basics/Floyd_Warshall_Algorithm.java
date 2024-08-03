import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    final static int INF = 99999, V = 4;

    void floydWarshall(int graph[][]) {
        int dist[][] = new int[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist);
    }

    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Floyd_Warshall_Algorithm {
    final static int INF = 99999, V = 4;

    public static void main(String[] args) {
        int graph[][] = { { 0, 5, Integer.MAX_VALUE, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 },
                { INF, INF, INF, 0 } };
        Solution a = new Solution();
        a.floydWarshall(graph);
    }
}