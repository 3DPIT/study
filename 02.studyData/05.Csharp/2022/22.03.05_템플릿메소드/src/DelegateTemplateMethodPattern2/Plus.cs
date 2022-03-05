namespace TemplateMethod;

public class Plus : Operator
{
    int Operator.getResult(int sumResult, int number)
    {
        return sumResult+=number;
    }
}