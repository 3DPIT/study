using Akka.Configuration;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace CliWrapTest.UseCases
{
    public class CliWrapInteractor : ICliWrapInputPort
    {
        private readonly ICliWrapOutputPort _cliWrapOutputPort;
        private readonly string _path;
        private Config _config;
        private string _url;
        
        public CliWrapInteractor(ICliWrapOutputPort cliWrapOutput)
        {
            _cliWrapOutputPort = cliWrapOutput;
            _path = GetChromePath();
        }

        public void InputPath(string url, string mainFolder, string configFileName)
        {
            var assembly = Assembly.GetExecutingAssembly();
            _config = ReadConfigurationFromHoconFile(assembly, mainFolder, configFileName);
            _url = _config.GetString(url);
        }

        public void Handle()
        {
            _cliWrapOutputPort.ExcuteSite(_url, _path);
        }

        private string GetChromePath()
        {
            string path = Microsoft.Win32.Registry.GetValue(@"HKEY_CLASSES_ROOT\ChromeHTML\shell\open\command", null, null) as string;
            if (path != null)
            {
                var split = path.Split('\"');
                path = split.Length >= 2 ? split[1] : null;
            }

            return path;
        }

        private Akka.Configuration.Config ReadConfigurationFromHoconFile(Assembly assembly, string configDirectoryName, string configAppFileName)
        {
            var assemblyFilePath = new Uri(assembly.GetName().CodeBase).LocalPath;
            var assemblyDirectoryPath = Path.GetDirectoryName(assemblyFilePath);
            //var configAppFileName = Path.GetFileNameWithoutExtension(assemblyFilePath);
            var configFileFullPath = Path.Combine(assemblyDirectoryPath, configDirectoryName, $"{configAppFileName}.conf");
            return Akka.Configuration.ConfigurationFactory.ParseString(File.ReadAllText(configFileFullPath));
        }
    }
}
