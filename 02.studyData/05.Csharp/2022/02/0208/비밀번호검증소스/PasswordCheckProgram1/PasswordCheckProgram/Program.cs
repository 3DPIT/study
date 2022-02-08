using System;
using PasswordCheckProgram.checkTools;

namespace PasswordCheckProgram
{
    class Program
    {
        static void Main(string[] args)
        {

            Console.WriteLine("비밀번호 규칙");
            Console.WriteLine("1. 한글은 입력 안됨");
            Console.WriteLine("2. 8자리이상 입력 ");
            Console.WriteLine("3. 공백은 비번으로 포함할 수 없음");
            Console.WriteLine("4. 특수문자 한개 이상 포함");
            Console.WriteLine("5. 영문 소문자, 대문자 1개이상은 포함");
            Console.Write("비밀 번호를 입력하세요 : ");
            Console.WriteLine();

            //PasswordCondition passwordCondition = new PasswordCondition(password);
            //passwordCondition.Check();


            CheckToolsComposite checkToolsComposite = new CheckToolsComposite();
            checkToolsComposite.Add(new IsAlphabet());
            checkToolsComposite.Add(new IsHangle());
            checkToolsComposite.Add(new IsNull());
            checkToolsComposite.Add(new IsSpecialWord());
            checkToolsComposite.Add(new IsNumberCount());

            string password = Console.ReadLine();
            while (!checkToolsComposite.Check(password))
            {
                Console.Write("비밀 번호를 입력하세요 : ");
                password = Console.ReadLine();
            }
            Console.WriteLine("비밀번호 설정 완료");
        }
    }
}