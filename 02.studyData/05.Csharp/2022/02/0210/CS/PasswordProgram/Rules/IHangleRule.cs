using System.Text.RegularExpressions;

namespace PasswordProgram.Rules;
public class IsHangleRule : IRule
{

    public Result Check(string password)
    {
        Regex regex = new Regex(@"[ㄱ-ㅎㅏ-ㅣ가-힣]");

        if (regex.IsMatch(password))
        {
            return Result.Failure("한글을 포함 할 수 없음");
        }
        return Result.Success();
    }
}
