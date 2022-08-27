using CS_Study_220927;

namespace main;
class Program
{ 
    class MyClass
    {
        public int a;
        public int b;
    }

    class MyClass2
    {
        public static int a;
        public static int b;   
    }

    public static void Main(string[] args)
    {
        Cat kitty = new Cat();
        kitty.Color = "하얀색";
        kitty.Name = "키티";
        kitty.Meow();
        Console.WriteLine("{0} : {1}", kitty.Name, kitty.Color);

        Cat nero = new Cat();
        nero.Color = "검은색";
        nero.Name = "네로";
        nero.Meow();
        Console.WriteLine("{0} : {1}", kitty.Name, kitty.Color);

        MyClass obj1 = new MyClass();
        obj1.a = 1; 
        obj1.b = 2;

        MyClass2.a = 1;
        MyClass2.b = 2;

        MyClass source = new MyClass();
        source.a = 10; 
        source.b = 20;

        MyClass target = source;
        source.b = 30;

        Console.WriteLine("{0} {1}", source.a, source.b);
        Console.WriteLine("{0} {1}", target.a, target.b);
    }
}
