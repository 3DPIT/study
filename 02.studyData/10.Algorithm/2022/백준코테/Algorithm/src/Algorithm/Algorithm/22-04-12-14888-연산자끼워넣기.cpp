#include<stdio.h>
#include<iostream>
#include<vector>
#define NS 12
int N;
int number[NS];
int D[NS];
int sumNumber;
int minNumber;
int maxNumber;
void init()
{
	minNumber = 0x7fffffff;
	maxNumber = 0x80000000;
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &number[i]);
	}
	for (int i = 0; i < 4; i++)
	{
		scanf("%d", &D[i]);
		sumNumber += D[i];
	}
}

void dfs(int idx, int plus, int minus, int multiple, int divide, int sum)
{
	if (idx == sumNumber)
	{
		minNumber = minNumber > sum ? sum : minNumber;
		maxNumber = maxNumber < sum ? sum : maxNumber;
		return;
	}
	if (plus) dfs(idx + 1, plus - 1, minus, multiple, divide, sum + number[idx+1]);
	if (minus) dfs(idx + 1, plus, minus-1, multiple, divide, sum - number[idx + 1]);
	if (multiple) dfs(idx + 1, plus, minus, multiple-1, divide, sum * number[idx + 1]);
	if (divide) dfs(idx + 1, plus, minus, multiple, divide-1, sum / number[idx + 1]);
}
int main(void)
{
	init();
	dfs(0, D[0], D[1], D[2], D[3], number[0]);
	printf("%d\n%d\n", maxNumber, minNumber);
	return 0;
}
