using System;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.CheckTools;
public class IsSpecialWordRule : IRule
{
    public  Result Check(string password)
    {
        Regex regex = new Regex(@"[`~!@#$%^&*()_+=<>?]");

        if (!regex.IsMatch(password))
        {
            //Console.WriteLine("특수문자를 한글자 이상 포함해주세요.");
            return Result.Failure("특수문자를 한글자 이상 포함해주세요.");
        }

        return Result.Success();
    }
}
