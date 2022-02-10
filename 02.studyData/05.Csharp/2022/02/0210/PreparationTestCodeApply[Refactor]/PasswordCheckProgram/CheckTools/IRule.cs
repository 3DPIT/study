using System.Data;

namespace PasswordCheckProgram.CheckTools;
public interface IRule
{
     public Result Check(string password);
}
