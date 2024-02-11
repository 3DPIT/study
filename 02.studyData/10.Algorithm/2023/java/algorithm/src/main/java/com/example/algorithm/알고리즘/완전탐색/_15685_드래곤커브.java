package com.example.algorithm.알고리즘.완전탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _15685_드래곤커브 {
    static int[][] board = new int[104][104];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N= Integer.parseInt(br.readLine());

        while(N-- > 0){
            String[] inputValue =br.readLine().split(" ");
            int x =Integer.parseInt(inputValue[0]);
            int y =Integer.parseInt(inputValue[1]);
            int d =Integer.parseInt(inputValue[2]);
            int G =Integer.parseInt(inputValue[3]);
            List<Integer> dragonRoad= saveRoad(d,G);
            recordBoard(dragonRoad,y,x);
        }

        int ret = checkDragonCurve(board);

        bw.write (ret+"\n");
        bw.flush();
    }

    private static List<Integer> saveRoad(int d, int G){
        List<Integer> road= new ArrayList<>();

        road.add(d);
        for(int g =0; g<G;g++){
            for(int i=road.size()-1;i>=0;i--){
                int dir = road.get(i);
                dir = (dir+1)%4;
                road.add(dir);
            }
        }
        return road;
    }

    private static int[][] recordBoard(List<Integer> road, int y,int x){
        int dy[]={0,-1,0,1};
        int dx[]={1,0,-1,0};

        board[y][x]=1;
        for(int i=0;i<road.size();i++){
            y+=dy[road.get(i)];
            x+=dx[road.get(i)];
            board[y][x]=1;
        }
        return board;
    }

    private static int checkDragonCurve(int[][] board){
        int dy[]={0,0,1,1};
        int dx[]={0,1,0,1};
        int count=0;

        for(int y=0;y<100;y++){
            for(int x=0;x<100;x++){
                if(board[y][x]==1&&board[y][x+1]==1&&board[y+1][x]==1&&board[y+1][x+1]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
