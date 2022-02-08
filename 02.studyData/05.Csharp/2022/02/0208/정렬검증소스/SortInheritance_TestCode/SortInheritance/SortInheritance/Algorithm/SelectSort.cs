using System;

namespace SortInheritance.Algorithm
{
    public class SelectSort : Sort
    {
        private int[] _number = new int[6];
        private int _cmp;
        public SelectSort(int[] number, int cmp) : base(number, cmp)
        {
            Array.Copy(number, 0, _number, 0, number.Length);
            _cmp = cmp;
        }

        public override int[] Run()
        {
            for (int currentIdx = 0; currentIdx < _number.Length; currentIdx++)
            {
                int minIndex = 0; // 최소값 위치 저장
                int cmpNumber = _cmp == 0 ? Int32.MaxValue : Int32.MinValue; // 최소값 저장

                for (int searchIdx = currentIdx; searchIdx < _number.Length; searchIdx++) //최소값 뽑아내는 부분
                {
                    if (_cmp == 0 ? cmpNumber > _number[searchIdx] : cmpNumber < _number[searchIdx])
                    {
                        cmpNumber = _number[searchIdx];
                        minIndex = searchIdx;
                    }
                }

                (_number[currentIdx], _number[minIndex]) = (_number[minIndex], _number[currentIdx]); //자리교체
            }

            return _number;
        }
    }
}