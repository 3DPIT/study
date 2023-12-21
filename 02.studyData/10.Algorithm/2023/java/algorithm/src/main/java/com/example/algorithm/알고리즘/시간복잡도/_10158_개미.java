package com.example.algorithm.알고리즘.시간복잡도;

import java.util.Scanner;

public class _10158_개미 {
    public static void main(String[] args) {
        int[] dy = {1, -1, -1, 1};
        int[] dx = {1, 1, -1, -1};

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int cx = sc.nextInt();
        int cy = sc.nextInt();
        int t = sc.nextInt();
        int deltaY =1;
        int deltaX =1;
        int timeY= t%(2*N);
        int timeX =t%(2*M);
        for (int i = 0; i <timeY; i++) {
            if(cy == N) deltaY=-1;
            else if (cy==0) deltaY=1;
            cy +=deltaY;
        }

        for (int i = 0; i <timeX; i++) {
            if(cx==M) deltaX=-1;
            else if (cx==0) deltaX=1;
            cx +=deltaX;
        }

        System.out.printf("%d %d",cx,cy);
    }
}
