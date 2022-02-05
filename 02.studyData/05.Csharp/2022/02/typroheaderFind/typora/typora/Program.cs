using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace typora
{
    class Program
    {
        static void Main(string[] args)
        {
            string local = Environment.GetFolderPath(Environment.SpecialFolder.Desktop); ;
            string path = local + @"\typora\test.md";
            string textValue = System.IO.File.ReadAllText(path);
            Console.WriteLine(textValue);
            List<string> l = new List<string>();

            StringBuilder s = new StringBuilder();
            int flag = 0;
            foreach (var word in textValue)
            {
                if (word == '#')
                {

                    flag = 1;
                    continue;
                }

                if (flag == 1 && word != '\r' && word != '\n')
                {
                    s.Append(word);
                }

                if (flag == 1 && word == '\r')
                {
                    s.Append('\n');
                    flag = 0;

                }
            }
            Console.WriteLine(l);
            string spath = local + @"\typora\text.md";
            System.IO.File.WriteAllText(spath, s.ToString(), Encoding.Default);
        }
    }
}
