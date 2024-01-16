package com.example.algorithm.알고리즘.test;

import java.awt.*;
import java.io.*;

public class Main1 {
    public static int solution(String[] bishops){
        int answer=0;
        int[][] cheeseBoard = new int[9][9];
        int[] dy= {-1,-1,1,1};
        int[] dx= {-1,1,1,-1};

        for(int i=0;i<bishops.length;i++){
            int y = bishops[i].charAt(0)-'A'+1;
            int x = bishops[i].charAt(1)-'0';
            cheeseBoard[y][x]++;

            for(int dir=0;dir<4;dir++){
                int nextY = y +dy[dir];
                int nextX = x + dx[dir];

                while(nextX>=0&&nextX<=8&&nextY>=0&&nextY<=8){
                    cheeseBoard[nextY][nextX]++;
                    nextY +=dy[dir];
                    nextX +=dx[dir];
                }
            }
        }

        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){
                if(cheeseBoard[i][j]==0){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] bishops = {"C6","A4","E5"};
        int ret =  solution(bishops);

        bw.write(ret+"\n");
        bw.flush();
    }
}
