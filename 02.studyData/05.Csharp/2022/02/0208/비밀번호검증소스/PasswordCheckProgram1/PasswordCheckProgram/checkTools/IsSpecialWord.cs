using System;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.checkTools
{
    public class IsSpecialWord : Rule
    {
        public override bool Check(string password)
        {
            Regex regex = new Regex(@"[`~!@#$%^&*()_+=<>?]");

            if (!regex.IsMatch(password))
            {
                Console.WriteLine("특수문자를 한글자 이상 포함해주세요.");
                return true;
            }
            return false;
        }
    }
}