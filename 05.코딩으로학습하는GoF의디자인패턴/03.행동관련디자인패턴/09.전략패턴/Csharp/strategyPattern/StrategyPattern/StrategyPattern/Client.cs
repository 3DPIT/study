using System;

namespace StrategyPattern;

public class Client
{
    public static void Main(string[] args)
    {
        BlueLightReadLight blueLightReadLight = new BlueLightReadLight(1);
        blueLightReadLight.blueLight();
        blueLightReadLight.redLight();
    }
}