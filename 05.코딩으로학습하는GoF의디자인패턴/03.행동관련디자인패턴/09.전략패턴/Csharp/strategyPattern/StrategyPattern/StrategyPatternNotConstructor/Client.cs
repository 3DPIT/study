using System;

namespace StrategyPatternNotConstructor;

public class Client
{
    public static void Main(string[] args)
    {
        BlueLightReadLight blueLightReadLight = new BlueLightReadLight();
        blueLightReadLight.blueLight(1);
        blueLightReadLight.redLight(2);
    }
}