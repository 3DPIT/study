using MediaFoundation.Misc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace MutexStart
{
    public class ProgramChecked : IMutex
    {
        private readonly bool _first;
        private string _guid;
        private Mutex _mtx;
        private readonly bool _mtxSuccess;
        private const string _RegistryAppKey = "MutexStart.Guid";
        


        public void Get()
        {
            _guid = checkProgram();
            var _mutex = new Mutex(true, _guid, out var _mtxSucess);
            if (!_mtxSucess)
            {
                Console.WriteLine("이미 실행 중입니다.");
            }
            else
            {
                while (true)
                {
                    Console.WriteLine("현재 실행 중입니다.");
                }
            }
        }
        public string checkProgram()
        {
            using (var projectKey = Microsoft.Win32.Registry.CurrentUser.CreateSubKey("MutexStart"))
            {
                var guid = projectKey.GetValue(_RegistryAppKey);
                
                var first = guid == null;
                guid = guid ?? Guid.NewGuid();

                projectKey.SetValue(_RegistryAppKey, guid);
                return guid.ToString().ToUpper();
            }
        }
    }
}



//if (!_mtxSucess)
//{
//    Console.WriteLine("에러: 현재 같음 프로그램이 동작중입니다.");
//}

//while (true)
//{
//    Console.WriteLine("상태: 완전 정상적으로 동작중입니다.");
//}