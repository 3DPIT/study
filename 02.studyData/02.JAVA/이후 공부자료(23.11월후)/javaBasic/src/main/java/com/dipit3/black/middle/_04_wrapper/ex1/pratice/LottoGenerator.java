package com.dipit3.black.middle._04_wrapper.ex1.pratice;


import java.util.Random;

public class LottoGenerator{
    private final Random random = new Random();
    private int[] lottoNumbers;
    private int count;

    public int[] generate(){
        lottoNumbers = new int[6];
        count =0;

        while(count <6){
            int number= random.nextInt(45)+1;
            if(isUnique(number)){
                lottoNumbers[count++]= number;
            }
        }
        return lottoNumbers;
    }

    private boolean isUnique(int number) {
        for (int i = 0; i < count; i++) {
            if (lottoNumbers[i] == number) {
                return false;
            }
        }

        return true;
    }
}
