using System;
using System.Collections.Generic;

namespace PasswordCheckProgram.checkTools
{
    public class CheckToolsComposite
    {
        private List<Rule> _rule = new List<Rule>();
        public void Add(Rule rule)
        {
            _rule.Add(rule);
        }

        public  bool Check(string password)
        {
            foreach (Rule rule in _rule)
            {
                if (rule.Check(password))
                {
                    return false;
                }
            }
            return true;
        }
    }
}