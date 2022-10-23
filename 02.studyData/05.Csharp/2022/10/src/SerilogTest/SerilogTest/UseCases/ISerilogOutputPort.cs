using Serilog;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SerilogTest.UseCases
{
    public interface ISerilogOutputPort
    {
        public void LogWrite(ILogger log, string message);
    }
}
