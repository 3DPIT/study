#include<stdio.h>

using namespace std;
int main(void)
{
	int arr[24];
	int N = 0;
	int S = 0;
	int ret = 0;
	scanf("%d %d", &N, &S);

	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
	for (int i = 1; i < (1 << N); i++) {
		int sum = 0;
		for (int k = 0; k < N; k++) {
			if (i&(1 << k)) {
				sum += arr[k];
			}
		}
		if (sum == S) ret++;
	}

	printf("%d", ret);
	return 0;
}