package designPattern.strategy;

public class Main  {
    public static void main(String[] args) {
        SumPrinter cal = new SumPrinter();
        cal.print(new SimpleSumStrategy(),5);
        cal.print(new GaussSumStrategy(),5);
        cal.print(new KmSumStrategy(),5);
    }
}
