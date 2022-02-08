using System;

namespace SortInheritance.Algorithm
{
    public class InsertSort : Sort
    {
        private int[] _number = new int[6];
        private int _cmp;
        public InsertSort(int[] number, int cmp) : base(number, cmp)
        {
            Array.Copy(number, 0, _number, 0, number.Length);
            _cmp = cmp;
        }

        public override int[] Run()
        {
            for (int idx = 1; idx < _number.Length; idx++)
            {
                int key = _number[idx];
                int num = idx - 1;
                while (_cmp == 0 ? (num != -1 && _number[num] > key) : (num != -1 && _number[num] < key))
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