using System.Data;

namespace PasswordCheckProgram.checkTools
{
    public class Rule
    {
        public virtual bool Check(string password)
        {
            return true;
        }
    }
}