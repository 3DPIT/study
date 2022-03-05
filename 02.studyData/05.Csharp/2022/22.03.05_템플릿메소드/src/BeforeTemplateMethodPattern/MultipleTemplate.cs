namespace TemplateMethod;

public class MultipleTemplate
{
    private int[] _numbers;
    public MultipleTemplate(int[] numbers)
    {
        _numbers = numbers;
    }
    public int Result()
    {
        int sumResult = 1;
        for(int i=0 ; i<_numbers.Length;i++){
            sumResult*=_numbers[i];
        }
        return sumResult;
    }
}