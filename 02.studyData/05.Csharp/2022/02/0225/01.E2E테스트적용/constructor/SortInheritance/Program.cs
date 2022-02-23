using System;
using Constructor.SortAlgorithm;
using Constructor.Init;
using System.Diagnostics.CodeAnalysis;
using System.IO;

namespace Constructor
{
    [ExcludeFromCodeCoverage]
    class Program
    {
        static void Main(string[] args)
        {
            Initialize init = new Init.Initialize();
            int[] number = init.Numbers();
            Sorts(number);

        }

        private static void Sorts(int[] number)
        {

            int[] _number = new int[number.Length];
            Array.Copy(number, 0, _number, 0, number.Length);

            //오름차순
            Func<int, int, int> compareAsc = (a, b) =>
            {
                if (a > b) return 1;
                return 0;
            };

            //내림차순
            Func<int, int, int> compareDesc = (a, b) =>
            {
                if (a < b) return 1;
                return 0;
            };

            BeforePrint("정렬", _number);
            BubbleSort<int> bubble = new BubbleSort<int>(compareAsc);
            bubble.Run(_number);
            AfterPrint("오름차순 버블정렬", _number);
            bubble = new BubbleSort<int>(compareDesc);
            bubble.Run(_number);
            AfterPrint("내림차순 버블정렬", _number);


            Array.Copy(number, 0, _number, 0, number.Length);
           // BeforePrint("삽입정렬", _number);
            InsertSort<int> insert = new InsertSort<int>(compareAsc);
            insert.Run(_number);
            AfterPrint("오름차순 삽입정렬", _number);
            insert = new InsertSort<int>(compareDesc);
            insert.Run(_number);
            AfterPrint("내림차순 삽입정렬", _number);

            Array.Copy(number, 0, _number, 0, number.Length);
           // BeforePrint("선택정렬", _number);
            SelectSort<int> selectSort = new SelectSort<int>(compareAsc);
            selectSort.Run(_number);
            AfterPrint("오름차순 선택정렬", _number);
            selectSort = new SelectSort<int>(compareDesc);
            selectSort.Run(_number);
            AfterPrint("내림차순 선택정렬", _number);
        }

        private static void BeforePrint(string sortName,int[] number)
        {
            Console.Write($"{sortName} 전 : ");
            for (int i = 0; i < number.Length; i++)
            {
                Console.Write(number[i] + " ");
            }
            Console.WriteLine();
        }

        private static void AfterPrint(string sortName, int[] number)
        {
            Console.Write($"{sortName} 후 : ");
            for (int i = 0; i < number.Length; i++)
            {
                Console.Write(number[i] + " ");
            }
            Console.WriteLine();
            Console.WriteLine();
        }
    }
}
