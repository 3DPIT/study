namespace SortAlgorithm;

class Merge
{
    public void Sort(int[] arr)
    {
        Divide(arr,0,arr.Length-1);
    }

    private void Divide(int[] arr, int left, int right)
    {
        if(left<right)
        {
        var mid = (left+right)/2;
        Divide(arr, left, mid);
        Divide(arr, mid+1,right);
        ReMerge(arr,left,mid,right);
        }
    }
    private void ReMerge(int[]arr, int left, int mid, int right)
    {
        int index1 = left;
        int index2 = mid+1;
        int currentIndex = left;
        int[] copyArr =new int[30];
        while((index1<=mid)&&(index2<=right))
        {
            if(arr[index1]<=arr[index2])
            {
            copyArr[currentIndex++]=arr[index1++];
            }
            else if(arr[index1]>arr[index2])
            {
            copyArr[currentIndex++]=arr[index2++];
            }
        }
            if(mid<index1)//왼쪽이 먼저 끝난경우 남은 오른쪽 숫자 넣기
            {
                for(int i=index2; i<=right;i++)
                {
                    copyArr[currentIndex++]=arr[i];
                }
            }
            else if(right<index2)//오른쪽이 먼저 끝난 경우 남은 왼쪽 숫자 넣기
            {
                for(int i=index1; i<=mid;i++)
                {
                    copyArr[currentIndex++]=arr[i];
                }
            }

            for(int i=left;i<=right;i++)
            {//정렬된 배열 카피
                arr[i]= copyArr[i];
            }
    }
}
