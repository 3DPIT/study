using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MutexTest.UseCases
{
    public class MutexInteractor : IMutexInputPort
    {
        private readonly IMutexOutputPort _mutexOutputPort;
        private readonly Mutex _mutex;
        private string _guid;
        private bool _mtxSuccess;
        private const string _registryAppKey = "MutexTest.Guid";

        public MutexInteractor(IMutexOutputPort mutexOutputPort)
        {
            _mutexOutputPort = mutexOutputPort;
        }
        public void MutexInputPort()
        {
            var projectKey = Microsoft.Win32.Registry.CurrentUser.CreateSubKey("MutexTest");
            var guid = projectKey.GetValue(_registryAppKey);
            guid = guid ?? Guid.NewGuid();
            projectKey.SetValue(_registryAppKey, guid);
            _guid = guid.ToString().ToUpper();
            new Mutex(true, _guid, out _mtxSuccess);
        }

        public void Handle()
        {
            _mutexOutputPort.WriteConsole(_mtxSuccess);
        }
    }
}
