using System;
using System.Diagnostics.CodeAnalysis;

namespace Constructor.Init
{
    [ExcludeFromCodeCoverage]
    public class Initialize
    {

        public int[] Numbers()
        {
            Console.WriteLine($"입력할 숫자를 스페이스 간격을 두고 입력하세요.");
            string[] words = Console.ReadLine().Split(' ');
            int[] numbers = new int[words.Length];
            for (int i = 0; i <words.Length; i++)
            {
                numbers[i] = Int32.Parse(words[i]);
            }
            return numbers;
        }
    }
}