#include<cstdio>
#include<iostream>
using namespace std;
int ret = 0;
void dfs(int sum, int resultNumber)
{
	if (sum > resultNumber) return;
	if (resultNumber == sum) {
		ret++;
		return;
	}

	dfs(sum + 1, resultNumber);
	dfs(sum + 2, resultNumber);
	dfs(sum + 3, resultNumber);
}
int main(void)
{
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		int X = 0;
		scanf("%d", &X);
		dfs(0, X);
		cout << ret << endl;

		ret = 0;
	}

	return 0;
}