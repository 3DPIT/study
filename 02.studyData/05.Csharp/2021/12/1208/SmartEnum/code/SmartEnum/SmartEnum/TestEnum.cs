using Ardalis.SmartEnum;

namespace SmartEnum1
{
    ////
    //// 1
    ////
    //public sealed class TestEnum : SmartEnum<TestEnum>
    //{
    //    public static readonly TestEnum One = new TestEnum(nameof(One), 1);
    //    public static readonly TestEnum Two = new TestEnum(nameof(Two), 2);
    //    public static readonly TestEnum Three = new TestEnum(nameof(Three), 3);
    //    public TestEnum(string name, int value) : base(name, value)
    //    {
    //    }
    //}

    ////
    //// 2
    //// 
    //public sealed class TestEnum : SmartEnum<TestEnum, ushort>
    //{
    //    public static readonly TestEnum One = new TestEnum("A string!", 1);
    //    public static readonly TestEnum Two = new TestEnum("Another string!", 2);
    //    public static readonly TestEnum Three = new TestEnum("Yet another string!", 3);
    //    public TestEnum(string name, ushort value) : base(name, value)
    //    {
    //    }
    //}

    //
    // 3
    //
    public sealed class TestEnum : SmartEnum<TestEnum>
    {
        public static readonly TestEnum One = new TestEnum(nameof(One), 1);
        public static readonly TestEnum Two = new TestEnum(nameof(Two), 2);
        public static readonly TestEnum Three = new TestEnum(nameof(Three), 3);
        public static readonly TestEnum ZnotherThree = new TestEnum(nameof(ZnotherThree), 3);
        public TestEnum(string name, int value) : base(name, value)
        {
        }
    }
}