#include<stdio.h>
#include<iostream>
using namespace std;


int GCD_re(int a, int b) {
	if (b == 0) return a;
	return GCD_re(b, a%b);
}

int gcd(int a, int b) {
	while (b != 0) {
		int r = a % b;
		a = b;
		b = r;
	}
	return a;
}

int main() {
	int num1, num2;
	cin >> num1 >> num2;
	/*while (b!=0) {
			int r = a % b;
			a = b;
			b = r;
	}*/
	int gcdNumber = GCD_re(num1, num2);
	cout << gcdNumber << '\n';
	cout << gcdNumber * (num1 / gcdNumber)*(num2 / gcdNumber) << '\n';
	return 0;
}