using CliWrapTest.UseCases;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CliWrapTest.Controller
{
    public class CliWrapController
    {
        private readonly ICliWrapInputPort _cliWrapInputPort;

        public CliWrapController(ICliWrapInputPort cliWrapInputPort)
        {
            _cliWrapInputPort = cliWrapInputPort;
        }

        public void GetInputData(string url, string mainFolder, string configFileName)
        {
            _cliWrapInputPort.InputPath(url, mainFolder, configFileName);
        }
    }
}
