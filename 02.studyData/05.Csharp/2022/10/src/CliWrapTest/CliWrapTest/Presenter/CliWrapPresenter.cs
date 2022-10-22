using Akka.Configuration;
using CliWrap;
using CliWrapTest.UseCases;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CliWrapTest.Presenter
{
    public class CliWrapPresenter : ICliWrapOutputPort
    {
        public void ExcuteSite(string url, string path)
        {
            if (string.IsNullOrEmpty(path))
            {
                Cli.Wrap("explorer")
                    .WithArguments("https://www.google.com/chrome/")
                    .WithValidation(CommandResultValidation.None)
                    .ExecuteAsync();
                Console.WriteLine("https://www.google.com/chrome/");
                return;
            }
            else
            {
                Cli.Wrap(path)
                    .WithArguments(url)
                    .WithValidation(CommandResultValidation.None)
                    .ExecuteAsync();
                Console.WriteLine(url);
                return;
            }
        }
    }
}
