using System;
using System.Collections.Generic;

namespace PasswordCheckProgram.CheckTools;
public class CheckToolsComposite
{
    private List<Rule> _rule = new List<Rule>();
    public void Add(Rule rule)
    {
        _rule.Add(rule);
    }

    public int Check(string password)
    {
        var count = 0;
        var bitCheck = 1;
        foreach (Rule rule in _rule)
        {
            if (rule.Check(password)==1) {
                count+=bitCheck;
            }
            bitCheck= bitCheck<<1;
        }
        return count;
    }
}
