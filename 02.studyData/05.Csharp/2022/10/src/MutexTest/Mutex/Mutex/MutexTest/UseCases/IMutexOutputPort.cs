using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MutexTest.UseCases
{
    public interface IMutexOutputPort
    {
        public void WriteConsole(bool IsMutexSucess);
    }
}