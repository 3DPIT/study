using FluentAssertions;
using Microsoft.VisualStudio.TestPlatform.ObjectModel;
using MutexTest.Controller;
using MutexTest.Presenter;
using MutexTest.UseCases;
using NetArchTest.Rules;
using System.Diagnostics;
using System.Reflection;
using Xunit.Abstractions;
using TestResult = NetArchTest.Rules.TestResult;

namespace MutexTest.IntegrationTest
{
    public class MutexIntegrationTest
    {
        private readonly ITestOutputHelper _output;
        public MutexIntegrationTest(ITestOutputHelper output)
        {
            _output = output;
        }
        [Fact]
        public void MutexE2E()
        {
            //Arrange
            using (Process process = new Process())
            {
                string path = Path.GetFileName(Environment.CurrentDirectory);
                Console.WriteLine(path);
                process.StartInfo.FileName = $"../{path}\\MutexTest.exe";
                process.StartInfo.RedirectStandardInput = true;
                process.StartInfo.RedirectStandardOutput = true;

                //Act
                process.Start();
                string expect = "���α׷� ���� ���Դϴ�.";
                var actual = process.StandardOutput.ReadLine();

                //Assert
                actual.Should().Be(expect);

                process.WaitForExit();
            }
        }
    }
}