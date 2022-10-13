using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.UseCases
{
    public class GetLocationInteractor
    {
        private readonly IRepository _repository;
        public GetLocationInteractor(IRepository repository)
        {
            _repository = repository ?? throw new ArgumentException(nameof(repository)); ;
        }

        public LocationEntity Handle(string address)
        {
            if (string.IsNullOrEmpty(address))
            {
                throw new ArgumentException(nameof(address));
            }

            return _repository.GetLocation(address);
        }
    }
}
