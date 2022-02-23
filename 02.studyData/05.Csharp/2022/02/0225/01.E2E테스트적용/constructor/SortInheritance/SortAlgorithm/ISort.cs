using System;

namespace Constructor.SortAlgorithm
{
    public interface ISort<T>
    {
        public T[] Run( T[] arr);
    }
}