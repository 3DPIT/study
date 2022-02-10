using System;

namespace MergeSort;
class Program
{
    static void Main(string[] args)
    {
        int[] arr = { 5, 12, 3, 4, 8, 3, 1, 9, 5 };
        PrintNumber print = new PrintNumber();
        Merge merge = new Merge();
        print.Run(arr);
        merge.Sort(arr);
        print.Run(arr);
    }
}

