using System;
using SmartEnum1;

namespace SmartEnum1
{
    class Program
    {
        static void Main(string[] args)
        {
            ////
            //// 1, 2 출력
            ////
            //Console.WriteLine(TestEnum.One);
            //Console.WriteLine(TestEnum.One.ToString());
            //Console.WriteLine(TestEnum.One.Name);
            //Console.WriteLine(TestEnum.One.Value+"\n");

            //Console.WriteLine(TestEnum.Two);
            //Console.WriteLine(TestEnum.Two.ToString());
            //Console.WriteLine(TestEnum.Two.Name);
            //Console.WriteLine(TestEnum.Two.Value + "\n");


            //Console.WriteLine(TestEnum.Three);
            //Console.WriteLine(TestEnum.Three.ToString());
            //Console.WriteLine(TestEnum.Three.Name);
            //Console.WriteLine(TestEnum.Three.Value + "\n");

            //Console.WriteLine(TestEnum.One.ToString().Equals(TestEnum.One.Name));
            //Console.WriteLine(TestEnum.One.Equals(TestEnum.One.Value));

            ////
            //// 3
            ////
            //Console.WriteLine(TestEnum.One);
            //Console.WriteLine(TestEnum.One.ToString());
            //Console.WriteLine(TestEnum.One.Name);
            //Console.WriteLine(TestEnum.One.Value + "\n");

            //Console.WriteLine(TestEnum.Two);
            //Console.WriteLine(TestEnum.Two.ToString());
            //Console.WriteLine(TestEnum.Two.Name);
            //Console.WriteLine(TestEnum.Two.Value + "\n");


            //Console.WriteLine(TestEnum.Three);
            //Console.WriteLine(TestEnum.Three.ToString());
            //Console.WriteLine(TestEnum.Three.Name);
            //Console.WriteLine(TestEnum.Three.Value + "\n");

            //Console.WriteLine(TestEnum.AnotherThree);
            //Console.WriteLine(TestEnum.AnotherThree.ToString());
            //Console.WriteLine(TestEnum.AnotherThree.Name);
            //Console.WriteLine(TestEnum.AnotherThree.Value + "\n");

            //Console.WriteLine(TestEnum.Three.Equals(TestEnum.AnotherThree));
            //Console.WriteLine(TestEnum.Three.Value.Equals(TestEnum.AnotherThree.Value));

            ////
            //// behavior
            ////
            //// EmployeeType
            //Console.WriteLine(EmployeeType.Manager);
            //Console.WriteLine(EmployeeType.Manager.ToString());
            //Console.WriteLine(EmployeeType.Manager.Name);
            //Console.WriteLine(EmployeeType.Manager.Value);
            //Console.WriteLine(EmployeeType.Manager.BonusSize+"\n");


            //Console.WriteLine(EmployeeType.Assistant);
            //Console.WriteLine(EmployeeType.Assistant.ToString());
            //Console.WriteLine(EmployeeType.Assistant.Name);
            //Console.WriteLine(EmployeeType.Assistant.Value);
            //Console.WriteLine(EmployeeType.Assistant.BonusSize);

            ////
            //// ReservationStatus
            //// 
            //Console.WriteLine(ReservationStatus.New);
            //Console.WriteLine(ReservationStatus.New.ToString());
            //Console.WriteLine(ReservationStatus.New.Name);
            //Console.WriteLine(ReservationStatus.New.Value);

            //Console.WriteLine(ReservationStatus.New.CanTransitionTo(ReservationStatus.New));
            //Console.WriteLine(ReservationStatus.New.CanTransitionTo(ReservationStatus.Accepted));
            //Console.WriteLine(ReservationStatus.New.CanTransitionTo(ReservationStatus.Paid));
            //Console.WriteLine(ReservationStatus.New.CanTransitionTo(ReservationStatus.Cancelled));

            ////
            //// List
            ////
            //foreach (var option in TestEnum.List)
            //{
            // Console.WriteLine(option);   
            //}
            //Console.WriteLine();

            //foreach (var option in TestEnum.List)
            //{
            //    Console.WriteLine(option.ToString());
            //}
            //Console.WriteLine();

            //foreach (var option in TestEnum.List)
            //{
            //    Console.WriteLine(option.Name);
            //}
            //Console.WriteLine();

            //foreach (var option in TestEnum.List)
            //{
            //    Console.WriteLine(option.Value);
            //}

            //var myEnum = TestEnum.List.Count;
            //Console.WriteLine(myEnum);

            ////
            //// FromName()
            ////
            //var myEnum = TestEnum.FromName("One");
            //var myEnum2 = TestEnum.One;
            //Console.WriteLine(myEnum.Equals(myEnum2));

            //if (TestEnum.TryFromName("One", out var myEnum3))
            //{
            //    Console.Write("One이 myEnum3에 있음");
            //}
            //else
            //{
            //    Console.Write("해당한것인 myEnum3에 없음");
            //}

            //
            // FromValue()
            //
            //// 값이 중복이 없는 경우
            //var myEnum = TestEnum.FromValue(1);

            //if (TestEnum.TryFromValue(1, out var myEnum1))
            //{
            //    Console.WriteLine(myEnum1.Name);
            //}
            //else
            //{
            //    Console.WriteLine("값이 없음");
            //}

            // 값이 중복인 경우
            var myEnum = TestEnum.FromValue(3);
            Console.WriteLine(myEnum.Name);

            if (TestEnum.TryFromValue(3, out var myEnum1))
            {
                Console.WriteLine(myEnum1.Name);
            }
            else
            {
                Console.WriteLine("값이 없음");
            }
        }
    }
}
