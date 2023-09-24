#include<stdio.h>
#include<iostream>
#include<algorithm>
using namespace std;

int main(void) {

	int N, M;
	cin >> N >> M;
	int num[100004] = { 0 };
	for (int i = 0; i < N; i++) {
		cin >> num[i];
	}

	int i = 0;
	int j = 0;
	int sum = num[i];
	int ret = 0x7fffffff;
	while(i<=j&&j<N){
		if (sum < M) {
			j++;
			sum += num[j];
		}
		else if (sum == M) {
			int ans = j - i + 1;
			ret = min(ret, ans);
			j++;
			sum += num[j];
		}
		else if (sum > M) {
			int ans = j - i + 1;
			ret = min(ret, ans);
			sum -= num[i];
			i++;
		}

	}

	if (ret == 0x7fffffff) ret = 0;
	cout << ret << endl;
	return 0;
}