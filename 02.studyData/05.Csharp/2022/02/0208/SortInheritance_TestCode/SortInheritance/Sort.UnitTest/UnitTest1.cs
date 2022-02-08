using System;
using SortInheritance.Algorithm;
using Xunit;

namespace SortAlgorithm.UnitTest
{
    public class UnitTest1
    {

        [Fact]
        public void BubbleSortAscTest()
        {
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] {0, 1, 5, 6, 7, 8};
            Sort sort = new BubleSort(number, 0);

            var result = sort.Run();

            Assert.Equal(expectResult, result);
        }

        [Fact]
        public void BubbleSortDescTest()
        {
            int[] number = new[] {1, 5, 6, 8, 7, 0};
            Sort sort = new BubleSort(number, 1);
            var expectResult = new[] { 8, 7, 6, 5, 1, 0 };

            var result = sort.Run();
            
            Assert.Equal(expectResult,result);
        }


        [Fact]
        public void InsertSortAscTest()
        {
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] { 0, 1, 5, 6, 7, 8 };
            Sort sort = new InsertSort(number, 0);

            var result = sort.Run();

            Assert.Equal(expectResult, result);
        }

        [Fact]
        public void InsertSortDescTest()
        {
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            Sort sort = new InsertSort(number, 1);
            var expectResult = new[] { 8, 7, 6, 5, 1, 0 };

            var result = sort.Run();

            Assert.Equal(expectResult, result);
        }

        [Fact]
        public void SelectSortAscTest()
        {
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] { 0, 1, 5, 6, 7, 8 };
            Sort sort = new SelectSort(number, 0);

            var result = sort.Run();

            Assert.Equal(expectResult, result);
        }
        [Fact]
        public void SelectSortDescTest()
        {
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            Sort sort = new SelectSort(number, 1);
            var expectResult = new[] { 8, 7, 6, 5, 1, 0 };

            var result = sort.Run();

            Assert.Equal(expectResult, result);
        }
    }
}
