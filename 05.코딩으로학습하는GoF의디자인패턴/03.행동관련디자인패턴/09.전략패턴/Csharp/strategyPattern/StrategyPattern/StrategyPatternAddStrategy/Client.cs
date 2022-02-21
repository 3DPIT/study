using System;

namespace StrategyPatternAddStrategy;

public class Client
{
    public static void Main(string[] args)
    {
        BlueLightReadLight blueLightReadLight = new BlueLightReadLight();
        blueLightReadLight.blueLight(new Fastest());
        blueLightReadLight.redLight(new Faster());
    }
}