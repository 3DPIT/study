#include<stdio.h>
#include<iostream>
using namespace std;
int N, M;
int main(void)
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int A[104][104];
	int B[104][104];

	cin >> N >> M;
	for (int i = 0; i < N; i++){
		for (int j = 0; j < N; j++) {
			int number;
			cin >> number;
			A[i][j] = number;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			int number;
			cin >> number;
			B[i][j] = number;
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {

			A[i][j] += B[i][j];
		}
	}

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {

			if (A[i][j] >= 100)A[i][j] = 100;
			cout<< A[i][j]<<" ";
		}
		cout << "\n";
	}
	return 0;
}