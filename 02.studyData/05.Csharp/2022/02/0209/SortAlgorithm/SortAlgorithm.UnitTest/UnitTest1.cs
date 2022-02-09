using System;
using Xunit;
namespace SortAlgorithm.UnitTest;

public class UnitTest1
{
    [Fact]
    public void TestMethod1()
    {
        int[] arr = { 4,3,2,1 };
        Merge merge = new Merge();
        merge.Sort(arr);
        expectArr =  new int[] {1,2,3,4};
        Assert.Equal(expectArr,arr);
    }
}

