package designPattern.strategy;

public class GaussSumStrategy implements SumStrategy {
    @Override
    public int get(int N) {
        return (N*(N+1))/2;
    }
}
