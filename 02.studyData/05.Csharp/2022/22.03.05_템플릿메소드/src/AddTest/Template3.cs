namespace AddTest;

public class Template3
{
    private int[] _numbers;
    public Template3(int[] numbers)
    {
        _numbers = numbers;
    }
    public int Result(Operator operator1)
    {
        int sumResult =0;
        for(int i=0 ; i<_numbers.Length;i++){
            sumResult=operator1.getResult(sumResult,_numbers[i]);
        }
        return sumResult;
    }
}