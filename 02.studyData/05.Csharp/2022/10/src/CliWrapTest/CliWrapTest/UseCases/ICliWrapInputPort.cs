using Akka.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CliWrapTest.UseCases
{
    public interface ICliWrapInputPort
    {
        public void InputPath(string url, string mainFolder, string configFileName);
    }
}
