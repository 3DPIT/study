using Xunit;
using SortAlgorithm;
namespace SortAlgorithm.UnitTest
{
    public class Class1
    {

        [Fact]
        public class MergeSortTest
        {
            int[] arr = { 5, 12, 3, 4, 8, 3, 1, 9, 5 };
            Merge merge = new Merge();
            merge.Sort(arr);
        }
    }
}
