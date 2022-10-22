using MutexTest.UseCases;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MutexTest.Controller
{
    public class MutexController
    {
        private readonly IMutexInputPort _mutexInputPort;
        private readonly Mutex _mutexRusult;
        public MutexController(IMutexInputPort mutexInputPort)
        {
            _mutexInputPort = mutexInputPort;
        }
        
        public void GetInputData()
        {
           _mutexInputPort.MutexInputPort();
        }
    }
}
