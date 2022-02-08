using System;
using SortInheritance.Algorithm;

namespace SortInheritance
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] number = new int[]{ 1, 5, 3, 4, 2, 0 };
            PrintNumber printNumber = new PrintNumber();

            //정렬전 상태
            ////////////////////////////////////////////////////////////////
            Console.WriteLine($"정렬전 배열 상태 :");
            printNumber.WriteLine(number);
            Console.WriteLine();
            ////////////////////////////////////////////////////////////////

            //
            //삽입 정렬 진행
            //
            Sort sort = new InsertSort(number,0);
            var acsResult = sort.Run();
            sort = new InsertSort(number,1);
            var desResult = sort.Run();

            //
            //삽입 정렬 결과
            //
            Console.WriteLine($"삽입 정렬");
            Console.WriteLine($"오름차순 정렬된 결과 : ");
            printNumber.WriteLine(acsResult);
            Console.WriteLine($"내림차순 정렬된 결과 : ");
            printNumber.WriteLine(desResult);
            Console.WriteLine();

            //정렬전 상태
            ////////////////////////////////////////////////////////////////
            Console.WriteLine($"정렬전 배열 상태 :");
            printNumber.WriteLine(number);
            Console.WriteLine();
            ////////////////////////////////////////////////////////////////

            //
            //선택 정렬 진행
            //
            sort = new SelectSort(number, 0);
            acsResult = sort.Run(); 
            sort = new SelectSort(number, 1);
            desResult = sort.Run();

            //
            //선택 정렬 결과
            //
            Console.WriteLine($"선택 정렬");
            Console.WriteLine($"오름차순 정렬된 결과 : ");
            printNumber.WriteLine(acsResult);
            Console.WriteLine($"내림차순 정렬된 결과 : ");
            printNumber.WriteLine(desResult);
            Console.WriteLine();


            //정렬전 상태
            ////////////////////////////////////////////////////////////////
            Console.WriteLine($"정렬전 배열 상태 :");
            printNumber.WriteLine(number);
            Console.WriteLine();
            ////////////////////////////////////////////////////////////////

            //
            //버블 정렬 진행
            //
            sort = new BubleSort(number, 0);
            acsResult = sort.Run();
            sort = new BubleSort(number, 1);
            desResult = sort.Run();

            //
            //버블 정렬 결과
            //
            Console.WriteLine($"버블 정렬");
            Console.WriteLine($"오름차순 정렬된 결과 : ");
            printNumber.WriteLine(acsResult);
            Console.WriteLine($"내림차순 정렬된 결과 : ");
            printNumber.WriteLine(desResult);
            Console.WriteLine();
        }

        public class PrintNumber
        {
            public void WriteLine(int[] number)
            {
                for (int i = 0; i < number.Length; i++)
                {
                    Console.Write($"{number[i]} ");
                }
                Console.WriteLine();
            }
        }
    }
}
