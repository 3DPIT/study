using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPatternAdjust;

public class BlueLightReadLight
{
    private Speed _speed;
    public BlueLightReadLight(Speed speed)
    {
        _speed = speed;
    }
    public void blueLight()
    {
        _speed.blueLight();
    }

    public void redLight()
    {
        _speed.redLight();
    }
}