namespace TemplateMethod;

public class Multiple : Template
{
    public Multiple(int[] numbers) : base(numbers)
    {

    }

    protected override int getResult(int sumResult, int number)
    {
        if(sumResult==0) sumResult=1;
        return sumResult *= number;
    }
}