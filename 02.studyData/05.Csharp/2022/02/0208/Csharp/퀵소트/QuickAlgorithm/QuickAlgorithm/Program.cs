using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuickAlgorithm
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[] { 1, 0, 2, 4, 3 };
            for (int i = 0; i < arr.Length; i++)
             Console.Write (arr[i]+ " ");
            Console.WriteLine();
            quickSort(arr, 0, arr.Length - 1);

            for (int i = 0; i < arr.Length; i++)
                Console.Write(arr[i]+" ");


        }

        public static int pivoting (int []arr, int left, int right)
        {
            int l = left+1;
            int r = right;
            int pivote = left;
            while (l<=r)
            {
                while (l <= r && arr[l] < arr[pivote]) l++;
                while (l <= r && arr[pivote] < arr[r]) r--;

                if (l <= r)
                {
                    int temp1 = arr[l];
                    arr[l] = arr[r];
                    arr[r] = temp1;
                }
            }
            int temp = arr[r];
            arr[r] = arr[pivote];
            arr[pivote] = temp;
            return pivote;
        }

       public static void quickSort(int[] arr, int left, int right)
        {
            if(left<=right)
            {
                var pivote = pivoting(arr, left, right);
                quickSort(arr, left, pivote - 1);
                quickSort(arr, pivote + 1, right);
            }
        }

    }
}
