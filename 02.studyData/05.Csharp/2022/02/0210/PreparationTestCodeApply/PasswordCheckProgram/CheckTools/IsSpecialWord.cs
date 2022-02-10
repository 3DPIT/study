using System;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.CheckTools;
public class IsSpecialWord : Rule
{
    public override int Check(string password)
    {
        Regex regex = new Regex(@"[`~!@#$%^&*()_+=<>?]");

        if (!regex.IsMatch(password))
        {
            //Console.WriteLine("특수문자를 한글자 이상 포함해주세요.");
            return 1;
        }
        return 0;
    }
}
