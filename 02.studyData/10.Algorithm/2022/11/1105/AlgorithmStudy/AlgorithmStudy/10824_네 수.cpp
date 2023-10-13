#include<stdio.h>
#include<iostream>
#include<string>
using namespace std;

int main(void) {
	string A, B, C, D;
	cin >> A >> B >> C >> D;
	A = A += B;
	C = C += D;

	long long num1 = stol(A);
	long long num2 = stol(C);

	cout << num1 + num2 << endl;

	return 0;
}