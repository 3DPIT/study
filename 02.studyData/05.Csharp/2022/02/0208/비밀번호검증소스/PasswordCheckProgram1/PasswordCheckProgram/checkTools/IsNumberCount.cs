using System;

namespace PasswordCheckProgram.checkTools
{
    public class IsNumberCount :Rule
    {
        public override bool Check(string password)
        {
            //8자리 이상
            if (password.Length < 8)
            {
                Console.WriteLine("8자리 이상 입력해주세요.");
                return true;
            }

            return false;
        }
    }
}