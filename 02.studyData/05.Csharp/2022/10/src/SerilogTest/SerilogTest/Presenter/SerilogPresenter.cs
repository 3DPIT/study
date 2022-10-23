using Serilog;
using SerilogTest.UseCases;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SerilogTest.Presenter
{
    public class SerilogPresenter : ISerilogOutputPort
    {
        public void LogWrite(ILogger log, string message)
        {
            log.Information(message);
        }
    }
}
