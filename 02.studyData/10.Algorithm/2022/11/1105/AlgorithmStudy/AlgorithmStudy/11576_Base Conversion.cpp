#include<stdio.h>
#include<iostream>
using namespace std;

void conversion(int A, int B)
{
	if (A == 0)return;
	conversion(A / B, B);
	cout << A % B<<" ";
}
int main(void) {
	int A, B;
	int N;
	cin >> A >> B;
	cin >> N;
	int num = 0;
	for (int i = 0; i < N; i++) {
		int x;

		cin >> x;
		num = num * A + x;
	}
	conversion(num, B);
	return 0;
}