#include<stdio.h>
#include<iostream>
#include<vector>
using namespace std;

int num[4000000];
bool isPrime(int number) {
	if (number < 2) return false;
	for (int i = 2; i*i <= number; i++) {
		if (number%i == 0)
			return false;
	}
	return true;
}
int main() {

	int N;
	int idx = 0;
	cin >> N;
	for (int i = 1; i <= N; i++) {
		if (isPrime(i))num[idx++]=i;
	}

	int i=0, j = 0;
	int sum = num[i];
	int ret = 0;
	for (int i = 0, j = 0; i <= j && j < idx;) {
		if (sum > N) {
			sum -= num[i];
			i++;
			if (i > j && i < idx) {
				j = i;
				sum = num[i];
			}
		}
		else if (sum < N) {
			j++;
			sum += num[j];
		}
		else if (sum == N) {
			ret++;
			j++;
			sum += num[j];
		}
	}

	cout << ret << endl;

	return 0;
} 