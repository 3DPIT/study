using CleanArchitecture;
using CleanArchitecture.ApllicationWorkRule;
using CleanArchitecture.InterfaceAdapter;
using Domain.UseCases;
using Ninject;

public class Program
{
    public static void Main(string[] args)
    {
        IKernel kernel = new StandardKernel(new LocationInformationModule());
        var useCase = kernel.Get<GetLocationInteractor>();
        Console.WriteLine("Type in an address to find out its details......");
        string address = Console.ReadLine();
        if (!string.IsNullOrWhiteSpace(address))
        {
            var locationDetails = useCase.Handle(address);
            Console.WriteLine($"Details for {address}:");
            Console.WriteLine($"Full Address: {locationDetails.FullAddress}");
            Console.WriteLine($"Latitude: {locationDetails.Latitude}");
            Console.WriteLine($"Longitude: {locationDetails.Longitude}");
        }
    }
}