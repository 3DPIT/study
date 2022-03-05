namespace TemplateMethod;

public class AddTest
{
    public static void Main(string[] args)
    {

        int[] number = { 1, 2, 3, 4, 5 };

        Template addNumber = new Template(number);
        int result = addNumber.Result(new Plus());
        Console.WriteLine(result);

        Template multipleNumber = new Template(number);
        int result2 = multipleNumber.Result(new Multiple());
        Console.WriteLine(result2);
    }
}