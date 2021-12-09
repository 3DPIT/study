using Ardalis.SmartEnum;

namespace SmartEnum1
{
    public abstract class EmployeeType : SmartEnum<EmployeeType>
    {
        public static readonly EmployeeType Manager = new ManagerType();
        public static readonly EmployeeType Assistant = new AssistantType();

        protected EmployeeType(string name, int value) : base(name, value)
        {
        }

        public abstract decimal BonusSize { get; }

        private sealed class ManagerType : EmployeeType
        {
            public ManagerType() : base("Manager",1){}
            public override decimal BonusSize => 10_000m;
        }

        private sealed class AssistantType : EmployeeType
        {
            public AssistantType() : base("Assistant", 2) { }
            public override decimal BonusSize => 1_000m;
        }
    }
}