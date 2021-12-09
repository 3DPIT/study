using System;

namespace AdvancedSmartEnum
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("봄   일출 시간 :" + Weather.FromName("Spring").SunriseTime);
            Console.WriteLine("봄   일몰 시간 :" + Weather.FromName("Spring").SunsetTime);
            Console.WriteLine("여름 일출 시간 :" + Weather.FromName("Summer").SunriseTime);
            Console.WriteLine("여름 일몰 시간 :" + Weather.FromName("Summer").SunsetTime);
            Console.WriteLine("가을 일출 시간 :" + Weather.FromName("Autumn").SunriseTime);
            Console.WriteLine("가을 일몰 시간 :" + Weather.FromName("Autumn").SunsetTime);
            Console.WriteLine("겨울 일출 시간 :" + Weather.FromName("Winter").SunriseTime);
            Console.WriteLine("겨울 일몰 시간 :" + Weather.FromName("Winter").SunsetTime);

            Console.WriteLine("봄   일출 시간 :" + Weather.Spring.SunriseTime);
            Console.WriteLine("봄   일몰 시간 :" + Weather.Spring.SunsetTime);
            Console.WriteLine("여름 일출 시간 :" + Weather.Summer.SunriseTime);
            Console.WriteLine("여름 일몰 시간 :" + Weather.Summer.SunsetTime);
            Console.WriteLine("가을 일출 시간 :" + Weather.Autumn.SunriseTime);
            Console.WriteLine("가을 일몰 시간 :" + Weather.Autumn.SunsetTime);
            Console.WriteLine("겨울 일출 시간 :" + Weather.Winter.SunriseTime);
            Console.WriteLine("겨울 일몰 시간 :" + Weather.Winter.SunsetTime);
        }
    }
}
