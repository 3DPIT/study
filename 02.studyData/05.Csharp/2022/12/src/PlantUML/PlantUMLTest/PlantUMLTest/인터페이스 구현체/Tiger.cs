using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using PlantUMLTest.인터페이스;

namespace PlantUMLTest
{
    public class Tiger : Animal
    {
        private readonly int life;
        private readonly string health;
        public string Name;
        public void eat()
        {
            Console.WriteLine("호랑이 답게 냠냠");
        }

        public void walk()
        {
            Console.WriteLine("호랑이 답게 당당하게 걷기");
        }
    }
}
