#include<stdio.h>
#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;
int N, M;
int D[10004];
int ret;

int main(void) {
	
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) {
		cin >> D[i];
	}
	
	int sum = D[0];
	int i=0, j = 0;
	for(int i=0, j=0;i<=j&&j<N;){
	if (sum > M){
			sum -= D[i];
			i++;
			if (i > j && i < N) {
				j = i;
				sum = D[i];
			}
		}
		else if (sum < M) {
			j++;
			sum += D[j];
		}
		else if (sum == M) {
			ret++;
			j++;
			sum += D[j];
		}
	}

	cout << ret << endl;
	return  0;
}