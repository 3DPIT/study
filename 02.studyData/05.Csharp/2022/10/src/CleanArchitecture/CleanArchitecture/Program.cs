using CleanArchitecture.ApllicationWorkRule;
using CleanArchitecture.InterfaceAdapter;

public class Program
{
    public static void Main(string[] args)
    {
        Controller controller = new Controller();

        UsecaseInteractor usecaseInteractor = new UsecaseInteractor();
        usecaseInteractor.inputOutput(1);

        Presenter presenter = new Presenter();
        Console.WriteLine(presenter.outputNumber());
    }
}