using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.UseCases
{
    public class LocationEntity
    {
        public string? FullAddress { get; set; }
        public double Latitude { get; set; }
        public double Longitude { get; set; }
    }
}
