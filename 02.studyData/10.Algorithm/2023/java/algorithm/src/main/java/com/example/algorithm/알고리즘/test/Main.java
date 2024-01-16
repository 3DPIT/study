package com.example.algorithm.알고리즘.test;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static class Graph {
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
    }


        public static int solution(int n, int[][] edges, int k, int a, int b) {
            int answer = 0;
            int[][] board = new int[n][n];
            for (int i = 0; i < edges.length; i++) {
                int y = edges[i][0];
                int x = edges[i][1];
                board[y][x] = board[x][y] = 1;
            }

            Graph graph = new Graph(board);
            List<List<Integer>> paths = graph.findPaths(a, b, k);

            for (List<Integer> path : paths) {
                for(int i=0;i<path.size()-1;i++){
                    board[path.get(i)][path.get(i+1)]++;
                    board[path.get(i+1)][path.get(i)]++;
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]>=2){
                        answer++;
                    }
                }
            }

            return answer/2;
        }

        public static void main(String[] args) throws IOException {

            int ret = solution(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {4, 0}, {5, 1}, {6, 1}, {7, 2}, {7, 3}, {4, 5}, {5, 6}, {6, 7}}, 3, 0, 3);

            System.out.println(ret);
        }
    }

       /**
         * 0->1
         * 1->2
         * 2->3
         * 4->0
         * 5->1
         * 6->!
         * 7->2
         * 7->3
         * 4->5
         * 5->6
         * 6->7
        *
        *
         *
         * 01   1
         * 10   1
         * 12   1
         * 21   1
         * 23   1
         * 32   1
         * 40
         * 04
         * 51
         * 15
         * 61   1
         * 16   1
         * 72   1
         * 27   1
         * 73   2
         * 37   2
         * 45
         * 54
         * 56
         * 65
         * 67   2
         * 76   2
         *
         * 7
         */

       //0 1
