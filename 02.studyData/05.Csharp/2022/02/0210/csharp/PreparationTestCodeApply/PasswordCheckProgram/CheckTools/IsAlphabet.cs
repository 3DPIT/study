using System;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.CheckTools;
public class IsAlphabet : Rule
{
    public override int Check(string password)
    {
        int flag = 0;
        if (IsLower(password)==1)
        {
            flag++;
        }
        if (IsUpper(password)==1)
        {
            flag++;
        }
        return flag;
    }

    private int IsLower(string password)
    {
        Regex regex = new Regex(@"[a-z]");

        if (!regex.IsMatch(password))
        {
            //Console.WriteLine("영문 소문자 한개이상 포함해주세요.");
            return 1;
        }
        return 0;
    }

    private int IsUpper(string password)
    {
        Regex regex = new Regex(@"[A-Z]");

        if (!regex.IsMatch(password))
        {
            //Console.WriteLine("영문 대문자 한개이상 포함해주세요.");
            return 1;
        }
        return 0;
    }
}
