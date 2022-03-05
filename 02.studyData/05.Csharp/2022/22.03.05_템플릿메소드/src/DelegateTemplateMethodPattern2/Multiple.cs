namespace TemplateMethod;

public class Multiple : Operator
{
    int Operator.getResult(int sumResult, int number)
    {
        if(sumResult==0) sumResult=1;
        return sumResult*=number;
    }
}