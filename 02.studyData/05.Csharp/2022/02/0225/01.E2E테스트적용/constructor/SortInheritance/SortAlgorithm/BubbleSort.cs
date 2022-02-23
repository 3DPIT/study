using System;

namespace Constructor.SortAlgorithm
{
    public class BubbleSort<T> : ISort<T>
    {
        private Func<T, T, int> _compare;
        public BubbleSort(Func<T, T, int> compare)
        {
            _compare = compare;
        }
        public T[] Run(T[] _number)
        {
            for (int cmpIndex = 0; cmpIndex <= _number.Length - 2; cmpIndex++)
            {
                for (int swapIndex = 0; swapIndex <= _number.Length - 2 - cmpIndex; swapIndex++)
                {
                    if (_compare(_number[swapIndex], _number[swapIndex + 1]) > 0)
                    {
                        (_number[swapIndex], _number[swapIndex + 1]) = (_number[swapIndex + 1], _number[swapIndex]);

                    }
                }
            }

            return _number;
        }
    }
}