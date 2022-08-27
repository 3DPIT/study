using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace main8
{
    public class Base
    {
        public virtual void MyMethod() 
        {
            Console.WriteLine("Base.MyMethod()");
        }
    }

    public class Derived : Base
    {
        //public new void MyMethod()
        //{
        //    Console.WriteLine("Derived.MyMethod()");
        //}
        public sealed override void MyMethod()
        {
            Console.WriteLine("Derived.MyMethod()");
        }
    }
}
