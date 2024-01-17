package com.example.algorithm.알고리즘.완전탐색;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class  _1730_판화 {
    public static class Pos {
        int y;
        int x;
        List<Character> load;

        Pos(int y, int x) {
            this.y = y;
            this.x = x;
            this.load = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] load = br.readLine().toCharArray();
        char[][] board = new char[N+1][N];
        Pos[][] board2 = new Pos[N+1][N+1];
        int y = 0;
        int x = 0;
        int T = load.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board2[i][j] = new Pos(i, j);
            }
        }
        /*
        00 01 02
        10 11 12
        20 21 22
         */
        int dy[] = {-1, 1, 0, 0};//UDRL
        int dx[] = {0, 0, 1, -1};//0123
        int idx = 0;
        while (T-- > 0) {
            if (load[idx] == 'U') {
                int cy= y;
                int cx =x;
                y += dy[0];
                x += dx[0];
                if(y<0||y==N||x<0||x==N){
                    y -= dy[0];
                    x -= dx[0];
                    idx++;
                    continue;
                }
                board2[cy][cx].load.add('U');
                board2[y][x].load.add('U');
            } else if (load[idx] == 'D') {
                int cy= y;
                int cx =x;
                y += dy[1];
                x += dx[1];
                if(y<0||y==N||x<0||x==N){
                    y -= dy[1];
                    x -= dx[1];
                    idx++;
                    continue;
                }
                board2[cy][cx].load.add('D');
                board2[y][x].load.add('D');
            } else if (load[idx] == 'R') {
                int cy= y;
                int cx =x;
                y += dy[2];
                x += dx[2];
                if(y<0||y==N||x<0||x==N){
                    y -= dy[2];
                    x -= dx[2];
                    idx++;
                    continue;
                }
                board2[cy][cx].load.add('R');
                board2[y][x].load.add('R');
            } else {//L
                int cy= y;
                int cx =x;
                y += dy[3];
                x += dx[3];
                if(y<0||y==N||x<0||x==N){
                    y -= dy[3];
                    x -= dx[3];
                    idx++;
                    continue;
                }
                board2[cy][cx].load.add('L');
                board2[y][x].load.add('L');
            }
            idx++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board2[i][j].load.size() != 0) {
                    int[] check = new int[4];
                    if (board2[i][j].load.contains('U')) {
                        check[0] = 1;
                    }
                    if (board2[i][j].load.contains('D')) {
                        check[1] = 1;
                    }
                    if (board2[i][j].load.contains('R')) {
                        check[2] = 1;
                    }
                    if (board2[i][j].load.contains('L')) {
                        check[3] = 1;
                    }
                    if ((check[0] == 1 && check[1] == 1 && check[2] == 0 && check[3] == 0) ||(check[0] == 1 && check[1] == 0 && check[2] == 0 && check[3] == 0) || (check[0] == 0 && check[1] == 1 && check[2] == 0 && check[3] == 0)) {
                        System.out.print("|");
                    } else if ((check[0] == 0 && check[1] == 0 && check[2] == 1 && check[3] == 1) ||(check[0] == 0 && check[1] == 0 && check[2] == 1 && check[3] == 0) || (check[0] == 0 && check[1] == 0 && check[2] == 0 && check[3] == 1)) {
                        System.out.print("-");
                    } else {
                        System.out.print("+");
                    }
                } else {
                    System.out.print(".");

                }
            }
            System.out.println();
        }

        bw.flush();
    }
}

/**
 * 5
 * DRDRRUU
 * <p>
 * |..|.
 * ++.|.
 * .+-+.
 * .....
 * .....
 * <p>
 * 4
 * RRRDDDDULL
 * <p>
 * ---+
 * ...|
 * .--+
 * ...|
 * <p>
 * 5
 * RRDDLLUURRDDLLUUR
 * +-+..
 * |.|..
 * +-+..
 * .....
 * .....
 */