using Serilog;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SerilogTest.UseCases
{
    public class SerilogInteractor : ISerilogInputPort
    {
        private readonly ISerilogOutputPort _outputPort;
        private string _message;
        private ILogger _logger;
        public SerilogInteractor(ISerilogOutputPort outputPort)
        {
            _outputPort = outputPort;

        }

        public void LogInit()
        {
            _logger = Log.Logger = new LoggerConfiguration()
                .MinimumLevel.Information()
                .WriteTo.Console()
                .WriteTo.File(@"C:\log\log.txt",
                rollingInterval: RollingInterval.Day,
                rollOnFileSizeLimit: true)
                .CreateLogger();
        }

        public void HandleLog(string message)
        {
            _outputPort.LogWrite(_logger, message);
        }
    }
}
