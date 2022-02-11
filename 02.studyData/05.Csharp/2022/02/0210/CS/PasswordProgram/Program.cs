// See https://aka.ms/new-console-template for more information
using System;
using  PasswordProgram.Rules;
namespace PasswordProgram;
class Program
{
    public static void Main(String[] args)
    {
        ProgramSetup();
        CheckToolsComposite ruleComposite = CreateRuleComposite();
        PasswordValidatePassword(ruleComposite);
        ProgramFinish();
    }
    private static void PasswordValidatePassword(CheckToolsComposite ruleComposite)
    {
        do
        {
            Console.Write("비밀 번호를 입력하세요 : ");
            Console.WriteLine();
            string password = Console.ReadLine();
            Result result = ruleComposite.Check(password);
            if (result.IsSuccess)
            {
                break;
            }
            else
            {
                Console.WriteLine(result.Message);
            }
            Console.Write("비밀 번호를 입력하세요 : ");
            password = Console.ReadLine();
        }
        while (true);
    }
    private static CheckToolsComposite CreateRuleComposite()
    {
        CheckToolsComposite ruleComposite = new CheckToolsComposite();
        // ruleComposite.Add(new IsAlphabetRule());
        ruleComposite.Add(new IsHangleRule());
        // ruleComposite.Add(new IsSpaceRule());
        // ruleComposite.Add(new IsSpecialWordRule());
         ruleComposite.Add(new IsNumberCountRule());
        return ruleComposite;
    }

    private static void ProgramSetup()
    {
        Console.WriteLine("비밀번호 규칙");
        Console.WriteLine("1. 한글은 입력 안됨");
        Console.WriteLine("2. 8자리이상 입력 ");
        Console.WriteLine("3. 공백은 비번으로 포함할 수 없음");
        Console.WriteLine("4. 특수문자 한개 이상 포함");
        Console.WriteLine("5. 영문 소문자, 대문자 1개이상은 포함");
    }

    private static void ProgramFinish()
    {
        Console.WriteLine("비밀번호 설정 완료");
    }
}


