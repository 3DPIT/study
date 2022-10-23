using SerilogTest.UseCases;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SerilogTest.Controller
{
    public class SerilogController
    {
        private readonly ISerilogInputPort _serilogInputPort;

        public SerilogController (ISerilogInputPort serilogInputPort)
        {
            _serilogInputPort = serilogInputPort;
        }   
        public void GetInputData()
        {
            _serilogInputPort.LogInit();
        }
    }
}
