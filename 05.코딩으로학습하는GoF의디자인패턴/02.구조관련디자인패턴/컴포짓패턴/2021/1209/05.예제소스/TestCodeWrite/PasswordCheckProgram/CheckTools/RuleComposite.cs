using System;
using System.Collections.Generic;
using System.Text;

namespace PasswordCheckProgram.CheckTools;
public class RuleComposite
{
    private List<IRule> _rule = new List<IRule>();
    public void Add(IRule rule)
    {
        _rule.Add(rule);
    }

    public Result Check(string password)
    {
        StringBuilder builder = new StringBuilder();
        foreach (IRule rule in _rule)
        {
            Result result = rule.Check(password);
            if (!result.IsSuccess)
            {
                builder.Append(result.Message);
            }
        }
        return CreateResult(builder.ToString());
    }

    private Result CreateResult(string message)
    {
        if (string.IsNullOrEmpty(message))
        {
            return Result.Success();
        }
        else return Result.Failure(message.ToString());
    }
}
