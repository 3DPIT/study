namespace TemplateMethod;

public class AddTest
{
    public static void Main(string[] args)
    {
        int[] number = { 1, 2, 3, 4, 5 };
        AddTemplate addNumber = new AddTemplate(number);
        int result1 = addNumber.Result();
        Console.WriteLine(result1);

        MultipleTemplate multipleNumber = new MultipleTemplate(number);
        int result2 = multipleNumber.Result();
        Console.WriteLine(result2);
    }
}