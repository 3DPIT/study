namespace TemplateMethod;

public class Plus : Template
{
    public Plus(int[] numbers) : base(numbers)
    {

    }

    protected override int getResult(int sumResult, int number)
    {
        return sumResult += number;
    }
}