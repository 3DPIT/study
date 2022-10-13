using CleanArchitecture.ApllicationWorkRule;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CleanArchitecture.InterfaceAdapter
{
    public class Presenter : IUsecaseOutputPort
    {
        public int outputNumber(int number1)
        {
            return number1;
        }
    }
}
