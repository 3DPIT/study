using Google.Maps;
using Google.Maps.Geocoding;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Domain.UseCases
{
    public class GoogleMapsApi : ILocationApi
    {
        private readonly string _apiKey;

        public GoogleMapsApi(string apiKey)
        {
            _apiKey = apiKey ?? throw new ArgumentNullException(nameof(apiKey));
        }

        public LocationEntity GetLocation(string address)
        {
            if (address == null)
            {
                throw new ArgumentNullException(nameof(address));
            }

            var locationDetails = new LocationEntity();

            GoogleSigned.AssignAllServices(new GoogleSigned(_apiKey));

            var request = new GeocodingRequest();
            request.Address = address;
            var response = new GeocodingService().GetResponse(request);

            if (response.Status == ServiceResponseStatus.Ok && response.Results.Count() > 0)
            {
                var result = response.Results.First();
                locationDetails.FullAddress = result.FormattedAddress;
                locationDetails.Latitude = result.Geometry.Location.Latitude;
                locationDetails.Longitude = result.Geometry.Location.Longitude;
            }
            else
            {
                throw new Exception($"Unable to geocode.  Status={response.Status} and ErrorMessage={response.ErrorMessage}");
            }
            return locationDetails;
        }
    }
}
