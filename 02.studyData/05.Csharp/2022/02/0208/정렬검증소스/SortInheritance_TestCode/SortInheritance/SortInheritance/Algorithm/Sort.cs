using System;

namespace SortInheritance.Algorithm
{
    public class Sort
    {
        private int[] _number = new int[6];
        private int _cmp;
        public Sort(int[] number, int cmp)
        {
            Array.Copy(number,0,_number,0,number.Length);
            _cmp = _cmp;
        }

        public virtual int[] Run()
        {
            if (_cmp == 0)
            {
                return _number;
            }

            return _number;
        }
    }
}