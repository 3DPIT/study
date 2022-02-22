using System;

namespace StrategyPatternAnonymousClass;

public class Client
{
    public static void Main(string[] args)
    {
        BlueLightReadLight blueLightReadLight = new BlueLightReadLight();
        blueLightReadLight.blueLight(new Fastest());
        blueLightReadLight.redLight(new Faster());
        blueLightReadLight.redLight(new Normal(){
           Normal.bl
        });
    }
}