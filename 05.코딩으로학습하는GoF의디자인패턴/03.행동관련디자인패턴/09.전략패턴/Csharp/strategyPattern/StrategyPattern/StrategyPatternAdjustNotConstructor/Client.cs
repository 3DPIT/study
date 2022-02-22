using System;

namespace StrategyPatternAdjustNotConstructor;

public class Client
{
    public static void Main(string[] args)
    {
        BlueLightReadLight blueLightReadLight = new BlueLightReadLight();
        blueLightReadLight.blueLight(new Normal());
        blueLightReadLight.redLight(new Faster());
    }
}