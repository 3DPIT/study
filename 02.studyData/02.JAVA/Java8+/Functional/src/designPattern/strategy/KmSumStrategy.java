package designPattern.strategy;

public class KmSumStrategy implements SumStrategy{
    @Override
    public int get(int N) {
        int km = 32;
        return 32 + N;
    }
}
