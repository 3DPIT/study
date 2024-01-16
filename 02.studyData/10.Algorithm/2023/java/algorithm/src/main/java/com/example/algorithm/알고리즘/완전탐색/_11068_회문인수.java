package com.example.algorithm.알고리즘.완전탐색;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _11068_회문인수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int isRet = 1;
            String repeatSentence = br.readLine();
            int number = Integer.parseInt(repeatSentence);
            int count = 0;
            int ret = bToNumber(isRet,number);
            bw.write(ret+"\n");
            bw.flush();
        }
        bw.flush();
    }
    public static int bToNumber(int isRet,int number) {

        for (int N = 10; N <= 64; N++) {
            isRet = 0;
            List<Character> s = new ArrayList<>();
            int copyNumber = number;
            while (copyNumber > 0) {
                int ret1 = copyNumber / N;
                int ret2 = copyNumber % N;
                if (ret2 >= 10) s.add((char) (ret2 - 10 + 'A'));
                else s.add((char) (ret2 + '0'));
                copyNumber /= N;
            }
            int mid = s.size() / 2;
            int retCheck = mid;
            int L = 0;
            int R = 0;

            int checkCount = 0;

            for (int i = 0, j = s.size() - 1; i < s.size(); i++, j--) {
                if (s.get(i) != s.get(j)) {
                    break;
                }
                checkCount++;
            }
            if (checkCount == s.size()) {
                return 1;
            }
        }
        return 0;
    }

}
