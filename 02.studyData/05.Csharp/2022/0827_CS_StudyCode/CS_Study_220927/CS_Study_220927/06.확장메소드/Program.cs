
namespace main9;
public static class IntegerExtension
{
    public static int Power(this int myInt, int exponent)
    {
        int result = myInt;
        for (int i = 1; i < exponent; i++)
            result = result * myInt;

        return result;
    }

    public static int TwoPower(this string myInt, int exponent)
    {
        int result = 2;
        for (int i = 1; i < exponent; i++)
            result = result * 2;

        return result;
    }
}
class Program
{
    public static void Main(string[] args)
    {
        //정수형 기능 추가
        int a = 2;
        Console.WriteLine(a.Power(3));
        Console.WriteLine(10.Power(4));

        //문자열 기능 추가
        Console.WriteLine("dd".TwoPower(3));
    }
}
