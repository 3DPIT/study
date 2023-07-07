#include<stdio.h>
#include<iostream>
using namespace std;

int GCD(int num1, int num2) {
	if (num2 == 0) return num1;

	return GCD(num2, num1%num2);
}

int main(void) {
	int testCaseNumber;
	cin >> testCaseNumber;
	for (int tc = 0; tc < testCaseNumber; tc++) {
		int n = 0;
		int arr[104] = { 0, };
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}

		long long sum = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				sum += GCD(arr[i], arr[j]);
			}
		}

		cout << sum << '\n';
	}

	return 0;
}