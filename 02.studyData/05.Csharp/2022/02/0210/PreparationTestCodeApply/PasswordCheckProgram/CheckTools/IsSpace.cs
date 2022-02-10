using System;

namespace PasswordCheckProgram.CheckTools;
public class IsSpace : Rule
{
    public override int Check(string password)
    {
        foreach (var word in password)
        {
            if (word == ' ')
            {
                //Console.WriteLine("공백을 허용하지 않습니다.");
                return 1;
            }
        }
        return 0;
    }
}
