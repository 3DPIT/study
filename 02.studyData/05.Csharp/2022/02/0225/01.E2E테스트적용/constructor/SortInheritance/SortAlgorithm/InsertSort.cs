using System;

namespace Constructor.SortAlgorithm
{
    public class InsertSort<T> : ISort<T>
    {
        private Func<T, T, int> _compare;
        public InsertSort(Func<T, T, int> compare)
        {
            _compare = compare;
        }
        public T[] Run (T[] _number)
        {
            for (int idx = 1; idx < _number.Length; idx++)
            {
                T key = _number[idx];
                int num = idx - 1;
                while (num != -1 && _compare(_number[num], key) > 0)
                {
                    _number[num + 1] = _number[num];
                    num--;
                }
                _number[num + 1] = key;
            }

            return _number;
        }
    }
}