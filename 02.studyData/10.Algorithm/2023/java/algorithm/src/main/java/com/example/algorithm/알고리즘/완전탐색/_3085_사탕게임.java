package com.example.algorithm.알고리즘.완전탐색;
//3
//        CCP
//        CCP
//        PPC

//4
//        PPPP
//        CYZY
//        CCPY
//        PPCC
//
//        5
//        YCPZY
//        CYZZP
//        CCPPP
//        YCYZC
//        CPPZZ

import java.io.*;
import java.util.*;

public class _3085_사탕게임 {
    public static class Pos {
        int y;
        int x;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static List<Pos> D = new ArrayList<>();
    static int maxLineCount = -1;
    static int dy[] = {0, 1};
    static int dx[] = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            String inputString = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = inputString.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int dir = 0; dir < 2; dir++) {
                    int ny = i + dy[dir];
                    int nx = j + dx[dir];
                    if(board[i][j]==board[ny][nx]) continue;
                    char[][] copyBoard = new char[N][];
                    for (int k = 0; k < N; k++) {
                        copyBoard[k] = board[k].clone();
                    }

                    if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                        char copyCandy = copyBoard[i][j];
                        copyBoard[i][j] = copyBoard[ny][nx];
                        copyBoard[ny][nx] = copyCandy;
                    }
                    checkLongCandy(N, copyBoard);
                }
            }
        }

        bw.write(maxLineCount + "\n");
        bw.flush();
    }

    private static void checkLongCandy(int N, char[][] board) {
        //검증
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                int count = 1;
                int copyJ = j;
                int s = board[i][copyJ];
                copyJ++;
                while (copyJ < N && s == board[i][copyJ]) {
                    count++;
                    copyJ++;
                }
                if (maxLineCount < count) {
                    maxLineCount = count;
                }
            }
        }
        //검증
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                int count = 1;
                int copyI = i;
                int s = board[copyI][j];
                copyI++;
                while (copyI < N && s == board[copyI][j]) {
                    count++;
                    copyI++;
                }
                if (maxLineCount < count) {
                    maxLineCount = count;
                }
            }
        }
    }
}

