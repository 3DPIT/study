using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPatternAnonymousClass;

public class Fastest : Speed
{
    public void blueLight()
    {
        Console.WriteLine("무궁화꽃이");
    }

    public void redLight()
    {
        Console.WriteLine("피었습니다.");
    }
}