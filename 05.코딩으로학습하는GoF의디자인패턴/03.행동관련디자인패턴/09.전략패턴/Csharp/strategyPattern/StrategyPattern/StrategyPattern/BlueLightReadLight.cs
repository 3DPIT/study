using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StrategyPattern;
public class BlueLightReadLight
{
    private int _speed;
    public BlueLightReadLight(int speed)
    {
        _speed = speed;
    }

    public void blueLight()
    {
        if (_speed == 1)
            Console.WriteLine("무  궁  화  꽃  이");
        else if (_speed == 2)
            Console.WriteLine("무 궁 화 꽃 이");
        else if (_speed == 3)
            Console.WriteLine("무궁화꽃이");
    }

    public void redLight()
    {
        if (_speed == 1)
            Console.WriteLine("피  었  습  니  다.");
        else if (_speed == 2)
            Console.WriteLine("피 었 습 니 다.");
        else if (_speed == 3)
            Console.WriteLine("피었습니다.");
    }
}


