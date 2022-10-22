using MutexTest.Controller;
using MutexTest.Presenter;
using MutexTest.UseCases;
using System;

namespace MutexTest
{
    class Program
    {
        public static void Main(string[] args)
        {
           MutexPresenter mutexPresenter = new MutexPresenter();
           MutexInteractor mutexInteractor = new MutexInteractor(mutexPresenter);
           MutexController mutexController = new MutexController(mutexInteractor);
           mutexController.GetInputData();
           mutexInteractor.Handle();         
        }
    }
}
    