package com.dipit3.black.middle._04_wrapper.ex1.pratice;

import java.util.*;

public class LottoGeneratorMain {
    public static void main(String[] args) {

        LottoGenerator lottoGenerator = new LottoGenerator();
       int[] lottoNumbers =  lottoGenerator.generate();
        System.out.print("로또 번호: ");
        for(int lottoNumber : lottoNumbers){
            System.out.print(lottoNumber + " ");
        }

//        Random random = new Random();
//        Set<Integer> list = new HashSet<>();
//        while(true) {
//            int a = random.nextInt(45) + 1;
//            list.add(a);
//            if(list.size() == 6) {
//                break;
//            }
//        }
//
//        List<Integer> list1 = new ArrayList<>(list);
//        Collections.sort(list1);
//
//        System.out.print("로또 번호: ");
//        for(int i : list1) {
//            System.out.print(i + " ");
//        }
    }
}

/*요구사항
로또 번호를 자동으로 만들어주는 자동 생성기를 만들자
로또 번호는 1~45 사이의 숫자를 6개 뽑아야 한다.
각 숫자는 중복되면 안된다.
실행할 때 마다 결과가 달라야 한다.
 */

/*실행 결과
로또 번호: 11 19 21 35 29 16
 */
