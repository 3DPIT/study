//using System.Diagnostics.CodeAnalysis;

using System.Diagnostics.CodeAnalysis;

namespace ClassLibrary1;

public class Class1
{
    public Class1()
    {

    }

    public int Method0()
    {
        return 2022;
    }

    public int Method1()
    {
        return 2;
    }

    [ExcludeFromCodeCoverage]
    public int Method2()
    {
        return 3;
    }

    public int Method3()
    {
        return 4;
    }

    // public int Method4()
    // {
    //     return 5;
    // }
}
