using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPatternAddStrategy;

public class Faster : Speed
{
    public void blueLight()
    {
        Console.WriteLine("무 궁 화 꽃 이");
    }

    public void redLight()
    {
        Console.WriteLine("피 었 습 니 다.");
    }
}