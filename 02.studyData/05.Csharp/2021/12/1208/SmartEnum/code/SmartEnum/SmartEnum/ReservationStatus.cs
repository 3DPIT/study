using Ardalis.SmartEnum;

namespace SmartEnum1
{
    public abstract class ReservationStatus : SmartEnum<ReservationStatus>
    {
        public static readonly ReservationStatus New = new NewStatus();
        public static readonly ReservationStatus Accepted = new AcceptedStatus();
        public static readonly ReservationStatus Paid = new PaidStatus();
        public static readonly ReservationStatus Cancelled = new CancelledStatus();
        private ReservationStatus(string name, int value) : base(name, value)
        {
        }
        public abstract bool CanTransitionTo(ReservationStatus next);

        private sealed class NewStatus : ReservationStatus
        {
            public NewStatus() : base("New", 0)
            {
            }
            public override bool CanTransitionTo(ReservationStatus next) =>
                next == ReservationStatus.Accepted || next == ReservationStatus.Cancelled;
        }

        private sealed class AcceptedStatus : ReservationStatus
        {
            public AcceptedStatus() : base("Accepted", 1)
            {
            }
            public override bool CanTransitionTo(ReservationStatus next) =>
                next == ReservationStatus.Paid || next == ReservationStatus.Cancelled;
        }

        private sealed class PaidStatus : ReservationStatus
        {
            public PaidStatus() : base("Paid", 2)
            {
            }

            public override bool CanTransitionTo(ReservationStatus next) =>
                next == ReservationStatus.Cancelled;
        }
        private sealed class CancelledStatus : ReservationStatus
        {
            public CancelledStatus() : base("Cancelled", 3)
            {
            }
            public override bool CanTransitionTo(ReservationStatus next) =>
                false;
        }
    }
}