using System;
using Serilog;
using Serilog.Core;
using Serilog.Events;


namespace serilogTest
{
    class Program
    {
        static void Main(string[] args)
        {
            var log = new LoggerConfiguration()
                .MinimumLevel.Information()
                .WriteTo.Console(restrictedToMinimumLevel:LogEventLevel.Error)
                .WriteTo.File("log.txt")
                .CreateLogger();
            
            log.Debug("Debug");
            log.Information("Information");
            log.Warning("Warning");
            log.Error("Error");
            log.Fatal("Fatal");

            Log.CloseAndFlush();
        }
    }
}
