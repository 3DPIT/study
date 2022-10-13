using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CleanArchitecture.ApllicationWorkRule
{
    public class UsecaseInteractor : IUsecaseInputPort
    {
        int number1 = 0;
        public UsecaseInteractor(int number1)
        {
            this.number1 = number1;
        } 
        public int inputNumber()
        {
            return this.number1;
        }
    }
}
