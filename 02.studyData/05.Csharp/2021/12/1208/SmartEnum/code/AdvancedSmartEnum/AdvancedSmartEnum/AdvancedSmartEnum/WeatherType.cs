using System;
using System.Security.Cryptography;
using Ardalis.SmartEnum;

namespace AdvancedSmartEnum
{
    public abstract class Weather : SmartEnum<Weather>
    {
        public static readonly Weather Spring = new SpringStatus();
        public static readonly Weather Summer = new SummerStatus();
        public static readonly Weather Autumn = new AutumnStatus();
        public static readonly Weather Winter = new winterStatus();

        protected Weather(string name, int value) : base(name, value)
        {
        }
        public abstract TimeOnly SunriseTime { get;}

        public abstract TimeOnly SunsetTime { get; }


        private sealed class SpringStatus : Weather
        {
            public SpringStatus() : base("Spring", 0){}

            public override TimeOnly SunriseTime => new TimeOnly(8, 0, 0);
            public override TimeOnly SunsetTime => new TimeOnly(17, 0, 0);

        }
        private sealed class SummerStatus : Weather
        {
            public SummerStatus() : base("Summer", 1) { }
            public override TimeOnly SunriseTime => new TimeOnly(8, 30, 0);

            public override TimeOnly SunsetTime => new TimeOnly(17, 30, 0);
        }
        private sealed class AutumnStatus : Weather
        {
            public AutumnStatus() : base("Autumn", 2) { }

            public override TimeOnly SunriseTime => new TimeOnly(9, 0, 0);
            public override TimeOnly SunsetTime => new TimeOnly(18, 0, 0);
        }
        private sealed class winterStatus : Weather
        {
            public winterStatus() : base("Winter", 3) { }

            public override TimeOnly SunriseTime => new TimeOnly(10, 0, 0);
            public override TimeOnly SunsetTime => new TimeOnly(19, 0, 0);
        }
    }
}