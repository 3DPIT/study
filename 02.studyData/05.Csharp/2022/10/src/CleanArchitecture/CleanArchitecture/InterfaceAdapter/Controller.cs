using CleanArchitecture.ApllicationWorkRule;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CleanArchitecture.InterfaceAdapter
{
    public class Controller
    {
        UsecaseInteractor usecaseInteractor = new UsecaseInteractor(1);
    }
}
