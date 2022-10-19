using CliWrapTest.Controller;
using CliWrapTest.Presenter;
using CliWrapTest.UseCases;

namespace CliWrapTest
{
    public class Program
    {
        static void Main(string[] args)
        {
            CliWrapPresenter cliWrapPresenter = new CliWrapPresenter();
            CliWrapInteractor cliWrapInteractor = new CliWrapInteractor(cliWrapPresenter);
            CliWrapController cliWrapController = new CliWrapController(cliWrapInteractor);

            //그라파나 운동 사이트 실행
            cliWrapController.GetInputData("ui.server.url_exercise", "Configs", "Mirero.BLUE-CATS.AlertNotifie");
            cliWrapInteractor.Handle();

            //그라파나 로또 사이트 실행
            cliWrapController.GetInputData("ui.server.url_lotto", "Configs1", "KmConfig");
            cliWrapInteractor.Handle();
        }
    }
}