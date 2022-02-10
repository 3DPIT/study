using System;
using System.Text;
using System.Text.RegularExpressions;

namespace PasswordCheckProgram.CheckTools;
public class IsAlphabetRule : IRule
{
    public Result Check(string password)
    {
        Result lowerResult = IsLower(password);
        Result upperResult = IsUpper(password);

        return CreateResult(lowerResult, upperResult);
    }

    private Result CreateResult(Result lowerResult, Result upperResult)
    {
        if (lowerResult.IsSuccess && upperResult.IsSuccess)
        {
            return Result.Success();
        }
        else
        {
            StringBuilder builder = new StringBuilder();
            if (!lowerResult.IsSuccess)
            {
                builder.Append(lowerResult.Message);
            }
            if (!upperResult.IsSuccess)
            {
                builder.Append(upperResult.Message);
            }

            return Result.Failure(builder.ToString());
        }
    }
    private Result IsLower(string password)
    {
        Regex regex = new Regex(@"[a-z]");

        if (!regex.IsMatch(password))
        {
            //Console.WriteLine("영문 소문자 한개이상 포함해주세요.");
            return Result.Failure("영문 소문자 한개이상 포함해주세요.");
        }

        return Result.Success();
    }

    private Result IsUpper(string password)
    {
        Regex regex = new Regex(@"[A-Z]");

        if (!regex.IsMatch(password))
        {
            //Console.WriteLine("영문 대문자 한개이상 포함해주세요.");
            return Result.Failure("영문 대문자 한개이상 포함해주세요.");
        }

        return Result.Success();
    }
}
