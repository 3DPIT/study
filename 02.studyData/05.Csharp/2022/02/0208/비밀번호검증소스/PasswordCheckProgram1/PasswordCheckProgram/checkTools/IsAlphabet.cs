using System;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.checkTools
{
    public class IsAlphabet : Rule
    {
        public override bool Check( string password)
        {
            int flag = 0;
            Regex regex = new Regex(@"[a-z]");

            if (!regex.IsMatch(password))
            {
                Console.WriteLine("영문 소문자 한개이상 포함해주세요.");
                flag++;
            }

            //영문 대문자 체크
            regex = new Regex(@"[A-Z]");

            if (!regex.IsMatch(password))
            {
                Console.WriteLine("영문 대문자 한개이상 포함해주세요.");
                flag++;
            }

            if (flag == 2) return true;
            else return false;
        }
    }
}