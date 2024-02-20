package design.pattern.strategy.strategy2;

public class GaussSumStrategy implements SumStrategy{
    @Override
    public int get(int N) {
        return ((N+1)*N)/2;
    }
}
