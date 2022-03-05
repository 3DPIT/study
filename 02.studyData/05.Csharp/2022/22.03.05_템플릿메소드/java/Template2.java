public class Template2
{
    private int[] _numbers;
    public Template2(int[] numbers)
    {
        _numbers = numbers;
    }
    public int Result(Operator operator1)
    {
        int sumResult =0;
        for(int i=0 ; i<_numbers.length;i++){
            sumResult=operator1.getResult(sumResult,_numbers[i]);
        }
        return sumResult;
    }
}