using System;

namespace PasswordCheckProgram.checkTools
{
    public class IsNull : Rule
    {
        public override bool Check(string password)
        {
            foreach (var word in password)
            {
                if (word == ' ')
                {
                    Console.WriteLine("공백을 허용하지 않습니다.");
                    return true;
                }
            }
            return false;
        }
    }
}