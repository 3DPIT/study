namespace TemplateMethod;

public class AddTest
{
    public static void Main(string[] args)
    {

        int[] number = { 1, 2, 3, 4, 5 };

        Template addNumber = new Plus(number);
        int result = addNumber.Result();
        Console.WriteLine(result);

        Template multipleNumber = new Multiple(number);
        int result2 = multipleNumber.Result();
        Console.WriteLine(result2);
    }
}