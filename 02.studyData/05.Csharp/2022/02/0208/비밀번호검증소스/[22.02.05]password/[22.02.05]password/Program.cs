using System;
using _22._02._05_password.Rules;

namespace _22._02._05_password
{
    class Program
    {
        public static void Main(string[] args)
        {
            string x = Console.ReadLine();
            string result = $"Hi {x}";
            Console.WriteLine($"${result}");


            Console.WriteLine("|=========[비밀번호 설정]===========|");
            Console.WriteLine("|조건 0 :   한글 입력 불가          |");
            Console.WriteLine("|조건 1 :   8자리 이상              |");
            Console.WriteLine("|조건 2 :   공백 사용 불가          |");
            Console.WriteLine("|조건 3 :   특수 문자 포함          |");
            Console.WriteLine("|조건 4 :   영문(대/소문자) 포함    |");
            Console.WriteLine();

            RuleComposite ruleComposite = new RuleComposite();
            ruleComposite.Add(new StringCheck());
            ruleComposite.Add(new StarCheck());
            ruleComposite.Add(new UpperCheck());
            ruleComposite.Add(new LowerCheck());
            ruleComposite.Add(new CountCheck());
            ruleComposite.Add(new NullCheck());

            while (true)
            {
                Console.Write("비밀번호를 설정하세요 : ");
                string password = Console.ReadLine();
                if (ruleComposite.Check(password))
                {
                    Console.WriteLine("비밀번호 설정 완료");
                    break;
                }
            }
        }
    }
}