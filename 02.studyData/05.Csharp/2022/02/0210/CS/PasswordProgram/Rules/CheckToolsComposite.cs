using System.Text;

namespace PasswordProgram.Rules;

public class CheckToolsComposite
{
    private List<IRule> _rules = new List<IRule>();

    public Result Check(string password)
    {
        StringBuilder sb = new StringBuilder();
        Result result;
        foreach (var _rule in _rules)
        {
            _rule.Check(password);
        }
        return FinalResult(sb.ToString());
    }
    public void Add(IRule rule)
    {
        _rules.Add(rule);
    }

    private Result FinalResult(string message){
        if(string.IsNullOrEmpty(message))
        {
            return Result.Success();
        }
        return Result.Failure(message);
    }
}