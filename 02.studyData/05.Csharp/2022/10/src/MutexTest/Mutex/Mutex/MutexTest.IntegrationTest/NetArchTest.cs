using Microsoft.VisualStudio.TestPlatform.ObjectModel;
using MutexTest.Presenter;
using MutexTest.UseCases;
using NetArchTest.Rules;
using System.Reflection;
using TestResult = NetArchTest.Rules.TestResult;

namespace MutexTest.IntegrationTest
{
    public class NetArchTest
    {
        //사이트 참고
        private static Assembly InputPortDomainAssembly => typeof(IMutexInputPort).Assembly;

        [Fact]
        public void IMutexInputPort_Should_Be_Immutable()
        {
            var result = Types.InAssembly(InputPortDomainAssembly)
                .That()
                .Inherit(typeof(IMutexInputPort))
                .Should()
                .BeImmutable()
                .GetResult();

            Assert.True(result.IsSuccessful, GetFailingTypes(result));

        }

        private static Assembly OutputPortDomainAssembly => typeof(IMutexOutputPort).Assembly;

        [Fact]
        public void IMutexOutputPort_Should_Be_Immutable()
        {
            var result = Types.InAssembly(OutputPortDomainAssembly)
                 .That()
                 .Inherit(typeof(IMutexInputPort))
                 .Should()
                 .BeImmutable()
                 .GetResult();

            Assert.True(result.IsSuccessful, GetFailingTypes(result));
        }



        // namespace별 controller -> usecases 
        [Fact]
        public void Controller_Should_Be_Immutable()
        {
            var result = Types.InCurrentDomain()
                .That()
                .ResideInNamespace("MutexTest.Controller")
                .Should()
                .HaveDependencyOn("MutexTest.UseCases")
                .GetResult()
                .IsSuccessful;

            Assert.True(result);
        }

        // namespace별 presenter -> usecases 
        [Fact]
        public void Presenter_Should_Be_Immutable()
        {
            var result = Types.InCurrentDomain()
                .That()
                .ResideInNamespace("MutexTest.Presenter")
                .Should()
                .HaveDependencyOn("MutexTest.UseCases")
                .GetResult()
                .IsSuccessful;

            Assert.True(result);
        }

        private string GetFailingTypes(TestResult result)
        {
            return result.FailingTypeNames != null ?
                string.Join(", ", result.FailingTypeNames) :
                string.Empty;
        }
    }
}