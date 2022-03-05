namespace AddTest;

public class AddTest
{
    public static void Main(string[] args)
    {

        int[] number = { 1, 2, 3, 4, 5 };
        Template addNumber = new Plus(number);
        int addResult = addNumber.Result();
        Console.WriteLine(addResult);

        Template multipleNumber = new Multiple(number);
        int multipleResult = multipleNumber.Result();
        Console.WriteLine(multipleResult);

        Template2 addNumber2 = new Template2(number);
        Func<int, int,int> operator1 = (sumResult, number) => sumResult+=number;
        int result2 = addNumber2.Result(operator1);
        Console.WriteLine(result2);

        Template3 addNumber3 = new Template3(number);
        int result3 = addNumber3.Result(new Plus3());
        Console.WriteLine(result3);
    }
}