namespace PasswordProgram.Rules;

public interface IRule
{
     public Result Check(string password);
}
