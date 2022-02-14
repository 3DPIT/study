namespace PasswordProgram.Rules;
public class IsNumberCountRule :IRule
{
    public  Result Check(string password)
    {
        //8자리 이상
        if (password.Length < 8)
        {
            //Console.WriteLine("8자리 이상 입력해주세요.");
            return Result.Failure("8자리 이상 입력해주세요.");
        }

        return Result.Success();
    }
}