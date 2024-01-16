package com.example.algorithm.알고리즘.test;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int[][] adjacencyMatrix;
    private int numNodes;

    public Graph(int[][] matrix) {
        adjacencyMatrix = matrix;
        numNodes = matrix.length;
    }

    public List<List<Integer>> findPaths(int start, int end, int k) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(start);
        dfs(start, end, k, currentPath, paths);
        return paths;
    }

    private void dfs(int current, int end, int k, List<Integer> currentPath, List<List<Integer>> paths) {
        if (current == end && currentPath.size() <= k + 1) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        if (currentPath.size() > k) {
            return;
        }

        for (int neighbor = 0; neighbor < numNodes; neighbor++) {
            if (adjacencyMatrix[current][neighbor] == 1 && !currentPath.contains(neighbor)) {
                currentPath.add(neighbor);
                dfs(neighbor, end, k, currentPath, paths);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
                {0, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };

        Graph graph = new Graph(adjacencyMatrix);
        int start = 0;
        int end = 3;
        int k = 4;

        List<List<Integer>> paths = graph.findPaths(start, end, k);

        System.out.println("Paths from " + start + " to " + end + " with length at most " + k + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }
}
