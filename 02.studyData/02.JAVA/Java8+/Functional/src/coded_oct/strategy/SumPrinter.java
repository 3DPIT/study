package coded_oct.strategy;

public class SumPrinter {

    void print(SumStrategy strategy, int N){
        System.out.printf("1-%d 까지의 합은",N);
        System.out.println(strategy.get(N));
    }

}
