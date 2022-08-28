using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace main4;
class MyClass
{
    public int a, b, c;

    public MyClass()
    {
        this.a = 5425;
    }

    public MyClass(int b)
    {
        this.a = 5425;
        this.b = b;
    }
    public MyClass(int b, int c)
    {
        this.a = 5425;
        this.b = b;
        this.c = c;
    }

}

class MyClass1
{
    int a, b, c;

    public MyClass1()
    {
        this.a = 5425;
    }

    public MyClass1(int b): this()
    {
        this.b = b;
    }
    public MyClass1(int b, int c) : this()
    {
        this.c = c;
    }

}
