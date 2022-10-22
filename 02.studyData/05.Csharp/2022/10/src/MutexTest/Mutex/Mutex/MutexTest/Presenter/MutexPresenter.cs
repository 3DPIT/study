using MutexTest.UseCases;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MutexTest.Presenter
{
    public class MutexPresenter : IMutexOutputPort
    {
        public void WriteConsole(bool IsMutexSucess)
        {
            if (!IsMutexSucess)
            {
                Console.WriteLine("이미 같은 프로그램이 실행 중입니다.");
            }
            else
            {
                Console.WriteLine("프로그램 실행 중입니다.");
                //Console.ReadLine();
            }
        }
    }
}
