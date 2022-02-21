using System;

namespace StrategyPatternAdjust;

public class Client
{
    public static void Main(string[] args)
    {
        BlueLightReadLight blueLightReadLight = new BlueLightReadLight(new Normal());
        blueLightReadLight.blueLight();
        blueLightReadLight.redLight();
    }
}