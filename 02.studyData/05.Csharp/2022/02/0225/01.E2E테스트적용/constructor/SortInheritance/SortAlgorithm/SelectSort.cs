using System;

namespace Constructor.SortAlgorithm
{
    public class SelectSort<T> : ISort<T>
    {
        private Func<T, T, int> _compare;
        public SelectSort(Func<T, T, int> compare)
        {
            _compare = compare;
        }
        public T[] Run(T[] _number)
        {
            for (int currentIdx = 0; currentIdx < _number.Length; currentIdx++)
            {
                int minIndex = currentIdx;

                for (int searchIdx = currentIdx; searchIdx < _number.Length; searchIdx++) //최소값 뽑아내는 부분
                {
                    if (_compare(_number[minIndex], _number[searchIdx]) > 0)
                    {
                        _number[searchIdx] = _number[searchIdx];
                        minIndex = searchIdx;
                    }
                }

                (_number[currentIdx], _number[minIndex]) = (_number[minIndex], _number[currentIdx]); //자리교체
            }

            return _number;
        }
    }
}