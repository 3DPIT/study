using System;

namespace BasicAttribute;

class MyClass
{
    [Obsolete("OldMethod는 폐기되었습니다. NewMethod()를 이용하세요")]
    public void OldMethod()
    {
        Console.WriteLine("OLD");
    }

    public void NewMethod()
    {
        Console.WriteLine("NEW");
    }
}

class MainApp
{
    static void Main(string[] args)
    {
        MyClass myClass = new MyClass();
        myClass.OldMethod();
        myClass.NewMethod();
    }
}