using System;
using FlaUI.UIA3;

namespace HelloflaUI;

public class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine("Hello fla");
        var app = FlaUI.Core.Application.Launch("notepad.exe");
        using (var automation = new UIA3Automation())
        {
            var window = app.GetMainWindow(automation);
            Console.WriteLine(window.Title);
        }
    }
}