using System;

namespace SortInheritance.Algorithm
{
    public class BubleSort : Sort
    {
        private int[] _number = new int[6];
        private int _cmp;

        public BubleSort(int[] number, int cmp) : base(number, cmp)
        {
            Array.Copy(number, 0, _number, 0, number.Length);
            _cmp = cmp;
        }

        public override int[] Run()
        {
            for (int cmpIndex = 0; cmpIndex <= _number.Length - 2; cmpIndex++)
            {
                for (int swapIndex = 0; swapIndex <= _number.Length - 2 - cmpIndex; swapIndex++)
                {
                    if (_cmp == 0
                        ? (_number[swapIndex] > _number[swapIndex + 1])
                        : (_number[swapIndex] < _number[swapIndex + 1])) //cmp==0 오른차순 , 1이면 내림차순
                    {
                        (_number[swapIndex], _number[swapIndex + 1]) = (_number[swapIndex + 1], _number[swapIndex]);

                    }
                }
            }

            return _number;
        }
    }
}