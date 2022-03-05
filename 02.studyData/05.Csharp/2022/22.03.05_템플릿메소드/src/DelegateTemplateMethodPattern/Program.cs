namespace TemplateMethod;

public class AddTest
{
    public static void Main(string[] args)
    {

        int[] number = { 1, 2, 3, 4, 5 };

        Template addNumber = new Template(number);
        Func<int, int, int> addTemplate = (sumResult, number) => sumResult+=number;
        int result = addNumber.Result(addTemplate);
        Console.WriteLine(result);

        Template multipleNumber = new Template(number);
        Func<int, int, int> multipleTemplate = (sumResult, number) =>
        {
            if(sumResult==0) sumResult = 1;
            return sumResult *= number;
        };
        int result2 = multipleNumber.Result(multipleTemplate);
        Console.WriteLine(result2);
    }
}