using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.UseCases
{
    public class LocationRepository : IRepository
    {
        private readonly ILocationApi _api;
        public LocationRepository(ILocationApi api)
        {
            _api = api?? throw new ArgumentException(nameof(api));
        }

        public LocationEntity GetLocation(string address)
        {
            if (string.IsNullOrEmpty(address))
            {
                throw new ArgumentException(nameof(address));
            }

            return _api.GetLocation(address);
        }
    }
}
