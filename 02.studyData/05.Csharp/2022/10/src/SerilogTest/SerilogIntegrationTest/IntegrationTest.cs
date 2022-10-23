using System.Diagnostics;
using Microsoft.VisualStudio.TestPlatform.ObjectModel;
using System.Diagnostics;
using System.Reflection;
using Xunit.Abstractions;
using FluentAssertions;

namespace SerilogIntegrationTest
{
    public class IntegrationTest
    {
        [Fact]
        public void Test1()
        {
            using (Process process = new Process())
            {
                string path = Path.GetFileName(Environment.CurrentDirectory);
                Console.WriteLine(path);
                process.StartInfo.FileName = $"../{path}\\SerilogTest.exe";
                process.StartInfo.RedirectStandardInput = true;
                process.StartInfo.RedirectStandardOutput = true;

                //Act
                process.Start();
                string expect = " INF] serilog test1";
                // 0-9
                var actual = process.StandardOutput.ReadLine();
                actual = actual.Substring(9, actual.Length-9);

                //Assert
                actual.Should().Be(expect);

                process.WaitForExit();
            }
        }
    }
}