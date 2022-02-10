using System;

namespace SortAlgorithm
{

    class PrintNumber
    {
        public void Run(int[] arr)
        {
            for (int i = 0; i < arr.Length; i++)
                Console.Write(arr[i] + " ");
            Console.WriteLine();
        }
    }
}