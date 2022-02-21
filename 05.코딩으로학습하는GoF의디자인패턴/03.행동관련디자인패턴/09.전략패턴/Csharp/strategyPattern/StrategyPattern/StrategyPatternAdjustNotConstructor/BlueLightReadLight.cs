using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPatternAdjustNotConstructor;

public class BlueLightReadLight
{
    public void blueLight(Speed speed)
    {
        speed.blueLight();
    }

    public void redLight(Speed speed)
    {
        speed.redLight();
    }
}