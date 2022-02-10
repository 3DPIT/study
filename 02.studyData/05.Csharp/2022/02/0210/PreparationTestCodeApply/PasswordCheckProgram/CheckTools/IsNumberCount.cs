using System;

namespace PasswordCheckProgram.CheckTools;
public class IsNumberCount :Rule
{
    public override int Check(string password)
    {
        //8자리 이상
        if (password.Length < 8)
        {
            //Console.WriteLine("8자리 이상 입력해주세요.");
            return 1;
        }

        return 0;
    }
}
