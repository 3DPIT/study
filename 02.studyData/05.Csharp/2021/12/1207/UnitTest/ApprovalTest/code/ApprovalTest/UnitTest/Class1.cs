using ApprovalTests;
using ApprovalTests.Reporters;
using System;
using Xunit;

namespace UnitTest
{
    [UseReporter(typeof(WinMergeReporter))]
    public class MargedRaw
    {
        [Fact]
        public void Verify()
        {
            var names = new[] { "Llewellyn", "James", "Dan", "Jason", "Katrina" };
            Array.Sort(names);
            Approvals.VerifyAll(names, label: "");
        }
    }
}
