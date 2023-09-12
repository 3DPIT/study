#include<stdio.h>
#include<iostream>
using namespace std;
int arr[24];
int N, S;
int ret = 0;

void dfs(int sum, int idx) {
	if (idx == N) {
		if (sum == S) {
			ret++;
		}
		return;
	}

	dfs(sum + arr[idx], idx + 1);
	dfs(sum, idx + 1);
}

int main(void)
{
	scanf("%d %d", &N, &S);

	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}

	dfs(0, 0);
	//int ret1 = (1 << N);
	//printf("%d\n", ret1);
	//for (int i = 1; i < (1 << N); i++) {
	//	
	//	int sum = 0;
	//	for (int k = 0; k < N; k++) {
	//		if (i&(1 << k)) {
	//			cout << "k"<< k << endl;
	//			//cout << (1 << k) << endl;
	//			sum += arr[k];
	//		}
	//	}
	//	cout << endl;
	//	if (sum == S) ret++;
	//}
	if (S == 0) ret--;
	printf("%d", ret);
	return 0;
}
