using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace main5
{
    class Base
    {
        protected string Name;
        public Base(string Name)
        {
            this.Name = Name;
        }
    }

    class Derived : Base
    { 
        public Derived (string Name) : base(Name)
        {
            Console.WriteLine("{this.Name}.Derived()");
        }
    }

}
