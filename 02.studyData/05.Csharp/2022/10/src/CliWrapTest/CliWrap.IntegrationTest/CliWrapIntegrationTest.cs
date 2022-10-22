using CliWrapTest.Controller;
using CliWrapTest.Presenter;
using CliWrapTest.UseCases;
using FluentAssertions;
using System.Diagnostics;
using Xunit.Abstractions;

namespace CliWrap.IntegrationTest
{
    public class CliWrapIntegrationTest
    {

        private readonly ITestOutputHelper _output;
        public CliWrapIntegrationTest(ITestOutputHelper output)
        {
            _output = output;
        }
        [Fact]
        public void CliWrapE2E()
        {
            //Arrange
            using (Process process = new Process())
            {
                string path = Path.GetFileName(Environment.CurrentDirectory);
                Console.WriteLine(path);
                process.StartInfo.FileName = $"../{path}\\CliWrapTest.exe";
                process.StartInfo.RedirectStandardInput = true;
                process.StartInfo.RedirectStandardOutput = true;

                //Act
                process.Start();
                string expect = "http://kyeongmin.iptime.org:3000";
                var actual = process.StandardOutput.ReadLine();
                
                //Assert
                actual.Should().Be(expect);
          
                process.WaitForExit();
            }
        }
    }
}