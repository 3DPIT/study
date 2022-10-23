using Serilog;
using SerilogTest.Controller;
using SerilogTest.Presenter;
using SerilogTest.UseCases;

public class Program
{
    public static void Main(string[] args)
    {
        SerilogPresenter serilogPresenter = new SerilogPresenter();
        SerilogInteractor serilogInteractor = new SerilogInteractor(serilogPresenter);
        SerilogController serilogController = new SerilogController(serilogInteractor);

        serilogController.GetInputData();
        serilogInteractor.HandleLog("serilog test1");
    }
}