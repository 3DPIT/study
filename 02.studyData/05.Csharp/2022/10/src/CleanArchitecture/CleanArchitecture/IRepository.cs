using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.UseCases
{
    public interface IRepository
    {
        LocationEntity GetLocation(string address);
    }

}
