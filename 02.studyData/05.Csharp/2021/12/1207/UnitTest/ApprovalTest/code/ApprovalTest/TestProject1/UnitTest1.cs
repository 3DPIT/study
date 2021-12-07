using System;
using Xunit;

namespace TestProject1
{
    public class UnitTest1
    {
        [Fact]
        public void Test1()
        {
            Foo test = new Foo();
            Assert.Equal(4,test.Add(1, 3));
        }
    }
    public class Foo
    {
        public int Add(int x, int y)
        {
            return x + y;
        }
    }
}
