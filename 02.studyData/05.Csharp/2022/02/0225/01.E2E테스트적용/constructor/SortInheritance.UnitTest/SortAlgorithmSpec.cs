using Xunit;
using Xunit.Abstractions;
using System;
using System.Diagnostics;
using Constructor.SortAlgorithm;
using FluentAssertions;
using System.IO;
using System.Collections.Generic;

namespace Constructor.UnitTest
{
    public class SortAlgorithmSpec
    {
        private readonly ITestOutputHelper _output;
        public SortAlgorithmSpec(ITestOutputHelper output)
        {
            _output = output;
        }

        [Fact]
        public void Test1()
        {
            //Arrange
            using (Process process = new Process())
            {
                string path = Path.GetFileName(Environment.CurrentDirectory);
                Console.WriteLine(path);
                process.StartInfo.FileName = $"../{path}\\Constructor.exe";
                process.StartInfo.RedirectStandardInput = true;
                process.StartInfo.RedirectStandardOutput = true;

                //Act
                process.Start();

                string input = "1 4 5 3 2 0";
                process.StandardInput.WriteLine(input);

                List<string> result = new List<string> { 
                                                         "입력할 숫자를 스페이스 간격을 두고 입력하세요.",
                                                         "정렬 전 : 1 4 5 3 2 0 ",
                                                         "오름차순 버블정렬 후 : 0 1 2 3 4 5 ",
                                                         "",
                                                         "내림차순 버블정렬 후 : 5 4 3 2 1 0 ",
                                                         "",
                                                         "오름차순 삽입정렬 후 : 0 1 2 3 4 5 ",
                                                         "",
                                                         "내림차순 삽입정렬 후 : 5 4 3 2 1 0 ",
                                                         "",
                                                         "오름차순 선택정렬 후 : 0 1 2 3 4 5 ",
                                                         "",
                                                         "내림차순 선택정렬 후 : 5 4 3 2 1 0 ",
                                                         ""
                                                        };
                string output;
                int idx = 0;
                while ((output = process.StandardOutput.ReadLine()) != null)
                {
                    //Assert
                    //Console.WriteLine($"Test - {output}");
                    //_output.WriteLine($"Test - {output}");
                    ////_output.Should().Be("Hi");

                    output.Should().Be(result[idx]);
                    idx++;
                }
                process.WaitForExit();
            }
        }
        //오름차순
        Func<int, int, int> compareAscInteger = (a, b) =>
        {
            if (a > b) return 1;
            return 0;
        };
        Func<double, double, int> compareAscDouble = (a, b) =>
        {
            if (a > b) return 1;
            return 0;
        };

        //내림차순
        Func<int, int, int> compareDescInteger = (a, b) =>
        {
            if (a < b) return 1;
            return 0;
        };
        Func<double, double, int> compareDescDouble = (a, b) =>
        {
            if (a < b) return 1;
            return 0;
        };

        [Fact]
        public void IntAscBubbleSortTest()
        {
            //Arrange
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] { 0, 1, 5, 6, 7, 8 };

            ISort<int> sut = new BubbleSort<int>(compareAscInteger);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void IntDescBubbleSortTest()
        {
            //Arrange
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] { 0, 1, 5, 6, 7, 8 };
            ISort<int> sut = new BubbleSort<int>(compareDescInteger);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void IntAscInsertSortTest()
        {
            //Arrange
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] { 0, 1, 5, 6, 7, 8 };

            ISort<int> sut = new InsertSort<int>(compareAscInteger);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void IntDescInsertSortTest()
        {
            //Arrange
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] { 0, 1, 5, 6, 7, 8 };
            ISort<int> sut = new InsertSort<int>(compareDescInteger);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void IntAscSelectSortTest()
        {
            //Arrange
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] { 0, 1, 5, 6, 7, 8 };

            ISort<int> sut = new SelectSort<int>(compareAscInteger);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void IntDescSelectSortTest()
        {
            //Arrange
            int[] number = new[] { 1, 5, 6, 8, 7, 0 };
            var expectResult = new[] { 0, 1, 5, 6, 7, 8 };
            ISort<int> sut = new SelectSort<int>(compareDescInteger);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        // 실수형
        [Fact]
        public void DoubleAscBubbleSortTest()
        {
            //Arrange
            double[] number = new[] { 1, 5.0, 6.1, 8.1, 7, 0 };
            var expectResult = new[] { 0, 1, 5.0, 6.1, 7, 8.1 };

            ISort<double> sut = new BubbleSort<double>(compareAscDouble);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void DoubleDescBubbleSortTest()
        {
            //Arrange
            double[] number = new[] { 1, 5.0, 6.1, 8.1, 7, 0 };
            var expectResult = new[] { 0, 1, 5.0, 6.1, 7, 8.1 };

            ISort<double> sut = new BubbleSort<double>(compareDescDouble);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }


        [Fact]
        public void DoubleAscInsertSortTest()
        {
            //Arrange
            double[] number = new[] { 1, 5.0, 6.1, 8.1, 7, 0 };
            var expectResult = new[] { 0, 1, 5.0, 6.1, 7, 8.1 };

            ISort<double> sut = new InsertSort<double>(compareAscDouble);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void DoubleDescInsertSortTest()
        {
            //Arrange
            double[] number = new[] { 1, 5.0, 6.1, 8.1, 7, 0 };
            var expectResult = new[] { 0, 1, 5.0, 6.1, 7, 8.1 };

            ISort<double> sut = new InsertSort<double>(compareDescDouble);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void DoubleAscSelectSortTest()
        {
            //Arrange
            double[] number = new[] { 1, 5.0, 6.1, 8.1, 7, 0 };
            var expectResult = new[] { 0, 1, 5.0, 6.1, 7, 8.1 };

            ISort<double> sut = new SelectSort<double>(compareAscDouble);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }

        [Fact]
        public void DoubleDescSelectSortTest()
        {
            //Arrange
            double[] number = new[] { 1, 5.0, 6.1, 8.1, 7, 0 };
            var expectResult = new[] { 0, 1, 5.0, 6.1, 7, 8.1 };

            ISort<double> sut = new SelectSort<double>(compareDescDouble);

            //Act
            var actual = sut.Run(number);

            //Assert
            actual.Should().BeEquivalentTo(expectResult);
        }
    }
}
