using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPatternNotConstructor;
public class BlueLightReadLight
{
    public void blueLight(int speed)
    {
        if (speed == 1)
            Console.WriteLine("무  궁  화  꽃  이");
        else if (speed == 2)
            Console.WriteLine("무 궁 화 꽃 이");
        else if (speed == 3)
            Console.WriteLine("무궁화꽃이");
    }

    public void redLight(int speed)
    {
        if (speed == 1)
            Console.WriteLine("피  었  습  니  다.");
        else if (speed == 2)
            Console.WriteLine("피 었 습 니 다.");
        else if (speed == 3)
            Console.WriteLine("피었습니다.");
    }
}


