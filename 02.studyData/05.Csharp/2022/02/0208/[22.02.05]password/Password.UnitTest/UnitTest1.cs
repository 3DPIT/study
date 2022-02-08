using System;
using _22._02._05_password.Rules;
using Xunit;

namespace Password.UnitTest
{
    public class UnitTest1
    {
        [Fact]
        public void goodPassword()
        {
            RuleComposite ruleComposite = new RuleComposite();
            ruleComposite.Add(new StringCheck());
            ruleComposite.Add(new StringCheck());
            ruleComposite.Add(new StarCheck());
            ruleComposite.Add(new UpperCheck());
            ruleComposite.Add(new LowerCheck());
            ruleComposite.Add(new CountCheck());
            ruleComposite.Add(new NullCheck());

            var inputPassword = "12345678!aA";
            var actualResult = ruleComposite.Check(inputPassword);
            Assert.Equal(true, actualResult);

        }

        [Fact]
        public void badPassword()
        {
            RuleComposite ruleComposite = new RuleComposite();
            ruleComposite.Add(new StringCheck());
            ruleComposite.Add(new StringCheck());
            ruleComposite.Add(new StarCheck());
            ruleComposite.Add(new UpperCheck());
            ruleComposite.Add(new LowerCheck());
            ruleComposite.Add(new CountCheck());
            ruleComposite.Add(new NullCheck());

            var inputPassword = "123aA";
            var actualResult = ruleComposite.Check(inputPassword);
            Assert.Equal(false, actualResult);
        }
    }
}
