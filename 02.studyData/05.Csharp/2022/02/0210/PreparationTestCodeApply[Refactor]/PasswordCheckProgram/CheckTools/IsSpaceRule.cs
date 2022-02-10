using System;

namespace PasswordCheckProgram.CheckTools;
public class IsSpaceRule : IRule
{
    public  Result Check(string password)
    {
        foreach (var word in password)
        {
            if (word == ' ')
            {
                //Console.WriteLine("공백을 허용하지 않습니다.");
                return Result.Failure("공백을 허용하지 않습니다");
            }
        }

        return Result.Success();
    }
}
