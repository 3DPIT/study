namespace TemplateMethod;

public class AddTemplate
{
    private int[] _numbers;
    public AddTemplate(int[] numbers)
    {
        _numbers = numbers;
    }
    public int Result()
    {
        int sumResult = 0;
        for(int i=0 ; i<_numbers.Length;i++){
            sumResult+=_numbers[i];
        }
        return sumResult;
    }
}