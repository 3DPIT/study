using Xunit;

namespace SortAlgorithm1.UnitTest
{
    public class UnitTest1
    {
        [Fact]
        public void MergeSortTest()
        {
            int[] arr = { 5, 12, 3, 4, 8, 3, 1, 9, 5 };
            Merge merge = new Merge();
            merge.Sort(arr);
        }
    }
}
