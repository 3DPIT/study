#include<stdio.h>
#include<iostream>
using namespace std;
bool isPrime(int number) {
	if (number < 2) return false;
	for (int i = 2; i*i <= number; i++) {
		if (number%i == 0)
			return false;
	}
	return true;
}
int main(void) {
	int N;
	int ret=0;
	cin >> N;
	for (int i = 0; i < N; i++) {
		int number;
		cin >> number;
		if (isPrime(number)) {
			ret++;
		}
	}
	cout << ret << '\n';
	return 0;
}