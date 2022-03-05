namespace AddTest;

public class Plus3 : Operator
{
    int Operator.getResult(int sumResult, int number)
    {
        return sumResult+=number;
    }
}