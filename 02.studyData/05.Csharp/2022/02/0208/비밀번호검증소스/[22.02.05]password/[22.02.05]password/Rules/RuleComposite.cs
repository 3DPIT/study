using System.Collections.Generic;

namespace _22._02._05_password.Rules
{
    public class RuleComposite
    {
        private List<Rule> _rules = new List<Rule>();

        public void Add(Rule rule)
        {
            _rules.Add(rule);
        }

        public bool Check(string password)
        {
            foreach (Rule rule in _rules)
            {
                if(!rule.Check(password))
                {
                    return false;
                }
            }
            return true;
        }
    }
}
