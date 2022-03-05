namespace AddTest;

public class Add
{
    private int[] _numbers;
    public Add(int[] numbers)
    {
        _numbers = numbers;
    }
    public int Result()
    {
        int sumResult =0;
        for(int i=0 ; i<_numbers.Length;i++){
            sumResult+=_numbers[i];
        }
        return sumResult;
    }
}