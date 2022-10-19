using Akka.Configuration;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CliWrapTest.UseCases
{
    public interface ICliWrapOutputPort
    {
        public void ExcuteSite(string url, string path);
    }
}
