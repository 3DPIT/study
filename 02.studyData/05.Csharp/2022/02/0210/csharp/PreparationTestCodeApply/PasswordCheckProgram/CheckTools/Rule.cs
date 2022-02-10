using System.Data;

namespace PasswordCheckProgram.CheckTools;
public class Rule
{
    public virtual int Check(string password)
    {
        return 1;
    }
}
