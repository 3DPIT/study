using System;
using PasswordCheckProgram.CheckTools;

namespace PasswordCheckProgram
{

    class Program
    {
        static void Main(string[] args)
        {
            var Errors = new string[] {"대소문자를 한개이상은 포함해야 합니다.",
                            "한글을포함하면 안됩니다.",
                            "공백을 포함할 수 없습니다.",
                            "특수문자를한개이상 포함해야합니다.",
                            "8개이상입력하셔야합니다."};

            Console.WriteLine("비밀번호 규칙");
            Console.WriteLine("1. 한글은 입력 안됨");
            Console.WriteLine("2. 8자리이상 입력 ");
            Console.WriteLine("3. 공백은 비번으로 포함할 수 없음");
            Console.WriteLine("4. 특수문자 한개 이상 포함");
            Console.WriteLine("5. 영문 소문자, 대문자 1개이상은 포함");
            Console.Write("비밀 번호를 입력하세요 : ");
            Console.WriteLine();

            CheckToolsComposite CheckToolsComposite = new CheckToolsComposite();
            CheckToolsComposite.Add(new IsAlphabet());
            CheckToolsComposite.Add(new IsHangle());
            CheckToolsComposite.Add(new IsSpace());
            CheckToolsComposite.Add(new IsSpecialWord());
            CheckToolsComposite.Add(new IsNumberCount());

            string password = Console.ReadLine();
            while (true)
            {
                var resultNumber = CheckToolsComposite.Check(password);
                if (resultNumber == 0) break;
                Console.Write("비밀 번호를 입력하세요 : ");
                password = Console.ReadLine();
            }
            
            Console.WriteLine("비밀번호 설정 완료");
        }
    }
}